/**
 * $Id: TokenNotValidException.java,v 1.0 2019/1/18 2:14 PM
 *
 * @Copyright (c) 2019/1/18,
 */
package com.xt.open.jmall.zuul.exception;

/**
 * token 不合法异常
 *
 * @version $Id: TokenNotValidException.java,v 1.0 2019/1/18 2:14 PM
 * @date 2019/1/18 下午2:14 PM
 */
public class TokenNotValidException extends RuntimeException {

    public TokenNotValidException(String message) {
        super(message);
    }

    public TokenNotValidException(String message, Throwable e) {
        super(message, e);
    }
}
