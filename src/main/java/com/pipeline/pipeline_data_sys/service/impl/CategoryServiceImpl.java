package com.pipeline.pipeline_data_sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pipeline.pipeline_data_sys.pojo.Category;
import com.pipeline.pipeline_data_sys.mapper.CategoryMapper;
import com.pipeline.pipeline_data_sys.pojo.vo.CategoryVo;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-09-25
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryVo> listAll() {
        List<Category> categoryList = this.list();
        List<CategoryVo> root = new ArrayList<>();
        Map<Integer, List<CategoryVo>> parentId2CategoryVosMap = new HashMap<>();
        Queue<CategoryVo> queue = new LinkedList<>();
        // 1、找到所有有的根节点  2、将parentId和对应子节点加入map
        for (Category category : categoryList) {
            CategoryVo categoryVo = new CategoryVo(category);
            Integer parentId = category.getParentId();
            if (parentId == null) {
                root.add(categoryVo);
            } else {
                List<CategoryVo> sonCategory = parentId2CategoryVosMap.getOrDefault(parentId, new ArrayList<>());
                sonCategory.add(categoryVo);
                parentId2CategoryVosMap.put(parentId, sonCategory);
            }
        }
        // 3、根节点入队列
        for (CategoryVo categoryVo : root) {
            queue.offer(categoryVo);
        }
        // 4、bfs连接整棵树
        while (!queue.isEmpty()) {
            CategoryVo categoryVo = queue.poll();
            if (categoryVo == null || categoryVo.getCategory() == null) {
                continue;
            }
            Integer id = categoryVo.getCategory().getId();
            List<CategoryVo> sonCategoryVos = parentId2CategoryVosMap.get(id);
            if (sonCategoryVos == null || sonCategoryVos.size() == 0) continue;
            for (CategoryVo sc : sonCategoryVos) {
                queue.offer(sc);
            }
            categoryVo.setSonCategory(sonCategoryVos);
        }
        return root;
    }

    @Override
    public List<String> searchByTitle(String title) {
        List<String> ans = new ArrayList<>();
        if (title == null || title.equals("")) return ans;
        List<Category> categories = this.list();
        Map<Integer, Integer> id2ParentId = new HashMap<>();
        Integer id = 0;
        for (Category category : categories) {
            if (category == null) continue;
            if (category.getParentId() != null) {
                id2ParentId.put(category.getId(), category.getParentId());
            }
            if (id == 0 && category.getTitle() != null && category.getTitle().contains(title)) {
                id = category.getId();
            }
        }
        if (id == 0) return ans;
        ans.add(id + "");
        while (id2ParentId.containsKey(id)) {
            id = id2ParentId.get(id);
            ans.add(id + "");
        }
            Collections.reverse(ans);
        return ans;
    }
}
