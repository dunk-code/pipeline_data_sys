package com.pipeline.pipeline_data_sys.pojo.vo;

import com.alibaba.fastjson.JSON;

import static com.pipeline.pipeline_data_sys.errorcode.ErrorCode.SUCCESS;

/**
 * @author ：zsy
 * @date ：Created 2022/4/26 20:59
 * @description：统一返回类型
 *
 */
//前端接口统一返回该VO
public class RespVo {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RespVo() {
        this.code = SUCCESS;
        this.msg = "";
    }

    public static RespVo ok(String msg) {
        RespVo r = new RespVo();
        r.msg = msg;
        return r;
    }
    public static RespVo ok() {
        return new RespVo();
    }

    public static RespVo error(int code, String msg) {
        RespVo r = new RespVo();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static RespVo obj(Object object) {
        String msg = JSON.toJSONString(object);
        RespVo r = new RespVo();
        r.msg = msg;
        return r;
    }
}
