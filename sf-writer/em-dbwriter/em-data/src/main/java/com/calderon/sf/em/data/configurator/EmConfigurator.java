package com.calderon.sf.em.data.configurator;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.calderon.sf.em.data", entityManagerFactoryRef = "emEntityManagerFactory", transactionManagerRef = "emTransactionManager")
public class EmConfigurator {
    /*@Primary()*/
    @Bean(name="emDataSourceProperties")
    @ConfigurationProperties("app.datasource.em")
    public DataSourceProperties emDataSourceProperties () {
        return new DataSourceProperties();
    }

    @Bean(name="emDataSource")
    @ConfigurationProperties("app.datasource.em")
    public HikariDataSource emDataSource() {
        return (HikariDataSource)emDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    /*@Bean(name= "emEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("emDataSource") DataSource emDataSource) {
        return builder
                .dataSource(emDataSource)
                .packages("com.calderon.sf.em.data")
                .persistenceUnit("em")
                .build();
    }*/

    @Bean(name= "emEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emEntityManagerFactory(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setDataSource(emDataSource());
        factoryBean.setPackagesToScan("com.calderon.sf.em.data");
        factoryBean.setJpaProperties(additionalProperties());
        return factoryBean;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "com.enigmabridge.hibernate.dialect.SQLiteDialect");
        return properties;
    }

    @Bean(name = "emTransactionManager")
    PlatformTransactionManager emTransactionManager(@Qualifier("emEntityManagerFactory") EntityManagerFactory emEntityManagerFactory) {
        return new JpaTransactionManager(emEntityManagerFactory);
    }
}
