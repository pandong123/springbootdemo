package com.test.springbootdemo.config;

import com.test.springbootdemo.core.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean(name = "test")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource test(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2(){
        return DataSourceBuilder.create().build();
    }

    /**
    *@Author:Pandong
    *@Description:创建动态数据源，切换数据源
    *@param:
    *@Date:10:47 2019/4/4
    */
    @Bean
    public DataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(test());
        Map<Object,Object> dsmap = new HashMap<Object,Object>(5);
        dsmap.put("test",test());
        dsmap.put("test2",test2());
        dynamicDataSource.setTargetDataSources(dsmap);
        return dynamicDataSource;
    }

}
