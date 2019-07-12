package com.changes.controller;

import com.changes.config.Oauth2;
import com.changes.exception.MyOauth2Exception;
import com.changes.service.UserService;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJunJie
 * @since 2019/7/1 16:34
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Oauth2 oauth2;

    @GetMapping("oauth/login")
    public Map<String, Object> loginOn(String username, String password) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = oauth2.getUrl();
        String grant_type = "password";
        String scope = oauth2.getScope();
        String client_id = oauth2.getClientId();
        String secret = oauth2.getSecret();
        String url = uri + "?" + "username=" + username
                + "&password=" + password
                + "&grant_type=" + grant_type
                + "&scope=" + scope
                + "&client_id=" + client_id
                + "&client_secret=" + secret;
        HttpPost httpPost = new HttpPost(url);

        HttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == 200) {

            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            // 解析token的json数据
            JSONObject jsonObject = JSONObject.fromObject(result);
            return new HashMap<String, Object>() {{
                put("code", 200);
                put("access_token", jsonObject.get("access_token"));
                put("refresh_token",jsonObject.get("refresh_token"));
            }};
        }else{
            throw new MyOauth2Exception("用户名或密码错误！");
        }
    }

    @GetMapping("oauth/refreshLogin")
    public Map<String,Object> refreshLogin(String refreshToken) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = oauth2.getUrl();
        String grant_type = "refresh_token";
        String client_id = oauth2.getClientId();
        String secret = oauth2.getSecret();
        String url = uri + "?"+"refresh_token="+refreshToken
                + "&grant_type=" + grant_type
                + "&client_id=" + client_id
                + "&client_secret=" + secret;
        HttpPost httpPost = new HttpPost(url);

        HttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == 200) {
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            // 解析token的json数据
            JSONObject jsonObject = JSONObject.fromObject(result);
            return new HashMap<String, Object>() {{
                put("code", 200);
                put("access_token", jsonObject.get("access_token"));
            }};
        }else{
            throw new MyOauth2Exception("refreshToken过期！");
        }
    }

}
