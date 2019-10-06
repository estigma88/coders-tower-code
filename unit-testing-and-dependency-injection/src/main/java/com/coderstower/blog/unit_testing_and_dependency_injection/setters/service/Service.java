package com.coderstower.blog.unit_testing_and_dependency_injection.setters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class Service {
  private RestTemplate restTemplate;
  private String url;


  public User save(
          User user){
    return restTemplate.postForObject(url, user, User.class);
  }

  @Autowired
  public void setRestTemplate(
          RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Value("${service.url}")
  public void setUrl(String url) {
    this.url = url;
  }
}
