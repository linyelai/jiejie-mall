package com.jiejie.mall.shardingsphere.config;


import javax.annotation.Resource;
import javax.sql.DataSource;

public class AppConfig {

    @Resource
    private DataSource dataSource;
}
