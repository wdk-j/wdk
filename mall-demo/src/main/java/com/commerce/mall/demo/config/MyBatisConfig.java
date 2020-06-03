package com.commerce.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by commerce on 2019/4/8.
 */
@Configuration
@MapperScan("com.commerce.mall.mapper")
public class MyBatisConfig {

}
