package com.example.demo4.config;

import com.example.demo4.datalayer.IStudentRepository;
import com.example.demo4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfigAdapter  {

    @Autowired
    StudentService service;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().authorizeHttpRequests()
                .antMatchers(HttpMethod.GET,"/v1/api/students/login/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/v1/api/students/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST).hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/v1/api/students/{id}").hasAuthority("ADMIN")
                .anyRequest().authenticated().and().httpBasic().and().csrf().disable();
           return   http.build();
    }
}
