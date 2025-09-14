package com.example.hrfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // For Railway dynamic PORT
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer(
            @Value("${PORT:8080}") int port) {
        return factory -> factory.setPort(port);
    }
}
