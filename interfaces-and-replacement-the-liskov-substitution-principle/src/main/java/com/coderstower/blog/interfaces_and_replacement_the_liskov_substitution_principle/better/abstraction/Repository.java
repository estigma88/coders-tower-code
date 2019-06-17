package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction;

public interface Repository {
    User save(User user);

    User generateId(User user);
}
