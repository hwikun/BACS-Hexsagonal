package com.hwikun.bacs.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@ConfigurationPropertiesScan(basePackages = "com.hwikun.bacs")
@SpringBootApplication(scanBasePackages = "com.hwikun.bacs")
public class AuthenticationServer {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServer.class, args);
    }
}
