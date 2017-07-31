package com.calderon.sf.web.data;

/**
 * Created by nathaniel on 7/15/2017.
 */
/*import com.calderon.sf.web.data.repository.AccountRepository;
import com.calderon.sf.web.data.repository.BankRepository;*/
import com.calderon.sf.data.repository.BankRepository;
import com.calderon.sf.data.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

//@EnableJpaRepositories(basePackages = "com.calderon.sf.data.repository")
//@SpringBootApplication(scanBasePackages = "com.calderon.sf.data")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.calderon.sf.data")
@EntityScan(basePackages = "com.calderon.sf.data.model")
@EnableJpaRepositories(basePackages = "com.calderon.sf.data.repository")
public class Application implements ApplicationRunner{

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /*@Qualifier("dataSource")
    @Autowired
    DataSource dataSource;*/
    @Autowired
    private AccountService service;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        /*Application app = new Application();*/
        System.out.println("Main!");

    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println(service.findOneByAccNumAndAccName("1928","Gold RD"));
    }

    /*@Bean
    public CommandLineRunner demo(AccountService repository) {
        System.out.println("DATASOURCE = " + dataSource);
        return (args)->{
            System.out.println(repository.findByAccName("Gold RD"));
            System.out.println(repository.findByAccName("Gold RD"));
            System.out.println(repository.findByAccName("Gold RD"));
        };
    }*/
    /*@Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }*/
}