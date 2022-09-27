package com.pipeline.pipeline_data_sys.service;

import com.pipeline.pipeline_data_sys.pojo.Attribute;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pipeline.pipeline_data_sys.pojo.vo.AttributeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsy
 * @since 2022-09-25
 */
public interface AttributeService extends IService<Attribute> {

    AttributeVo listByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize, String order);

    List<AttributeVo> searchByCol(String colName, String colValue, Integer pageNum, Integer pageSize, String order);

    AttributeVo listByCategoryId(Integer categoryId, String order);
}
