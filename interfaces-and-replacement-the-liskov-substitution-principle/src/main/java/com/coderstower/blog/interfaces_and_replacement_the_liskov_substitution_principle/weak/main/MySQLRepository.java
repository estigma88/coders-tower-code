package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.weak.main;


import com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.weak.abstraction.Repository;
import com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.weak.abstraction.User;

public class MySQLRepository implements Repository {
    // Database access stuff
    //...

    @Override
    public User save(User user){
        //...
        // More database access stuff
        //...

        return new User(null, "anyname");
    }
}
