/**
 * $Id: DefaultFeignConfiguration.java,v 1.0 2019/1/8 10:07 PM wangxiaoteng
 *
 * @Copyright (c) 2019/1/8, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.product.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类注释，描述
 *
 * @version $Id: DefaultFeignConfiguration.java,v 1.0 2019/1/8 10:07 PM wangxiaoteng
 * @date 2019/1/8 下午10:07 PM
 */
@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(1000,3000,3);
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
