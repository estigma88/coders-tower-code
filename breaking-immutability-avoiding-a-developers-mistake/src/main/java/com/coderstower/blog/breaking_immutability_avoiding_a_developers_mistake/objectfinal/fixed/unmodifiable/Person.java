package com.coderstower.blog.breaking_immutability_avoiding_a_developers_mistake.objectfinal.fixed.unmodifiable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Person {
    private final String name;
    private final List<String> addresses;
    private final LocalDate birthDate;

    public Person(String name, List<String> addresses, LocalDate birthDate){
        this.name = name;
        this.addresses = Collections.unmodifiableList(addresses);
        this.birthDate = birthDate;
    }

    public Person setName(String name){
        return new Person(name, this.addresses, this.birthDate);
    }

    public Person setAddress(List<String> addresses){
        return new Person(this.name, addresses, this.birthDate);
    }

    public Person setBirthDate(LocalDate birthDate){
        return new Person(this.name, this.addresses, birthDate);
    }

    public String getName(){
        return this.name;
    }

    public List<String> getAddresses(){
        return this.addresses;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }
}
