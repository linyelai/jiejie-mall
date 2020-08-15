package com.jiejie.mall.brand;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableApolloConfig
@ComponentScan("com.jiejie.mall.brand.*")
@DubboComponentScan("com.jiejie.mall.brand.*")
@EnableDubbo

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
