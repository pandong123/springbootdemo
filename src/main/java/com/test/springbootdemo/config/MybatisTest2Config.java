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
@MapperScan(basePackages = {"com.test.springbootdemo.sever.*.dao.test2"}, sqlSessionFactoryRef = "test2SqlSessionFactory")
public class MybatisTest2Config {
    @Autowired
    @Qualifier("test2")
    private DataSource test2;

    @Bean
    public SqlSessionFactory test2SqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(test2);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate test2SqlSessionTemplate() throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(test2SqlSessionFactory());
        return template;
    }

}
