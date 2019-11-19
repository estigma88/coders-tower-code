package com.coderstower.blog.composition_inheritance_unit_testing.step3;

public class NullObjectAbstractService extends
        AbstractService<User> {
  @Override
  public User save(
          User user) {
    return null;
  }
}
