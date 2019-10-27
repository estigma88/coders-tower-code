package com.coderstower.blog.dont_let_the_unit_tests_coverage_cheat_you.step1;

import java.util.Objects;

class Service {
  private final Repository repository;

  public Service(Repository repository) {
    this.repository = repository;
  }

  public User save(User user){
    if(isValid(user)){
      return repository.save(user);
    }

    throw new IllegalArgumentException("User is not valid");
  }

  private boolean isValid(User user) {
    return Objects.nonNull(user);
  }
}
