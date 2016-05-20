package com.example.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;

/**
 * Created by nev on 20.05.16.
 */
@Configuration
public class DatabaseConfiguration {

    @Autowired
    private Filter statFilter;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setValidationQuery("'x'SELECT");
        dataSource.addFilters("stat");
        dataSource.setProxyFilters(Collections.singletonList(statFilter));
        return dataSource;
    }
}
