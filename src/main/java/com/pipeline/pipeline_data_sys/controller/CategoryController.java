package com.pipeline.pipeline_data_sys.controller;


import com.alibaba.excel.EasyExcel;
import com.pipeline.pipeline_data_sys.listen.CategoryListen;
import com.pipeline.pipeline_data_sys.pojo.to.CategoryEntity;
import com.pipeline.pipeline_data_sys.pojo.vo.CategoryVo;
import com.pipeline.pipeline_data_sys.pojo.vo.RespVo;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import com.pipeline.pipeline_data_sys.util.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

import static com.pipeline.pipeline_data_sys.errorcode.ErrorCode.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zsy
 * @since 2022-09-25
 */
@RestController
@RequestMapping("/pipeline_data_sys/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation("类别列表接口")
    @ResponseBody
    public List<CategoryVo> list() {
        return categoryService.listAll();
    }

    @GetMapping("/{title}/search")
    @ApiOperation("类别搜索接口")
    public List<String> search(@PathVariable String title) {
        return categoryService.searchByTitle(title);
    }


    @PostMapping("/upload")
    @ApiOperation("上传类型表接口")
    public RespVo upload(@RequestParam(name = "image") MultipartFile file) {
        if (!FileUtil.isCorrectForExcel(file.getOriginalFilename())) {
            return RespVo.error(ERROR_FILE_FORMAT, getMsg(ERROR_FILE_FORMAT));
        }
        try {
            File f = new File(FileUtil.getImgStorePath(file));
            file.transferTo(f);
            EasyExcel.read(f, CategoryEntity.class, new CategoryListen(categoryService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
            return RespVo.error(ERROR_File_SAVE_FAIL, getMsg(ERROR_File_SAVE_FAIL));
        }
        System.out.println(file.getOriginalFilename());
        return RespVo.ok(file.getOriginalFilename());
    }


}

