package usts.pycro.maventestplace.util;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;
import usts.pycro.maventestplace.entity.BaseEntity;

import javax.sql.DataSource;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-10 14:25
 * ----------------------
 * 支持以下8种类型的产物
 * Entity 实体类
 * Mapper 映射类
 * TableDef 表定义辅助类
 * Service 服务类
 * ServiceImpl 服务实现类
 * Controller 控制类
 * MapperXml 文件
 * package-info.java 文件
 */
public class CodeGen {

    public static final String DEFAULT_USERNAME = "root";
    public static final String DEFAULT_PASSWORD = "12345678";

    public static void main(String[] args) {
        // 配置数据源
        DataSource dataSource = createDataSourceConfig("index_demo");

        // 创建配置内容
        GlobalConfig globalConfig = createGlobalConfig();

        // 通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        // 生成代码
        generator.generate();
    }

    public static DataSource createDataSourceConfig(String dbName) {
        return createDataSourceConfig(dbName, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }

    public static DataSource createDataSourceConfig(String dbName, String username, String password) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(String.format("jdbc:mysql://localhost:3306/%s?useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true", dbName));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    public static GlobalConfig createGlobalConfig() {
        // 创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        // 注释配置
        globalConfig.getJavadocConfig()
                .setAuthor("Pycro");

        // 设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("usts.pycro.maventestplace");

        // 设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setGenerateTable("account_copy1", "account_copy2");


        // 设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setSuperClass(BaseEntity.class);

        // 设置生成 mapper
        globalConfig.enableMapper()
                .setMapperAnnotation(true);

        // 设置生成service
        globalConfig.enableService();

        // 设置生成serviceImpl
        globalConfig.enableServiceImpl();

        // 设置生成Controller
        globalConfig.enableController();

        // 可以单独配置某个列
        /*ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
        globalConfig.getStrategyConfig()
                .setColumnConfig("tb_account", columnConfig);*/

        return globalConfig;
    }
}
