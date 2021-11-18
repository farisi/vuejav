package com.sf.bungker.app.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.sf.bungker.app.security.MyUserDetailsService;

import javax.sql.DataSource;

// @Configuration
// @EnableAuthorizationServer
// @Import(SecurityConfig.class)
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
    private final AuthenticationManager authenticationManager;

    @Qualifier("dataSource")
    private final DataSource dataSource;

    private final MyUserDetailsService myUserDetailsService;

    private final PasswordEncoder oauthClientPasswordEncoder;

    @Autowired
    public OAuth2AuthorizationServerConfig(AuthenticationManager authenticationManager, DataSource dataSource, MyUserDetailsService myUserDetailsService, @Qualifier("oauthClientPasswordEncoder") PasswordEncoder oauthClientPasswordEncoder)
    {
        this.authenticationManager = authenticationManager;
        this.dataSource = dataSource;
        this.myUserDetailsService = myUserDetailsService;
        this.oauthClientPasswordEncoder = oauthClientPasswordEncoder;
    }

    @Bean
    public OAuth2AccessDeniedHandler oauthAccessDeniedHandler()
    {
        return new OAuth2AccessDeniedHandler();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer)
    {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(oauthClientPasswordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
    {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(myUserDetailsService);
    }


    @Bean
    public TokenStore tokenStore()
    {
        return new JdbcTokenStore(dataSource);
    }

}