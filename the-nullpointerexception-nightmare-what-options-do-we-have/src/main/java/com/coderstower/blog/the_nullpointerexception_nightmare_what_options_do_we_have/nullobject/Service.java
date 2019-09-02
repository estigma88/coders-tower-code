package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.nullobject;

import java.util.List;

class Service {
  private final Repository repository;

  public Service(Repository repository) {
    this.repository = repository;
  }

  public User getByName(String name) {
    List<String> users = this.repository.findAllIds();

    for (String id : users) {
      User userComplete = this.repository.findById(id);

      if (userComplete.getName().equals(name)) {
        return userComplete;
      }
    }
    return NullUser.INSTANCE;
  }
}
