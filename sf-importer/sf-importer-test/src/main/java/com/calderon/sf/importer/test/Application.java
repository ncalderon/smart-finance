package com.calderon.sf.importer.test;

/**
 * Created by nathaniel on 7/15/2017.
 */
import com.calderoncode.sf.importer.configuration.BeanConfigurator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.calderon.sf.data.repository")
//@SpringBootApplication(scanBasePackages = "com.calderon.sf.data")
@Configuration
@Import(BeanConfigurator.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.calderon.sf")
@EntityScan(basePackages = "com.calderon.sf.data.model")
@EnableJpaRepositories(basePackages = "com.calderon.sf")
public class Application implements ApplicationRunner{

    /*@Qualifier("dataSource")
    @Autowired
    DataSource dataSource;*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        /*Application app = new Application();*/
        System.out.println("Main!");

    }


    public void run(ApplicationArguments applicationArguments) throws Exception {
        /*System.out.println(service.findOneByAccNumAndAccName("1928","Gold RD"));*/
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