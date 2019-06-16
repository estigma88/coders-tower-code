package com.coderstower.blog.the_object_instantiation_nightmare_factory_methods_builders.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonBuilder {
    private String name;
    private List<String> addresses;
    private LocalDate birthDate;

    public PersonBuilder(String name) {
        this.name = name;
        this.addresses = new ArrayList<>();
    }

    public PersonBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;

        return this;
    }

    public PersonBuilder address(String address) {
        this.addresses.add(address);

        return this;
    }

    public PersonBuilder removeAddress(String address) {
        this.addresses.remove(address);

        return this;
    }

    public PersonBuilder clearAddress() {
        this.addresses.clear();

        return this;
    }

    public Person build() {
        return new Person(name, addresses, birthDate);
    }
}
