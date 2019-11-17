package com.coderstower.blog.composition_inheritance_unit_testing.step4;

class BasicService implements
        Service<User> {
  private final UserRepository repository;
  private final KeyGenerator keyGenerator;

  public BasicService(
          UserRepository repository,
          KeyGenerator keyGenerator) {
    this.repository = repository;
    this.keyGenerator = keyGenerator;
  }

  public User save(
          User user) {
    user.setId(keyGenerator.generateId());

    return repository.save(user);
  }
}
