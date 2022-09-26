package com.pipeline.pipeline_data_sys.pojo.vo;

import com.pipeline.pipeline_data_sys.pojo.Category;
import lombok.Data;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2022/9/25 1:22
 * @description：
 */
@Data
public class CategoryVo {
    private Category category;
    private List<CategoryVo> sonCategory;

    public CategoryVo(Category category) {
        this.category = category;
    }
}
