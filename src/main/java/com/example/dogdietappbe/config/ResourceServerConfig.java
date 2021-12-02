package com.example.dogdietappbe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig
        extends ResourceServerConfigurerAdapter {
    /**
     * We can have multiple resource servers in place. This ties this resource server to this application
     */
        private static final String RESOURCE_ID = "resource_id";

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(RESOURCE_ID)
                    .stateless(false);
        }

        @Override
        public void configure(HttpSecurity http)
                throws
                Exception {
            http.authorizeRequests()
                    .antMatchers("/",
                            "/h2-console/**",
                            "/createnewuser",
                            "/login")
                    .permitAll()
                    .antMatchers("/users/**",
                            "/dogs/**",
                            "/oauth/revoke-token",
                            "/logout")
                    .authenticated()
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(new OAuth2AccessDeniedHandler());

//		http.requiresChannel().anyRequest().requiresSecure(); //required for https

            http.csrf()
                    .disable();

            http.headers()
                    .frameOptions()
                    .disable();

            http.logout()
                    .disable();
        }
    }
