package io.github.sabilaed.vaadinoauth2.application.config;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    private static final String LOGIN_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login";
    private static final String LOGOUT_SUCCESS_URL = "/login";
    private static final String SUCCESS_URL = "/main";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.oauth2Login().loginPage(LOGIN_URL).permitAll()
                .defaultSuccessUrl(
                        SUCCESS_URL, true)
                .failureUrl(LOGIN_FAILURE_URL)
                // Configure logout
                .and()
                .logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
        ;
    }
}
