package com.pipeline.pipeline_data_sys.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pipeline.pipeline_data_sys.pojo.Category;
import com.pipeline.pipeline_data_sys.pojo.to.CategoryEntity;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 20:22
 * @description：
 */
public class CategoryListen implements ReadListener<CategoryEntity> {

    private CategoryService categoryService;

    public CategoryListen(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private Map<String, Integer> identifier2IdMap = new HashMap<>();
    private List<Category> categoryList = new ArrayList<>();


    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {

    }

    @Override
    public void invoke(CategoryEntity data, AnalysisContext context) {
        // System.out.println(data);
        // 保存数据
        saveOrUpdateCategory(data);
        // 存储完成清理 list

    }

    private void saveOrUpdateCategory(CategoryEntity categoryEntity) {
        if (categoryEntity == null) return;
        Category category = convert(categoryEntity);
        if (category != null) {
            String identifier = category.getIdentifier();
            boolean success;
            if (identifier2IdMap.containsKey(identifier)) { // 重复的编号，修改数据
                Integer categoryId = identifier2IdMap.get(identifier);
                category.setId(categoryId);
                success = categoryService.updateById(category);
            } else { // 创建数据
                success = categoryService.save(category);
            }
            if (!success) {
                throw new RuntimeException("save Category error");
            } else {
                if (!identifier2IdMap.containsKey(identifier)) {
                    Category searchCategory = categoryService.getOne(new QueryWrapper<Category>().eq("identifier", identifier));
                    identifier2IdMap.put(searchCategory.getIdentifier(), searchCategory.getId());
                }
            }
        }

    }

    private Category convert(CategoryEntity entity) {
        if (identifier2IdMap.size() == 0) {
            setMap(categoryService.list());
        }
        Category category = new Category();
        category.setTitle(entity.getTitle());
        category.setAttributeTabName(entity.getAttributeTabName());
        String identifier;
        String parentIdentifier = null;
        if (entity.getLevel2() == null) {
            identifier = entity.getLevel1();
        } else if (entity.getLevel3() == null) {
            identifier = entity.getLevel2();
            parentIdentifier = entity.getLevel1();
        } else if (entity.getLevel4() == null) {
            identifier = entity.getLevel3();
            parentIdentifier = entity.getLevel2();
        } else {
            identifier = entity.getLevel4();
            parentIdentifier = entity.getLevel3();
        }
        // 已经存在
        if (identifier2IdMap.containsKey(identifier)) {
            return null;
        }
        category.setIdentifier(identifier);
        category.setParentId(identifier2IdMap.getOrDefault(parentIdentifier, null));
        return category;
    }

    private void setMap(List<Category> categoryList) {
        for (Category category : categoryList) {
            identifier2IdMap.put(category.getIdentifier(), category.getId());
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

}
