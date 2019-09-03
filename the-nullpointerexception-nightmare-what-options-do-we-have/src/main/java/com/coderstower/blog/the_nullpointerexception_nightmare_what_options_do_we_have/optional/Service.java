package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.optional;

import java.util.List;
import java.util.Optional;

class Service {
  private final Repository repository;

  public Service(Repository repository) {
    this.repository = repository;
  }

  public Optional<User> getByName(String name) {
    List<String> users = this.repository.findAllIds();

    for (String id : users) {
      Optional<User> userComplete = this.repository
              .findById(id)
              .filter(u -> u.getName().equals(name));

      if (userComplete.isPresent()) {
        return userComplete;
      }
    }

    return Optional.empty();
  }
}
