package com.example.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nev on 21.05.16.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public Filter statFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(10000);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }
}
