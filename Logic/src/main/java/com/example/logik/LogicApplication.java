package com.example.logik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LogicApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogicApplication.class, args);
    }

}
