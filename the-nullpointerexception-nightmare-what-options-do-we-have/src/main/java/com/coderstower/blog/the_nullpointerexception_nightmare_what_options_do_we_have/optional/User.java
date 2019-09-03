package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.optional;

import java.util.Objects;

class User {
  private final String id;
  private final String name;

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name);
  }
}
