package com.pipeline.pipeline_data_sys.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsy
 * @since 2022-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_attribute")
@ApiModel(value="Attribute对象", description="")
public class Attribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表名")
    private String tabName;

    @ApiModelProperty(value = "类别id")
    private Integer categoryId;

    @ApiModelProperty(value = "类别编号")
    private String categoryIdentifier;

    @ApiModelProperty(value = "类别名称")
    private String categoryTitle;

    @ApiModelProperty(value = "英文名")
    private String englishName;

    @ApiModelProperty(value = "中文名")
    private String chineseName;

    @ApiModelProperty(value = "字段描述")
    private String description;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "类型与精度")
    private String typePrecision;

    @ApiModelProperty(value = "范围与约束")
    private String rangeConstraint;

    @ApiModelProperty(value = "引用变量")
    private String referenceVariable;

    @ApiModelProperty(value = "类别码")
    private String typeCode;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
