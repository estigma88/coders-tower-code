package com.coderstower.blog.unit_testing_behavior_vs_state.step3;

import java.time.LocalDateTime;

class Service {
  private final Repository repository;

  public Service(
          Repository repository) {
    this.repository = repository;
  }

  public User save(
          User user){
    user.setCreatedAt(LocalDateTime.now());

    return repository.save(user);
  }
}
