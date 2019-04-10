package com.test.springbootdemo.core;

import com.test.springbootdemo.annotations.DataBase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
*@Author：Pandong
*@Description：切面实现
*@Date:Created in 11:01 2019/4/4
*@Modified By:
*/
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(com.test.springbootdemo.annotations.DataBase)")
    public void beforeSwitchDs(JoinPoint point){
        //获得当前访问的calss
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法
        String methodName = point.getSignature().getName();
        //获取方法的参数类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSoure = LocalDataSource.TEST;
        try{
            //获得访问的方法对象
            Method method = className.getMethod(methodName,argClass);
            //判断是否存在@DS注解
            if(method.isAnnotationPresent(DataBase.class)){
                DataBase annotation = method.getAnnotation(DataBase.class);
                dataSoure = annotation.value();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //切换数据源
        LocalDataSource.setDB(dataSoure);
     }

     @After("@annotation(com.test.springbootdemo.annotations.DataBase)")
     public void afterSwitchDS(JoinPoint point){
        LocalDataSource.clearDB();
     }
}
