package com.coderstower.blog.springobservability;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
  private final CustomerRepository customerRepository;

  public Controller(
          CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping("/ping")
  public String ping(){
    return "pong";
  }

  @GetMapping("/customers")
  public List<CustomerEntity> getCustomers(){
    return customerRepository.findAll();
  }

  @GetMapping("/customers/transform")
  public List<CustomerEntity> getCustomersTransform()
          throws InterruptedException {
    List<CustomerEntity> customers = customerRepository.findAll();

    Thread.sleep(5000); //slow operation

    return customers;
  }
}
