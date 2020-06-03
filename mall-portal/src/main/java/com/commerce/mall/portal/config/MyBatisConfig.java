package com.commerce.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by commerce on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.commerce.mall.mapper","com.commerce.mall.portal.dao"})
public class MyBatisConfig {
}
