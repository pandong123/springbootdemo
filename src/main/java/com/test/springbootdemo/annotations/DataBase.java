package com.test.springbootdemo.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author：Pandong
 * @Description:自定义切换数据源注解
 * @Date:Created in 17:19 2019/4/4
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
//Retention注解解决annotation（注解）的生命周期
@Target({ElementType.METHOD})
//Target注解决定注解可以加载那些成分上（类或者属性或者方法）
@Documented
//标记注解，表示公共api
public @interface DataBase {
        String value() default "test";
}
