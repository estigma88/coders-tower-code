package com.coderstower.blog.unit_testing_and_dependency_injection.setters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Client {
  private Service service;

  public void anotherBusinessLogic(){
    this.service.setUrl("http://myotherurl");

    //TODO more logic
  }

  @Autowired
  public void setService(
          Service service) {
    this.service = service;
  }
}
