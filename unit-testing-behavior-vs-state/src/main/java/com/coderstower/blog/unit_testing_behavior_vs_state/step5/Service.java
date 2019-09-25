package com.coderstower.blog.unit_testing_behavior_vs_state.step5;

class Service {
  private final Repository repository;
  private final DateTimeHandler dateTimeHandler;

  public Service(
          Repository repository,
          DateTimeHandler dateTimeHandler) {
    this.repository = repository;
    this.dateTimeHandler = dateTimeHandler;
  }

  public User save(
          User user){
    user.setCreatedAt(dateTimeHandler.now());

    return repository.save(user);
  }
}
