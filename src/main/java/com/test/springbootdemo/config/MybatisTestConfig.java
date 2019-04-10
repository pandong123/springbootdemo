package com.test.springbootdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.test.springbootdemo.sever.*.dao.test"}, sqlSessionFactoryRef = "testSqlSessionFactory")
public class MybatisTestConfig {
    @Autowired
    @Qualifier("test")
    private DataSource test;

    @Bean
    public SqlSessionFactory testSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(test);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate testSqlSessionTemplate() throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(testSqlSessionFactory());
        return template;
    }

}
