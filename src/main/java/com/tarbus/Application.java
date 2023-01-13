package com.tarbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.tarbus.infra.repositories.jpa")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
