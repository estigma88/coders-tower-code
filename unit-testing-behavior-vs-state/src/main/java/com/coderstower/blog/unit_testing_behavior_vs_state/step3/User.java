package com.coderstower.blog.unit_testing_behavior_vs_state.step3;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

class User {
  private String id;
  private String name;
  private LocalDateTime createdAt;

  public User(String id, String name,
              LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(
          LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name) &&
            Objects
                    .equals(createdAt, user.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createdAt);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ",
            User.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .add("createdAt=" + createdAt)
            .toString();
  }
}
