/**
 * $Id: FeignCustomRequestInteceptor.java,v 1.0 2018/12/10 6:56 PM
 *
 * @Copyright (c) 2018/12/10,
 */
package com.xt.open.jmall.product.interceptors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * 解决feign get请求不能传输pojo的问题
 *
 * @author
 * @version $Id: FeignCustomRequestInteceptor.java,v 1.0 2018/12/10 6:56 PM
 * @date 2018/12/10 下午6:56 PM
 */
@Component
@Slf4j
public class FeignCustomRequestInteceptor implements RequestInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate template) {
        if (HttpMethod.GET.toString() == template.method() && template.body() != null) {
            //feign 不支持GET方法传输POJO 转换成json，再换成query
            try {
                Map<String, Collection<String>> map = objectMapper.readValue(template.bodyTemplate(), new TypeReference<Map<String, Collection<String>>>() {

                });
                template.body(null);
                template.queries(map);
            } catch (IOException e) {
                log.error("cause exception", e);
            }
        }
    }
}
