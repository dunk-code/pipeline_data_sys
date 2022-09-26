package com.pipeline.pipeline_data_sys;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.pipeline.pipeline_data_sys.listen.CategoryListen;
import com.pipeline.pipeline_data_sys.pojo.to.CategoryEntity;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 20:28
 * @description：
 */
@SpringBootTest
public class CategoryExcelTests {

    @Autowired
    CategoryService categoryService;

    @Test
    void test() {
        String fileName = System.getProperty("user.dir") + File.separator + "excel" + File.separator + "demo.xlsx";
        File file = new File(fileName);
        EasyExcel.read(file, CategoryEntity.class, new ReadListener<CategoryEntity>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 5;
            /**
             * 临时存储
             */
            private List<CategoryEntity> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(CategoryEntity data, AnalysisContext context) {
                System.out.println(data);
                /*cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    System.out.println(cachedDataList);
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }*/
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {

            }
        }).sheet().doRead();
    }

    @Test
    void testMyListen() {
        String fileName = System.getProperty("user.dir") + File.separator + "excel" + File.separator + "demo.xlsx";
        File file = new File(fileName);
        EasyExcel.read(file, CategoryEntity.class, new CategoryListen(categoryService)).sheet().doRead();
    }
}
