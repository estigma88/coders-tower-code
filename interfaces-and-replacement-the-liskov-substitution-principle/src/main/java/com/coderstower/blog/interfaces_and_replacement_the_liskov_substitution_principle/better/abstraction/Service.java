package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public User save(User user){
        //...
        // Some business rules applied
        //...
        User userWithId = this.repository.generateId(user);

        User newUser = this.repository.save(userWithId);

        //Doing stuff with user.getId();

        return newUser;
    }
}
