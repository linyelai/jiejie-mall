package com.jiejie.mall.web.config;

import com.jiejie.mall.web.constant.MallWebConstant;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {
   /* @Value(MallWebConstant.APPLICATION_NAME)
    private String applicationName;
    @Value(MallWebConstant.REGISTRY_CENTER)
    private String registryCenter;
    @Value(MallWebConstant.PROVIDER_TIME_OUT)
    private Integer timeout;*/

    @Bean
    public ApplicationConfig applicationConfig() {
        // 提供方应用信息，用于计算依赖关系
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("mall-web");
        return applicationConfig;
    }
   @Bean
    public RegistryConfig registryConfig() {
        // 使用zookeeper注册中心暴露服务地址
       RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        // 使用curator客户端
        registryConfig.setClient("curator");
        return registryConfig;
    }

}