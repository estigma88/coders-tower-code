package com.coderstower.blog.unit_testing_and_dependency_injection.property.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class Service {
  @Autowired
  private RestTemplate restTemplate;
  @Value("${service.url}")
  private String url;


  public User save(User user){
    return restTemplate.postForObject(url, user, User.class);
  }
}
