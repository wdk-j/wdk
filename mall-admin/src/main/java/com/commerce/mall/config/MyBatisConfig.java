package com.commerce.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.commerce.mall.mapper", "com.commerce.mall.custom.dao","com.commerce.mall.dao"})
public class MyBatisConfig {

}
