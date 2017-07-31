package com.calderon.sf.web;

import com.calderon.sf.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by nathaniel on 7/11/2017.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.calderon.sf")
@EntityScan(basePackages = "com.calderon.sf.data.model")
@EnableJpaRepositories(basePackages = "com.calderon.sf.data.repository")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}