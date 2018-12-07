/**
 * $Id: WebMvcConfig.java,v 1.0 2018/12/7 11:24 AM wangxiaoteng
 *
 * @Copyright (c) 2018/12/7, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.zuul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类注释，描述
 *
 * @author wangxiaoteng
 * @version $Id: WebMvcConfig.java,v 1.0 2018/12/7 11:24 AM wangxiaoteng
 * @date 2018/12/7 下午11:24 AM
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("*");
    }
}
