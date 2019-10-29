package com.jiejie.mall.member;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableApolloConfig
@ComponentScan("com.jiejie.mall.member.*")
@DubboComponentScan("com.jiejie.mall.member.*")
@EnableDubbo

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
