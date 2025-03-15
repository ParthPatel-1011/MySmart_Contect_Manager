package com.scm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // user create and logine

//     @Bean
//     public UserDetailsService userDetailsService() {

//         UserDetails user1 = User
//                 .withDefaultPasswordEncoder()
//                 .username("admin123")
//                 .password("admin123")
//                 .roles("ADMIN","USER")
//                 .build();

//         UserDetails user2 = User
//                 .withUsername("user")
//                 .password("user")
//                 // .roles(null)
//                 .build();

//         var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//         return inMemoryUserDetailsManager;

// }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // user service ka object :
        daoAuthenticationProvider.setUserDetailsPasswordService(null);
        // paswword Encoder ka object :
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
