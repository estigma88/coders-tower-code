package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.main;


import com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction.Repository;
import com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction.User;

import java.util.UUID;

public class MySQLRepository implements Repository {
    // Database access stuff
    //...

    @Override
    public User save(User user){
        //...
        // More database access stuff
        //...

        return user;
    }

    @Override
    public User generateId(User user) {
        //Generate an id, we garantee any user will have one from start
        //.....
        return new User(UUID.randomUUID().toString(), "anyname");
    }
}
