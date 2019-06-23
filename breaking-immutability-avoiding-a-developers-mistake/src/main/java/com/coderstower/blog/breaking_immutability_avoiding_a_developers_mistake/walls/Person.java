package com.coderstower.blog.breaking_immutability_avoiding_a_developers_mistake.walls;

import java.time.LocalDate;

public class Person {
    private /*final*/ String name;
    private final String address;
    private final LocalDate birthDate;

    public Person(String name, String address, LocalDate birthDate) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    public void updateName(String name){
        this.name = name;
    }

    public Person setName(String name) {
        return new Person(name, this.address, this.birthDate);
    }

    public Person setAddress(String address) {
        return new Person(this.name, address, this.birthDate);
    }

    public Person setBirthDate(LocalDate birthDate) {
        return new Person(this.name, this.address, birthDate);
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }
}
