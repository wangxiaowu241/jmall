/**
 * $Id: FeignRetryConfig.java,v 1.0 2018/12/10 11:58 AM wangxiaoteng
 *
 * @Copyright (c) 2018/12/10, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.product.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类注释，描述
 *
 * @version $Id: FeignRetryConfig.java,v 1.0 2018/12/10 11:58 AM wangxiaoteng
 * @date 2018/12/10 下午11:58 AM
 */
@Configuration
public class FeignRetryConfig {

    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }

}
