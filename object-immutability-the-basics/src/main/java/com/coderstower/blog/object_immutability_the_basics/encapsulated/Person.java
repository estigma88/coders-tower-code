package com.coderstower.blog.object_immutability_the_basics.encapsulated;

import java.time.LocalDate;

public class Person {
    private String name;
    private String address;
    private LocalDate birthDate;

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }
}
