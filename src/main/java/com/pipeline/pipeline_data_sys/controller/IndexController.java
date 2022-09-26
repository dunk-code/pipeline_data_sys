package com.pipeline.pipeline_data_sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：zsy
 * @date ：Created 2022/9/25 19:56
 * @description：
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}
