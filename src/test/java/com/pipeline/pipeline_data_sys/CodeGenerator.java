package com.pipeline.pipeline_data_sys;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author ：zsy
 * @date ：Created 2021/12/23 17:36
 * @description：
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取当前目录
        String projectPath = System.getProperty("user.dir");
        // 输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(true);
        // 去Service的I前缀
        gc.setServiceName("%sService");
        // 设置主键策略
        gc.setIdType(IdType.ASSIGN_ID);
        // 数据库时间类型 到 实体类时间类型 对应策略
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        gc.setAuthor("zsy");
        mpg.setGlobalConfig(gc);

        // 设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/pipeline_data_sys?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Asia/Shanghai");
        dsc.setUsername("root");
        dsc.setPassword("333");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("pipeline_data_sys");
        pc.setParent("com.pipeline_data_sys");
        pc.setEntity("pojo");
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("t_attribute");
        // 设置前缀
        sc.setTablePrefix("t_");
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);//是否使用lombok开启注解


        // 设置逻辑删除
        // sc.setLogicDeleteFieldName("deleted");

        //自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        sc.setTableFillList(tableFills);

        //乐观锁配置
        // sc.setVersionFieldName("version");

        // 开启驼峰命名
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(sc);
        mpg.execute();
    }

}
