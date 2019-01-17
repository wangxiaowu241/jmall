/**
 * $Id: AuthorationFilter.java,v 1.0 2019/1/16 5:01 PM wangxiaoteng
 *
 * @Copyright (c) 2019/1/16, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 权限认证filter
 *
 * @author wangxiaoteng
 * @version $Id: AuthorationFilter.java,v 1.0 2019/1/16 5:01 PM wangxiaoteng
 * @date 2019/1/16 下午5:01 PM
 */
public class AuthorationFilter extends ZuulFilter {
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
        return null;
    }
}
