package com.pipeline.pipeline_data_sys.pojo.to;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 20:20
 * @description：
 */
@Data
@ToString
public class CategoryEntity {
    @ExcelProperty(index = 7)
    private String level1;
    @ExcelProperty(index = 8)
    private String level2;
    @ExcelProperty(index = 9)
    private String level3;
    @ExcelProperty(index = 10)
    private String level4;
    @ExcelProperty(index = 11)
    private String title;
    @ExcelProperty(index = 13)
    private String attributeTabName;
}
