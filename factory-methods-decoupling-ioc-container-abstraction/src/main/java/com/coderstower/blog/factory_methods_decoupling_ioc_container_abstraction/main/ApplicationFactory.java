package com.coderstower.blog.factory_methods_decoupling_ioc_container_abstraction.main;

import com.coderstower.blog.factory_methods_decoupling_ioc_container_abstraction.abstraction.Repository;
import com.coderstower.blog.factory_methods_decoupling_ioc_container_abstraction.abstraction.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationFactory{

    @Bean
    public Repository repository(){
        return new MySQLRepository();
    }

    @Bean
    public Service service(Repository repository){
        return new Service(repository);
    }
}
