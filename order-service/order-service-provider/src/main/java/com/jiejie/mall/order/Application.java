package com.jiejie.mall.order;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableApolloConfig
@ComponentScan("com.jiejie.mall.order.*")
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
