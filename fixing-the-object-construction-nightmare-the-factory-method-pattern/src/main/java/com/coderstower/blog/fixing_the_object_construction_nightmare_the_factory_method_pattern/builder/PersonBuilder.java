package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.builder;

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
