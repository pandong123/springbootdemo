package com.test.springbootdemo.core;

public class LocalDataSource {
    public static final String TEST = "test";
    public static final String TEST2 = "test2";
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    // 设置数据源名
    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
