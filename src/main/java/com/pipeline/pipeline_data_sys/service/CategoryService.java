package com.pipeline.pipeline_data_sys.service;

import com.pipeline.pipeline_data_sys.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pipeline.pipeline_data_sys.pojo.vo.CategoryVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zsy
 * @since 2022-09-25
 */
public interface CategoryService extends IService<Category> {

    List<CategoryVo> listAll();

    List<String> searchByTitle(String title);
}
