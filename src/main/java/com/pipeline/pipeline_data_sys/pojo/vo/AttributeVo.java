package com.pipeline.pipeline_data_sys.pojo.vo;

import com.pipeline.pipeline_data_sys.pojo.Attribute;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2022/9/25 11:40
 * @description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeVo {
    private List<Attribute> attributes;

    private String identifier;

    private String title;

    private Long pages;

    private Long total;

}
