package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.weak.abstraction;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public User save(User user){
        //...
        // Some business rules applied
        //...

        User newUser = this.repository.save(user);

        //Doing stuff with user.getId();

        return newUser;
    }
}
