package com.changes.config;

import com.changes.exception.Auth2AccessDeniedHandler;
import com.changes.exception.Auth2ExceptionEntryPoint;
import com.changes.exception.MyOauth2WebResponseExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;


/**
 * @author LiuJunJie
 * @since 2019/7/1 9:35
 */
@Configuration
public class OAuth2ServerConfig {

    private static final String RESOURCE_ID = "tepia";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Autowired
        private Auth2ExceptionEntryPoint auth2ExceptionEntryPoint;

        @Autowired
        private Auth2AccessDeniedHandler auth2AccessDeniedHandler;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(auth2ExceptionEntryPoint)
                    .accessDeniedHandler(auth2AccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/oauth/**").permitAll();
            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    .anyRequest().authenticated();
        }
    }


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        RedisConnectionFactory redisConnectionFactory;

        @Resource
        UserDetailsService userDetailsService;

        @Autowired
        MyOauth2WebResponseExceptionTranslator myOauth2WebResponseExceptionTranslator;

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security
                    .allowFormAuthenticationForClients();

        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient(RESOURCE_ID)
                    .secret(passwordEncoder.encode(RESOURCE_ID))
                    .authorizedGrantTypes("authorization_code","client_credentials","refresh_token","password","implicit")
                    .scopes("all")
                    .resourceIds(RESOURCE_ID)
                    .accessTokenValiditySeconds(60*60*24*7)
                    .refreshTokenValiditySeconds(60*60*24*30);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userDetailsService)
                    .exceptionTranslator(myOauth2WebResponseExceptionTranslator);

            //封装返回结果

        }
    }

}
