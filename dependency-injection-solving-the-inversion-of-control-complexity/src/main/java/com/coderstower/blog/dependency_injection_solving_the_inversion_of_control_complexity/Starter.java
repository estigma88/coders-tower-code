package com.coderstower.blog.dependency_injection_solving_the_inversion_of_control_complexity;

import com.coderstower.blog.dependency_injection_solving_the_inversion_of_control_complexity.abstraction.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Starter {
    public static void main(String[] args) {
        //Starting IoC container
        ApplicationContext iocContainer = SpringApplication.run(Starter.class, args);

        //Getting Service object from the IoC container
        Service service = iocContainer.getBean("service", Service.class);

        //TODO use service behavior
    }
}
