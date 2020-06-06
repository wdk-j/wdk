package com.commerce.mall.config;

import cn.hutool.core.io.resource.ResourceUtil;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author jiangyong
 * @date 2020.06.06
 */
@Configuration
public class ImgConfig extends WebMvcConfigurerAdapter {

    /**
     * hostname:/image/AA/BB/abc.abc 可以访问此module的 classpath:/images/upload/AA/BBabc.abc
     * hostname:/upload/AA/BB/abc.abc 可以访问此project主目录的 /upload/AA/BB/abc.abc
     * <p>
     * 这里采用第二种方式
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/image/**").
//                    addResourceLocations(ResourceUtils.FILE_URL_PREFIX + ResourceUtils.getURL("classpath:")
//                            .getPath() + "images" + File.separator + "upload" + File.separator);
        registry.addResourceHandler("/upload/**").
                addResourceLocations(ResourceUtils.FILE_URL_PREFIX + System.getProperty("user.dir") + File.separator
                        + "upload" + File.separator);

    }
}
