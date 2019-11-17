package com.coderstower.blog.composition_inheritance_unit_testing.step1;

class BasicService extends AbstractService<User> {
  private final UserRepository repository;

  public BasicService(UserRepository repository) {
    this.repository = repository;
  }

  public User save(User user) {
    user.setId(generateId());

    return repository.save(user);
  }
}
