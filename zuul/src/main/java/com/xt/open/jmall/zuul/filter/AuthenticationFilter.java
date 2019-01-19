/**
 * $Id: AuthenticationFilter.java,v 1.0 2019/1/16 5:01 PM wangxiaoteng
 *
 * @Copyright (c) 2019/1/16, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xt.open.jmall.zuul.exception.TokenNotValidException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限认证filter
 *
 * @author wangxiaoteng
 * @version $Id: AuthenticationFilter.java,v 1.0 2019/1/16 5:01 PM wangxiaoteng
 * @date 2019/1/16 下午5:01 PM
 */
public class AuthenticationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String token = request.getHeader("X-Authentication");
        if (StringUtils.isBlank(token)) {
            throw new TokenNotValidException("token不存在！");
        }
        //校验token正确性
        return null;
    }
}
