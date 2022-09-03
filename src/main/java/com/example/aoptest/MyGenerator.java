package com.example.aoptest;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.OracleQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION: 代码生成器
 * @USER: ejchen
 * @DATE: 2022/9/3 14:47
 */
public class MyGenerator {
    private static final String URL = "jdbc:oracle:thin:@192.168.80.10:1521:orcl";
    // 数据库用户名
    private static final String USERNAME = "wateruser";
    // 数据库密码
    private static final String PASSWORD = "itcast";

    private static final String projectRootPath = System.getProperty("user.dir");

    private static final String parentPackageName = "com.example.aoptest";

    public static void main(String[] args) {
        //目标模块
        String model = "";
        //路径
        String packagePath = projectRootPath + model + "/src/main/java";
        // XML文件的路径
        String mapperXmlPath = projectRootPath + model + "/src/main/resources/mapper";

//        String modelName = scanner("请输入模块！");
//        String modelName = "";
//        String modelPackage1 = "." + modelName;
//        String modelPackage2 = "/" + modelName;
        String modelPackage1 = "";
        String modelPackage2 = "";

        //数据库配置
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig.Builder(URL, USERNAME, PASSWORD)
                .dbQuery(new OracleQuery())
                .schema("WATERUSER")
                //.typeConvert(new MyTypeConvert())
                ;
        // 开始执行代码生成
        FastAutoGenerator.create(dataSourceConfigBuilder)
                // 1. 全局配置
                .globalConfig(builder -> builder
                                // 作者名称
                                .author("ejchen")
                                // 开启覆盖已生成的文件。注释掉则关闭覆盖。
                                // .fileOverride()
                                // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
                                .disableOpenDir()
                                // 指定输出目录。如果指定，Windows生成至D盘根目录下，Linux or MAC 生成至 /tmp 目录下。
                                .outputDir(packagePath)
                                // 开启swagger2.注释掉则默认关闭。
//                         .enableSwagger()
                                // 指定时间策略。
                                .dateType(DateType.ONLY_DATE)
                                // 注释时间策略。
                                .commentDate("yyyy-MM-dd")
                )

                // 2. 包配置
                .packageConfig((scanner, builder) -> builder
                                // 设置父表名
                                .parent(parentPackageName)
//                        .moduleName(scanner.apply("请输入模块名："))
                                // mapper.xml 文件的路径。单模块下，其他文件路径默认即可。
                                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperXmlPath + modelPackage2))
                                .entity("entity" + modelPackage1)
                                .service("service" + modelPackage1)
                                .serviceImpl("service" + modelPackage1 + ".impl")
                                .mapper("mapper" + modelPackage1)
//                        .xml("mapper.xml")
                                .controller("controller" + modelPackage1)
                )

                // 3. 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？生成所有表，请输入[all]：")))
                                .enableCapitalMode()
                                .enableSkipView()
                                .disableSqlFilter()
                                //模糊表匹配(sql 过滤)
//                        .likeTable(new LikeTable("USER"))
                                //增加过滤表前缀
                                .addTablePrefix("T_", "t_")

                                // --1>：Entity实体类策略配置
                                .entityBuilder()
                                // 开启生成实体时生成字段注解。
                                // 会在实体类的属性前，添加[@TableField("nickname")]
                                .enableTableFieldAnnotation()
                                //开启 lombok 模型
                                .enableLombok()
//                                .enableRemoveIsPrefix()
                                .enableActiveRecord()
                                // 逻辑删除字段名(数据库)。
//                                .logicDeleteColumnName("is_delete")
                                // 逻辑删除属性名(实体)。
                                // 会在实体类的该字段属性前加注解[@TableLogic]
//                                .logicDeletePropertyName("isDelete")
                                .formatFileName("%s")

                                .idType(IdType.AUTO)
                                // 会在实体类的该字段上追加注解[@TableField(value = "create_time", fill = FieldFill.INSERT)]
//                                .addTableFills(new Column("create_time", FieldFill.INSERT))
                                // 会在实体类的该字段上追加注解[@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)]
//                                .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                                // --2>：Mapper策略配置
                                .mapperBuilder()
                                // 开启 @Mapper 注解。
                                // 会在mapper接口上添加注解[@Mapper]
                                .enableMapperAnnotation()
                                // 启用 BaseResultMap 生成。
                                // 会在mapper.xml文件生成[通用查询映射结果]配置。
                                .enableBaseResultMap()
                                // 启用 BaseColumnList。
                                // 会在mapper.xml文件生成[通用查询结果列 ]配置
                                .enableBaseColumnList()
                                .formatMapperFileName("%sMapper")
                                .formatXmlFileName("%sMapper")
                                // --3>：service策略配置
                                .serviceBuilder()
                                .formatServiceFileName("I%sService")
                                .formatServiceImplFileName("%sServiceImpl")
                                // --4>：Controller策略配置
                                .controllerBuilder()
                                // 会在控制类中加[@RestController]注解。
                                .enableRestStyle()
                                // 开启驼峰转连字符
                                .enableHyphenStyle()
                                .formatFileName("%sController")

                                .build()
                )
                //自定义配置
                .injectionConfig(builder -> {
                    builder.beforeOutputFile((tableInfo, objectMap) -> {
                        System.out.println("tableInfo: " + tableInfo.toString() + " objectMap: " + objectMap.toString());
                    });
                })
                // 4. 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                //.templateEngine(new BeetlTemplateEngine())
                //.templateEngine(new FreemarkerTemplateEngine())

                // 5. 执行
                .execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入").append(tip).append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
