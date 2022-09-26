package com.pipeline.pipeline_data_sys.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author ：zsy
 * @date ：Created 2022/9/26 22:23
 * @description：
 */
public class FileUtil {
    public static String projectExcelPath = System.getProperty("user.dir") + File.separator + "excel" + File.separator;

    static {
        File file = new File(projectExcelPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static boolean isCorrectForExcel(String filename) {
        String suffix = getImgSuffix(filename);
        if (".xlsx".equals(suffix) || ".xls".equals(filename)){
            return true;
        }
        return false;
    }

    public static String getImgSuffix(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    public static String getImgStorePath(MultipartFile file) {

        return projectExcelPath + file.getOriginalFilename();
    }
}
