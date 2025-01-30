package com.hhi.configuration;

import com.hhi.model.Account;
import com.hhi.model.Customer;
import com.hhi.model.Database;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hhi.*")
@EntityScan("com.hhi.model.*")
public class Config {

    private SessionFactory factory;

    @Bean
    public SessionFactory factory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        return new MetadataSources(registry)
                .addAnnotatedClasses(Customer.class, Account.class)
                .buildMetadata().buildSessionFactory();
    }


}
