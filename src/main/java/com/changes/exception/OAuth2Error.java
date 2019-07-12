package com.changes.exception;

/**
 * @author LiuJunJie
 * @since 2019/7/1 17:14
 */
public enum OAuth2Error {

    UserNameOrPassWord_Error(400,"用户名或密码错误"),
    AccessToken_Over_Error(400,"accessToken过期"),
    RefreshToken_Over_Error(400,"refreshToken过期");


    private int code;
    private String message;

    OAuth2Error(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
