package com.pipeline.pipeline_data_sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pipeline.pipeline_data_sys.mapper.CategoryMapper;
import com.pipeline.pipeline_data_sys.pojo.Attribute;
import com.pipeline.pipeline_data_sys.mapper.AttributeMapper;
import com.pipeline.pipeline_data_sys.pojo.Category;
import com.pipeline.pipeline_data_sys.pojo.vo.AttributeVo;
import com.pipeline.pipeline_data_sys.service.AttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.pipeline.pipeline_data_sys.controller.AttributeController.colMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-09-25
 */
@Service
public class AttributeServiceImpl extends ServiceImpl<AttributeMapper, Attribute> implements AttributeService {

    @Autowired
    public AttributeMapper attributeMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public AttributeVo listByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize, String order) {
        // 分页查询
        Page<Attribute> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Attribute> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc(order).eq("category_id", categoryId);
        attributeMapper.selectPage(page, wrapper);
        List<Attribute> attributes = page.getRecords();
        // 总页数
        long pages = page.getPages();
        long total = page.getTotal();
        if (pageNum < 0 || pageNum > pages) return null;
        return new AttributeVo(attributes, "", "", pages, total);
    }

    @Override
    public List<AttributeVo> searchByCol(String colName, String colValue, Integer pageNum, Integer pageSize, String order) {
        // 分页查询
        Page<Attribute> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Attribute> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc(order);
        if (colMap.containsKey(colName)) {
            wrapper.eq(colName, colValue);
        } else {
            return new ArrayList<>();
        }
        attributeMapper.selectPage(page, wrapper);
        // 总页数
        long pages = page.getPages();
        long total = page.getTotal();
        if (pageNum < 0 || pageNum > pages) return null;
        List<Attribute> attributes = page.getRecords();
        // 分类attributes
        return sortOut(attributes, pages, total);
    }

    @Override
    public AttributeVo listByCategoryId(Integer categoryId, String order) {
        QueryWrapper<Attribute> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc(order).eq("category_id", categoryId);
        List<Attribute> attributes = this.list(wrapper);
        return new AttributeVo(attributes, "", "", null, null);
    }

    @Override
    public boolean removeByIdOrAll(Integer id) {
        QueryWrapper<Attribute> wrapper = new QueryWrapper<>();
        if (id == null) {
            wrapper.ge("id", 0);
        } else {
            wrapper.eq("id", id);
        }
        return this.remove(wrapper);
    }

    private List<AttributeVo> sortOut(List<Attribute> attributes, long pages, long total) {
        List<Integer> categoryIdList = new ArrayList<>();
        Map<Integer, AttributeVo> categoryId2AttributeVoMap = new HashMap<>();
        // 1、获取需要查询的category
        for (Attribute a : attributes) {
            if (a == null) continue;
            Integer categoryId = a.getCategoryId();
            AttributeVo attributeVo = null;
            if (!categoryId2AttributeVoMap.containsKey(categoryId)) {
                categoryIdList.add(categoryId);
                List<Attribute> list = new ArrayList<>();
                list.add(a);
                attributeVo = new AttributeVo(list, "", "", pages, total);
            } else {
                attributeVo = categoryId2AttributeVoMap.get(categoryId);
                attributeVo.getAttributes().add(a);
            }
            categoryId2AttributeVoMap.put(categoryId, attributeVo);
        }
        // 2、批量查询category
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.in("id", categoryIdList);
        List<Category> categories = categoryMapper.selectList(wrapper);
        Map<Integer, Category> id2CategoryMap = new HashMap<>();
        for (Category category : categories) {
            if (category == null) continue;
            id2CategoryMap.put(category.getId(), category);
        }
        // 3、拼装AttributeVo list
        List<AttributeVo> ans = new ArrayList<>();
        for (Map.Entry<Integer, AttributeVo> entry : categoryId2AttributeVoMap.entrySet()) {
            Integer categoryId = entry.getKey();
            AttributeVo attributeVo = entry.getValue();
            Category category = id2CategoryMap.getOrDefault(categoryId, null);
            if (category == null) {
                ans.add(attributeVo);
                continue;
            }
            attributeVo.setIdentifier(category.getIdentifier());
            attributeVo.setTitle(category.getTitle());
            ans.add(attributeVo);
        }
        ans.sort(Comparator.comparingInt(o -> o.getAttributes().get(0).getCategoryId()));
        return ans;
    }
}