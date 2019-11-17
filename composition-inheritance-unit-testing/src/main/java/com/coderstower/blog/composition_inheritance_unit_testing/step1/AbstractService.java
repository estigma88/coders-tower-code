package com.coderstower.blog.composition_inheritance_unit_testing.step1;

import java.util.UUID;

abstract class AbstractService<T> implements
        Service<T> {
  @Override
  public String generateId() {
    return getUUID().toString();
  }

  UUID getUUID(){
    return UUID.randomUUID();
  }
}
