package com.shiyifan;

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

public class autocodegenerator {
    public static void main(String[] args) {
        AutoGenerator mpg=new AutoGenerator();
        //配置策略

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("shiyifan");
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//去除ServiceI前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:sqlserver://111.231.112.198:49978;database=mybatis");
        dataSourceConfig.setUsername("noahsark");
        dataSourceConfig.setPassword("Syf1998.");
        dataSourceConfig.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceConfig.setDbType(DbType.SQL_SERVER);
        mpg.setDataSource(dataSourceConfig);

        //3、配置包
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("Test");
        packageConfig.setParent("com.shiyifan");
        packageConfig.setEntity("pojo");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setMapper("mapper");
        mpg.setPackageInfo(packageConfig);


        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置要映射的表，重点修改,可以同时传递多个参数
        strategy.setInclude("myuser");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自动lombok
        strategy.setEntityLombokModel(true);
        //逻辑删除
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充
        TableFill createTimeinsert = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTimeinsert = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tablefills = new ArrayList<>();
        tablefills.add(createTimeinsert);
        tablefills.add(updateTimeinsert);
        strategy.setTableFillList(tablefills);
        //乐观锁
        strategy.setVersionFieldName("version");
        //驼峰命名
        strategy.setRestControllerStyle(true);
        //localhost:8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);


        mpg.execute();

    }
}
