package com.JPP.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com/JPP/domain/system")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
