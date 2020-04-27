package com.zth;

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
 * @author Kai
 * @date 2020/4/23 0:14
 */


//代码自动生成器
public class CodeGenerator {
    public static void main(String[] args) {
        //需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略

        //1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zth");
        gc.setOpen(false);
        gc.setFileOverride(false); //是否覆盖
        gc.setServiceName("%sService"); // 去Service的I前缀
        gc.setIdType(IdType.AUTO); //主键策略
        gc.setDateType(DateType.ONLY_DATE); //日期类型
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2. 设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3. 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("module"); //模块名
        pc.setParent("com.zth");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user","table"); // 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);  //设置包命名的规则 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //设置列的命名
        strategy.setEntityLombokModel(true); //自动lombok
        strategy.setLogicDeleteFieldName("deleted"); //逻辑删除自动配置
        /* 自动填充策略 */
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill modifiedTime = new TableFill("modified_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(modifiedTime);
        strategy.setTableFillList(tableFills);
        /* 乐观锁 */
        strategy.setVersionFieldName("version");
        /* 有关Controller层的 */
        strategy.setRestControllerStyle(true); //开启Restful的驼峰命名格式
        strategy.setControllerMappingHyphenStyle(true); // eg.localhost:8080/hello_id_2
        mpg.setStrategy(strategy);

        mpg.execute(); //执行
    }
}
