package com.changes.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author LiuJunJie
 * @since 2019/7/1 17:37
 */
@JsonSerialize(using = MyOauth2ExceptionJacksonSerializer.class)
public class MyOauth2Exception extends OAuth2Exception {
    public MyOauth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public MyOauth2Exception(String msg) {
        super(msg);
    }
}
