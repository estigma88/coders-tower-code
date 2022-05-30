package com.coderstower.blog.springobservability;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class Controller {
  private final CustomerRepository customerRepository;
  private final Random random;

  public Controller(
          CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
    this.random = new Random();
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

    long sleep = (long) random.nextDouble(5000);
    System.out.println(sleep);
    Thread.sleep(sleep); //slow operation

    return customers;
  }
}
