package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.optional;


import java.util.List;
import java.util.Optional;

interface Repository {
  Optional<User> findById(String id);

  List<String> findAllIds();
}
