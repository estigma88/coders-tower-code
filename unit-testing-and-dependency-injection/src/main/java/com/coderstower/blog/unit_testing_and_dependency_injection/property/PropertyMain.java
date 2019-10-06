package com.coderstower.blog.unit_testing_and_dependency_injection.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PropertyMain {

  public static void main(String[] args) {
    SpringApplication.run(PropertyMain.class, args);
  }

  @Bean
  public RestTemplate restTemplate(){
   return new RestTemplate();
  }

}
