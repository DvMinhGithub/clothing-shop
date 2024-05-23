package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.core.SpringVersion;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TechStoreApplication {

    private static final Logger logger = LoggerFactory.getLogger(TechStoreApplication.class);

    public static void main(String[] args) {
        logger.info("Spring version: {}", SpringVersion.getVersion());
        SpringApplication.run(TechStoreApplication.class, args);
    }
}
