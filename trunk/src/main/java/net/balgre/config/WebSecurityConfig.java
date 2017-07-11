package net.balgre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // other security configuration missing

        http.portMapper()
                .http(Integer.parseInt(environment.getProperty("server.http.port"))) // http port defined in yml config file
                .mapsTo(Integer.parseInt(environment.getProperty("server.port"))); // https port defined in yml config file

        // we only need https on /auth
        http.requiresChannel()
                .antMatchers("/my/**", "/login*", "/payment/**", "/goFindPw",
                		"/goFindId", "/privacy/**", "/regist", "/form_auth", 
                		"phone_check_data", "phone_check_data2", "deprecation", 
                		"/naver/callback", "/naver/callback", "/kakao/login", 
                		"/kakao/auth", "/sns/login", "/goQn", "/input_form",
                		"/qna/delete", "/addressPop", "/member/**", "/mail/sender",
                		"/myReview").requiresSecure()
                .anyRequest().requiresInsecure();
    }
}