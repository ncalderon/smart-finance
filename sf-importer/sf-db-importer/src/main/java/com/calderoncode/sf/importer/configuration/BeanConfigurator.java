package com.calderoncode.sf.importer.configuration;

import com.calderoncode.sf.importer.DbImporter;
import com.calderoncode.sf.importer.Importer;
import com.calderoncode.sf.importer.service.AccountServiceData;
import com.calderoncode.sf.importer.service.BankServiceData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurator {
    @Bean
    public Importer importer(){
        return new DbImporter();
    }
    @Bean
    public AccountServiceData accountServiceData(){
        return new AccountServiceData();
    }
    @Bean
    public BankServiceData bankServiceData(){
        return new BankServiceData();
    }
}
