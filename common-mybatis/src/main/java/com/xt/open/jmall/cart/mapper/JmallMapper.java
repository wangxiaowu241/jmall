package com.xt.open.jmall.cart.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper jmall其他mapper继承此mapper
 *
 * @version $Id: JmallMapper.java,v 1.0 2018/12/9 3:20 PM
 * @date 2018/12/9 下午3:20 PM
 */
public interface JmallMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
