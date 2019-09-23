package com.coderstower.blog.unit_testing_behavior_vs_state.step4;

import java.time.LocalDateTime;

class Service {
  private final Repository repository;

  public Service(
          Repository repository) {
    this.repository = repository;
  }

  public User save(
          User user){
    user.setCreatedAt(getNow());

    return repository.save(user);
  }

  LocalDateTime getNow() {
    return LocalDateTime.now();
  }
}
