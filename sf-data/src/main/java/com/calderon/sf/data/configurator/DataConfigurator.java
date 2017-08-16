package com.calderon.sf.data.configurator;

import com.calderon.sf.data.model.BankEntity;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.calderon.sf.data", entityManagerFactoryRef = "sfEntityManagerFactory", transactionManagerRef = "sfTransactionManager")
public class DataConfigurator {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.sf")
    public DataSourceProperties sfDataSourceProperties () {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.sf")
    public HikariDataSource sfDataSource() {
        return (HikariDataSource)sfDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

/*
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;
*/

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean sfEntityManagerFactory(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setDataSource(sfDataSource());
        factoryBean.setPackagesToScan("com.calderon.sf.data");
        factoryBean.setJpaProperties(additionalProperties());
        return factoryBean;
    }

   /* @Primary
    @Bean(name= "sfEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sfEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Autowired DataSource sfDataSource) {
        return builder
                .dataSource(sfDataSource)
                .packages(BankEntity.class)
                .persistenceUnit("sf")
                .build();
    }
*/
    @Primary
    @Bean(name = "sfTransactionManager")
    PlatformTransactionManager sfTransactionManager(@Autowired EntityManagerFactory sfEntityManagerFactory) {
        return new JpaTransactionManager(sfEntityManagerFactory);
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        return properties;
    }
}
