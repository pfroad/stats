package com.airparking.azkaban.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.session.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

public class DBUtils {
    private static final DataSource datasource;
    private static final SqlSessionFactory sqlSessionFactory;
//    private static final DataSource ds2;
    private static final Integer DEFAULT_POOL_SIZE = 10;
    private static final Integer DEFAULT_MIN_IDLE = 5;
    private static final Long DEFAULT_IDLE_TIMEOUT = 600000L;
    private static final Long DEFAULT_CONNECT_TIMEOUT = 30000L;
    private static final String DEFAULT_MAPPER_PACKAGE = "com.airparking.azkaban.mapper";

    static {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(PropsUtils.get("datasource.driverClass"));
        config.setJdbcUrl(PropsUtils.get("datasource.jdbcUrl"));
        config.setUsername(PropsUtils.get("datasource.username"));
        config.setPassword(PropsUtils.get("datasource.password"));
        config.setMaximumPoolSize(PropsUtils.getInt("datasource.maxPoolSize", DEFAULT_POOL_SIZE));
        config.setMinimumIdle(PropsUtils.getInt("datasource.minIdle", DEFAULT_MIN_IDLE));
        config.setIdleTimeout(PropsUtils.getLong("datasource.idleTimeout", DEFAULT_IDLE_TIMEOUT));
        config.setConnectionTimeout(PropsUtils.getLong("datasource.connectTimeout", DEFAULT_CONNECT_TIMEOUT));
        Boolean readOnly = PropsUtils.getBoolean("datasource.readOnly", false);

        datasource = new HikariDataSource(config);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("", transactionFactory, datasource);
        Configuration configuration = new Configuration();
        configuration.setMapperHelper(new MapperHelper());
        configuration.setEnvironment(environment);
        configuration.addMappers(DEFAULT_MAPPER_PACKAGE, Mapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//        Properties dbProps = PropsUtils.resolveProps("datasource.properties");

    }

    public static DataSource getDetaultDateSource() {
        return datasource;
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void close() {
        if (datasource != null) {
            ((HikariDataSource) datasource).close();
        }
    }
}
