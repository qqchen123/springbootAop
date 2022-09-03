package com.example.aoptest;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.jupiter.api.Test;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/9/3 15:14
 */
public class OracleGeneratorTest extends BaseGeneratorTest{
    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:oracle:thin:@192.168.80.10:1521:orcl", "wateruser", "itcast")
            .schema("T_AREA")
            .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.execute();
    }
}
