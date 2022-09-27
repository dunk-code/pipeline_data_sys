package com.pipeline.pipeline_data_sys;

import com.pipeline.pipeline_data_sys.service.AttributeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：zsy
 * @date ：Created 2022/9/27 21:29
 * @description：
 */
@SpringBootTest
public class AttributeTests {

    @Autowired
    AttributeService attributeService;

    @Test
    void testListByCategoryId() {
        System.out.println(attributeService.listByCategoryId(83, "id"));
    }
}
