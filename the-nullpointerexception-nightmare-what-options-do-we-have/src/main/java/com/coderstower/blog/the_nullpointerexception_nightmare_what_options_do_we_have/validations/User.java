package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.validations;

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
}
