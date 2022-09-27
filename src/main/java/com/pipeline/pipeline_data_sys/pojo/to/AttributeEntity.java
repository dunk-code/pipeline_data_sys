package com.pipeline.pipeline_data_sys.pojo.to;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 22:02
 * @description：
 */
@Data
@ToString
public class AttributeEntity {
    @ExcelProperty(index = 0)
    private String englishName;

    @ExcelProperty(index = 1)
    private String chineseName;

    @ExcelProperty(index = 2)
    private String description;

    @ExcelProperty(index = 3)
    private String unit;

    @ExcelProperty(index = 4)
    private String typePrecision;

    @ExcelProperty(index = 5)
    private String rangeConstraint;

    @ExcelProperty(index = 6)
    private String tabName;

    @ExcelProperty(index = 7)
    private String referenceVariable;

    @ExcelProperty(index = 8)
    private String typeCode;
}
