package com.opglabel.springboot.lab03.authorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

// 授权服务器配置
@Configuration
@EnableAuthorizationServer
public class OAth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {


        clients.inMemory()
                // client 的用户名和密码
                .withClient("clientapp").secret("112233")
                .redirectUris("http://localhost:9001/callback")//配置回调地址
                .authorizedGrantTypes("authorization_code")//授权码模式
                .scopes("read_userinfo","read_contracts");//可授权的scope
//                .and().withClient(); 可以继续配置新的client
    }
}
