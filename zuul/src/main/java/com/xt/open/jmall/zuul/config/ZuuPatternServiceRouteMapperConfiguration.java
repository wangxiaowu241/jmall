/**
 * $Id: ZuulConfiguration.java,v 1.0 2019/1/15 5:44 PM wangxiaoteng
 *
 * @Copyright (c) 2019/1/15, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.zuul.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类注释，描述
 *
 * @author wangxiaoteng
 * @version $Id: ZuulConfiguration.java,v 1.0 2019/1/15 5:44 PM wangxiaoteng
 * @date 2019/1/15 下午5:44 PM
 */
@Configuration
public class ZuuPatternServiceRouteMapperConfiguration {

    /**
     * 获取没有版本号的路由匹配规则bean
     *
     * @return {@link PatternServiceRouteMapper}
     * @author wangxiaoteng
     * @date 10:27 AM 2019/1/17
     **/
    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper() {

        return new PatternServiceRouteMapper("(?<version>v.*$)", "${name}");
    }

    
    @Bean
    @ConditionalOnMissingBean(value = PatternServiceRouteMapper.class)
    public PatternServiceRouteMapper patternServiceRouteMapperWithVersion() {
        return new PatternServiceRouteMapper("(?<name>.*)-(?<version>v.*$)", "${version}/${name}");

    }

}
