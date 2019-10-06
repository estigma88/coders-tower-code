package com.coderstower.blog.unit_testing_and_dependency_injection.setters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SettersMain {

  public static void main(String[] args) {
    SpringApplication.run(
            SettersMain.class, args);
  }

  @Bean
  public RestTemplate restTemplate(){
   return new RestTemplate();
  }

}
