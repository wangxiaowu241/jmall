package com.xt.open.jmall.cart.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * jmall 通用mapper 父类 其他mapper继承此mapper
 *
 * @version $Id: JmallMapper.java,v 1.0 2018/12/9 4:16 PM
 * @date 2018/12/9 下午4:16 PM
 */
public interface JmallMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
