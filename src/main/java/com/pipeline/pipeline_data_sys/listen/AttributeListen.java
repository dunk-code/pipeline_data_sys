package com.pipeline.pipeline_data_sys.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pipeline.pipeline_data_sys.pojo.Attribute;
import com.pipeline.pipeline_data_sys.pojo.Category;
import com.pipeline.pipeline_data_sys.pojo.to.AttributeEntity;
import com.pipeline.pipeline_data_sys.pojo.to.CategoryEntity;
import com.pipeline.pipeline_data_sys.service.AttributeService;
import com.pipeline.pipeline_data_sys.service.CategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 22:01
 * @description：
 */
public class AttributeListen implements ReadListener<AttributeEntity> {

    private AttributeService attributeService;

    private CategoryService categoryService;

    public AttributeListen(AttributeService attributeService, CategoryService categoryService) {
        this.attributeService = attributeService;
        this.categoryService = categoryService;
    }

    private Map<String, Integer> tabName2CategoryIdMap = new HashMap<>();
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    /**
     * 缓存的数据
     */
    private List<AttributeEntity> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */

    @Override
    public void invoke(AttributeEntity data, AnalysisContext context) {
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveBatch(cachedDataList);
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    private void saveBatch(List<AttributeEntity> cachedDataList) {
        if (tabName2CategoryIdMap.size() == 0) {
            setMap();
        }
        List<Attribute> list = new ArrayList<>();
        for (AttributeEntity attributeEntity : cachedDataList) {
            Attribute attribute = new Attribute();
            String tabName = attributeEntity.getTabName();
            Integer categoryId = tabName2CategoryIdMap.getOrDefault(tabName, null);
            attribute.setCategoryId(categoryId);
            attribute.setChineseName(attributeEntity.getChineseName());
            attribute.setEnglishName(attributeEntity.getEnglishName());
            attribute.setTabName(tabName);
            attribute.setCategoryId(categoryId);
            attribute.setDescription(attributeEntity.getDescription());
            attribute.setRangeConstraint(attributeEntity.getRangeConstraint());
            attribute.setTypePrecision(attributeEntity.getTypePrecision());
            attribute.setUnit(attributeEntity.getUnit());
            list.add(attribute);
        }
        attributeService.saveBatch(list);
    }

    private void setMap() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("attribute_tab_name", "");
        List<Category> categories = categoryService.list(queryWrapper);
        for (Category category : categories) {
            if (category.getAttributeTabName() != null) {
                tabName2CategoryIdMap.put(category.getAttributeTabName(), category.getId());
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveBatch(cachedDataList);
    }
}
