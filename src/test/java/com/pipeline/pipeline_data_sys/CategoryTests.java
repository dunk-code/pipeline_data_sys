package com.pipeline.pipeline_data_sys;

import com.pipeline.pipeline_data_sys.pojo.vo.CategoryVo;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2022/9/25 12:02
 * @description：
 */
@SpringBootTest
public class CategoryTests {

    @Autowired
    CategoryService categoryService;

    @Test
    void testListAll() {
        List<CategoryVo> categoryVos = categoryService.listAll();
        listCategory(categoryVos);
    }

    void listCategory(List<CategoryVo> categoryVos) {
        /*Queue<CategoryVo> queue = new LinkedList<>();
        for (CategoryVo categoryVo : categoryVos) {
            queue.offer(categoryVo);
        }*/
        String prefix = "";
        dfs(categoryVos, prefix);
        /*while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                CategoryVo categoryVo = queue.poll();
                if (categoryVo == null) {
                    continue;
                }
                System.out.println(prefix.toString() + categoryVo.getCategory().getId());
                List<CategoryVo> sonCategory = categoryVo.getSonCategory();
                if (sonCategory == null) continue;
                for (CategoryVo cv : sonCategory) {
                    queue.offer(cv);
                }
            }
            prefix.append("\t");
        }*/
    }

    private void dfs(List<CategoryVo> categoryVos, String prefix) {
        if (categoryVos == null) return;
        for (CategoryVo categoryVo : categoryVos) {
            if (categoryVo == null || categoryVo.getCategory() == null) continue;
            System.out.println(prefix + categoryVo.getCategory().getId() + "->" + categoryVo.getCategory().getAttributeTabName());
            List<CategoryVo> sonCategory = categoryVo.getSonCategory();
            if (sonCategory == null || sonCategory.size() == 0) continue;
            String newPrefix = prefix + "\t";
            dfs(sonCategory, newPrefix);
        }
    }

    @Test
    void testSearchByIdentifier() {
        System.out.println(categoryService.searchByIdentifier("G010699"));
    }
}
