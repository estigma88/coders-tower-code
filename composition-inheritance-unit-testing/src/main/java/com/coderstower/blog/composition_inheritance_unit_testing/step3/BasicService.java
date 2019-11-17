package com.coderstower.blog.composition_inheritance_unit_testing.step3;

class BasicService extends AbstractService<User> {
  private final UserRepository repository;

  public BasicService(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public String generateId() {
    return getId() + "+User";
  }

  String getId() {
    return super.generateId();
  }

  public User save(User user) {
    user.setId(generateId());

    return repository.save(user);
  }
}
