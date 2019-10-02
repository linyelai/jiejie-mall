package com.jiejie.mall.token.config;

import com.jiejie.mall.token.constant.TokenConstant;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {
   // @Value(TokenConstant.TOKEN_DUBBO_APPLICATION_NAME)
    private String applicationName;
    //@Value(TokenConstant.TOKEN_REGISTRY_CENTER)
    private String registryCenter;
  //  @Value(TokenConstant.TOKEN_DUBBO_PROVIDER_TIME_OUT)
    private Integer timeout;
    @Bean
    public ApplicationConfig applicationConfig() {
        // 提供方应用信息，用于计算依赖关系
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("jiejie.mall.token.provider");
        return applicationConfig;
    }
    @Bean
    public RegistryConfig registryConfig() {
        // 使用zookeeper注册中心暴露服务地址
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        registryConfig.setTimeout(5000);
        // 使用curator客户端
        registryConfig.setClient("curator");
        return registryConfig;
    }

}
