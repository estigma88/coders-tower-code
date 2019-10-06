package com.coderstower.blog.unit_testing_and_dependency_injection.constructor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class Service {
  private final RestTemplate restTemplate;
  private final String url;

  Service(RestTemplate restTemplate,
          @Value("${service.url}") String url) {
    this.restTemplate = restTemplate;
    this.url = url;
  }

  public User save(
          User user){
    return restTemplate.postForObject(url, user, User.class);
  }
}
