package com.coderstower.blog.unit_testing_behavior_vs_state.step2;

import java.time.LocalDateTime;

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
}
