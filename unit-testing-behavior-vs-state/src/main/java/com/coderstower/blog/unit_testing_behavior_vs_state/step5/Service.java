package com.coderstower.blog.unit_testing_behavior_vs_state.step5;

class Service {
  private final Repository repository;
  private final TimeHandler timeHandler;

  public Service(
          Repository repository,
          TimeHandler timeHandler) {
    this.repository = repository;
    this.timeHandler = timeHandler;
  }

  public User save(
          User user){
    user.setCreatedAt(timeHandler.now());

    return repository.save(user);
  }
}
