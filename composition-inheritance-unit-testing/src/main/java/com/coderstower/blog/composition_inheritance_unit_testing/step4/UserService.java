package com.coderstower.blog.composition_inheritance_unit_testing.step4;

class UserService implements
        Service<User> {
  private final UserRepository repository;
  private final KeyGenerator keyGenerator;

  public UserService(
          UserRepository repository,
          KeyGenerator keyGenerator) {
    this.repository = repository;
    this.keyGenerator = keyGenerator;
  }

  @Override
  public User save(
          User user) {
    user.setId(keyGenerator.generateId());

    return repository.save(user);
  }
}
