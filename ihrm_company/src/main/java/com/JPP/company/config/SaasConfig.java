package com.JPP.company.config;

import com.JPP.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaasConfig {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
