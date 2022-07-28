package com.example.demo4.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ComponentConfig {
    @Bean
    public ModelMapper initModelMapper(){
        return new ModelMapper();
    }
}
