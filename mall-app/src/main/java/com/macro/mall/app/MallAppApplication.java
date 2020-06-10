package com.macro.mall.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.macro.mall")
public class MallAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAppApplication.class,args);
    }
}
