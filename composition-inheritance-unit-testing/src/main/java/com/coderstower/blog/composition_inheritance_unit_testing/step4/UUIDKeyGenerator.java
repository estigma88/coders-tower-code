package com.coderstower.blog.composition_inheritance_unit_testing.step4;

import java.util.UUID;

class UUIDKeyGenerator implements
        KeyGenerator {
  @Override
  public String generateId() {
    return getUUID().toString();
  }

  UUID getUUID() {
    return UUID.randomUUID();
  }
}
