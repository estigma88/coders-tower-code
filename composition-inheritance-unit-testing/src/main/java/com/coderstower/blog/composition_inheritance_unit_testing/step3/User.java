package com.coderstower.blog.composition_inheritance_unit_testing.step3;

import java.util.Objects;
import java.util.StringJoiner;

class User {
  private String id;
  private String name;

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ",
            User.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .toString();
  }
}
