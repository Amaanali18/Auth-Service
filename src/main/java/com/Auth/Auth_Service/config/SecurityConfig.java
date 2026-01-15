package com.Auth.Auth_Service.config;

import com.Auth.Auth_Service.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder userBuilder = User.builder();
//        UserDetails user1 = userBuilder.username("admin").password("admin").build();
        UserDetails userME = userBuilder.username("amaanali").password("password").build();
        UserDetails userMng = userBuilder.username("manager").password("secure-password").build();
        UserDetails userAdm = userBuilder.username("administrator").password("hashed-secure-password").build();
        return  new InMemoryUserDetailsManager(userME,userMng,userAdm);
    }
}
