package com.example.mybatis_plus_generator;

import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/1 15:39
 * @desc
 */
public class GeneratorServiceEntity {

    public static void main(String[] args){
        String packageName = "com.baomidou.springboot";
        boolean serviceNameStartWithI = true;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "act_evt_log","act_ge_bytearray","act_ge_property","act_hi_actinst","act_hi_attachment",
                "act_hi_comment","act_hi_detail","act_hi_identitylink","act_hi_procinst","act_hi_taskinst","act_hi_varinst","act_id_group","act_id_info",
                "act_id_membership","act_id_user","act_procdef_info","act_re_deployment","act_re_model","act_re_procdef","act_ru_deadletter_job",
                "act_ru_event_subscr","act_ru_execution","act_ru_identitylink","act_ru_job","act_ru_suspended_job","act_ru_task",
                "act_ru_timer_job","act_ru_variable");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/activiti";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("yanzhitao")
                .setOutputDir("d:\\codeGen")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
