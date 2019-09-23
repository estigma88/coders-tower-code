package com.coderstower.blog.unit_testing_behavior_vs_state.step1;

import java.time.LocalDateTime;
import java.util.UUID;

class Service {
  private final Repository repository;

  public Service(Repository repository) {
    this.repository = repository;
  }

  public User save(User user){
    user.setId(UUID.randomUUID().toString());
    user.setCreatedAt(LocalDateTime.now());

    return repository.save(user);
  }
}
