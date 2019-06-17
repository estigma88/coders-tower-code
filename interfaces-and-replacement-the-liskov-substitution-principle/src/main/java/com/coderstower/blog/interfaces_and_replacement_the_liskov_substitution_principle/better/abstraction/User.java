package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction;

public class User{
    private final String id;
    private final String name;

    public User(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }
}
