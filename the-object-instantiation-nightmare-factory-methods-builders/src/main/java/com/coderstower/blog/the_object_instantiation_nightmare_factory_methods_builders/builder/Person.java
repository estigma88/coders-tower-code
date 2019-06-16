package com.coderstower.blog.the_object_instantiation_nightmare_factory_methods_builders.builder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

class Person {
    private final String name;
    private final List<String> addresses;
    private final LocalDate birthDate;

    Person(String name, List<String> addresses, LocalDate birthDate) {
        this.name = name;
        this.addresses = Collections.unmodifiableList(addresses);
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
