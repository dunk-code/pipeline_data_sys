package com.pipeline.pipeline_data_sys;

import com.alibaba.excel.EasyExcel;
import com.pipeline.pipeline_data_sys.listen.AttributeListen;
import com.pipeline.pipeline_data_sys.listen.CategoryListen;
import com.pipeline.pipeline_data_sys.pojo.to.AttributeEntity;
import com.pipeline.pipeline_data_sys.pojo.to.CategoryEntity;
import com.pipeline.pipeline_data_sys.service.AttributeService;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 22:15
 * @description：
 */
@SpringBootTest
public class AttributeExcelTests {

    @Autowired
    CategoryService categoryService;

    @Autowired
    AttributeService attributeService;

    @Test
    void test() {
        String fileName = System.getProperty("user.dir") + File.separator + "excel" +
                File.separator + "demo1.xlsx";
        File file = new File(fileName);
        EasyExcel.read(file, AttributeEntity.class, new
                AttributeListen(attributeService, categoryService)).sheet().doRead();
    }
}
