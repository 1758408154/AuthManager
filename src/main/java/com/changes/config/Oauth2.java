package com.changes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiuJunJie
 * @since 2019/7/2 16:52
 */
@Configuration
public class Oauth2 {

    @Value("${security.scope}")
    private String scope;

    @Value("${security.clientId}")
    private String clientId;

    @Value("${security.secret}")
    private String secret;

    @Value("${security.url}")
    private String url;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
