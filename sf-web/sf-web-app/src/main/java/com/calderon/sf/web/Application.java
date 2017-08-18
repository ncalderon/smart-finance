package com.calderon.sf.web;
;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by nathaniel on 7/11/2017.
 */

@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages = "com.calderon.sf")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}