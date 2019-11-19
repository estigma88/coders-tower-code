package com.coderstower.blog.composition_inheritance_unit_testing.step2;

class UserService extends AbstractService<User> {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User save(User user) {
    user.setId(generateId());

    return repository.save(user);
  }
}
