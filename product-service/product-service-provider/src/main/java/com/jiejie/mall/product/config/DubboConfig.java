package com.jiejie.mall.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Bean
    public org.apache.dubbo.config.ApplicationConfig applicationConfig() {
        // 提供方应用信息，用于计算依赖关系
        org.apache.dubbo.config.ApplicationConfig applicationConfig = new org.apache.dubbo.config.ApplicationConfig();
        applicationConfig.setName("jiejie-mall-product");
        return applicationConfig;
    }
    @Bean
    public org.apache.dubbo.config.RegistryConfig registryConfig() {
        // 使用zookeeper注册中心暴露服务地址
        org.apache.dubbo.config.RegistryConfig registryConfig = new org.apache.dubbo.config.RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        registryConfig.setTimeout(5000);
        // 使用curator客户端
        registryConfig.setClient("curator");
        return registryConfig;
    }

}