package com.pipeline.pipeline_data_sys;

import java.util.HashMap;

/**
 * @author ：zsy
 * @date ：Created 2022/4/26 21:04
 * @description：错误码
 */
public class ErrorCode {

    public static int SUCCESS = 100;

    // 登录相关1000-2000
    public static int ERROR_USERNAME_PASSWORD_NIL = 1000;
    public static int ERROR_USERNAME_PASSWORD_FAILED = 1001;

    // 数据库相关2000-3000
    public static int ERROR_DB_UNKNOWN = 2000;

    public static int ERROR_ILLEGAL_PARAMS = 3000;

    public static int ERROR_NO_LOGIN = 4000;


    // 图片操作
    public static int ERROR_FILE_FORMAT = 5000;
    public static int ERROR_IMAGE_SAVE_FAIL = 5001;

    public static int ERROR_UNKNOWN = 6000;

    public static HashMap<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(SUCCESS, "");
        map.put(ERROR_USERNAME_PASSWORD_NIL, "用户名或密码为空");
        map.put(ERROR_USERNAME_PASSWORD_FAILED, "用户名或密码错误");
        map.put(ERROR_DB_UNKNOWN, "未知的DB错误");
        map.put(ERROR_UNKNOWN, "未知的错误");
        map.put(ERROR_NO_LOGIN, "当前状态：未登录");
        map.put(ERROR_ILLEGAL_PARAMS, "非法参数");
        map.put(ERROR_FILE_FORMAT, "文件格式不正确");
        map.put(ERROR_IMAGE_SAVE_FAIL, "保存图片失败");
    }

    public static String getMsg(int code) {
        if (map.get(code) == null) {
            throw new RuntimeException(String.format("code not exist--->%s", code));
        }
        return map.get(code);
    }
}
