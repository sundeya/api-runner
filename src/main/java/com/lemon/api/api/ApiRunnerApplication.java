package com.lemon.api.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan(basePackages = {"com.lemon.api.api.dao"})
@ComponentScan(basePackages={"com.lemon.api.api.Controller","com.lemon.api.api.service.**","com.lemon.api.api.shiro"})
public class ApiRunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRunnerApplication.class, args);
    }

}
