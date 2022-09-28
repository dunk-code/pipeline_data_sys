package com.pipeline.pipeline_data_sys.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pipeline.pipeline_data_sys.listen.AttributeListen;
import com.pipeline.pipeline_data_sys.pojo.Attribute;
import com.pipeline.pipeline_data_sys.pojo.to.AttributeEntity;
import com.pipeline.pipeline_data_sys.pojo.vo.AttributeColVo;
import com.pipeline.pipeline_data_sys.pojo.vo.AttributeVo;
import com.pipeline.pipeline_data_sys.pojo.vo.RespVo;
import com.pipeline.pipeline_data_sys.service.AttributeService;
import com.pipeline.pipeline_data_sys.service.CategoryService;
import com.pipeline.pipeline_data_sys.util.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/pipeline_data_sys/attribute")
public class AttributeController {

    public static Map<String, String> colMap = new HashMap<>();

    static {
        colMap.put("tab_name", "表名");
        colMap.put("english_name", "英文名称");
        colMap.put("chinese_name", "中文名称");
        colMap.put("description", "字段描述");
        colMap.put("unit", "单位");
        colMap.put("type_precision", "类型与精度");
        colMap.put("range_constraint", "值域/约束");
        // colMap.put("类别编号", "category_identifier");
        // colMap.put("类别名", "category_title");
        colMap.put("reference_variable", "引用变量");
        colMap.put("type_code", "类别码");
    }

    @Autowired
    AttributeService attributeService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/{categoryId}")
    @ApiOperation("属性表分页接口")
    @ResponseBody
    public AttributeVo listByCategoryIdPaged(
            @PathVariable() Integer categoryId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String order) {
        return attributeService.listByCategoryId(categoryId, pageNum, pageSize, order);
    }

    @GetMapping("/{categoryId}/list")
    @ApiOperation("属性表全量接口")
    @ResponseBody
    public AttributeVo listByCategoryId(
            @PathVariable() Integer categoryId,
            @RequestParam(defaultValue = "id") String order) {
        return attributeService.listByCategoryId(categoryId, order);
    }

    @GetMapping("/cols")
    @ApiOperation("展示列名接口")
    @ResponseBody
    public List<AttributeColVo> listCols() {
        return getColList(colMap);
    }

    public List<AttributeColVo> getColList(Map<String, String> colMap) {
        List<AttributeColVo> attributeColVos = new ArrayList<>();
        for (Map.Entry<String, String> entry : colMap.entrySet()) {
            attributeColVos.add(new AttributeColVo(entry.getValue(), entry.getKey()));
        }
        return attributeColVos;
    }

    @GetMapping("/{colName}/search/{colValue}")
    @ApiOperation("匹配接口")
    @ResponseBody
    public List<AttributeVo> searchByCol(
            @PathVariable() String colName,
            @PathVariable() String colValue,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "category_id") String order) {
        return attributeService.searchByCol(colName, colValue, pageNum, pageSize, order);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除接口")
    @ResponseBody
    public RespVo deleteByIdOrAll(@RequestParam(defaultValue = "") Integer id) {
        boolean success = attributeService.removeByIdOrAll(id);
        return success ? RespVo.ok() : RespVo.error(ERROR_DB_UNKNOWN, getMsg(ERROR_DB_UNKNOWN));
    }

    @PostMapping("/import")
    @ApiOperation("上传属性表接口(如果无法保证excel中都是最新数据，需要先调用delete接口删除所有数据，并且全量导入)")
    public RespVo upload(@RequestParam(name = "image") MultipartFile file) {
        if (!FileUtil.isCorrectForExcel(file.getOriginalFilename())) {
            return RespVo.error(ERROR_FILE_FORMAT, getMsg(ERROR_FILE_FORMAT));
        }
        try {
            File f = new File(FileUtil.getImgStorePath(file));
            file.transferTo(f);
            EasyExcel.read(f, AttributeEntity.class, new AttributeListen(attributeService, categoryService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
            return RespVo.error(ERROR_File_SAVE_FAIL, getMsg(ERROR_File_SAVE_FAIL));
        }
        System.out.println(file.getOriginalFilename());
        return RespVo.ok(file.getOriginalFilename());
    }
}

