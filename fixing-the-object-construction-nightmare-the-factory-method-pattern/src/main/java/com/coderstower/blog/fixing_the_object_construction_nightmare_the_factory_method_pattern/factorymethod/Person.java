package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.factorymethod;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Person {
    private final String name;
    private final List<String> addresses;
    private final LocalDate birthDate;

    private Person(String name, List<String> addresses, LocalDate birthDate) {
        this.name = name;
        this.addresses = Collections.unmodifiableList(addresses);
        this.birthDate = birthDate;
    }

    public static Person newPersonWithName(String name) {
        return new Person(name, Collections.emptyList(), null);
    }

    public static Person newPersonWithNameAndAddresses(String name, List<String> addresses) {
        return new Person(name, addresses, null);
    }

    public static Person newFullPerson(String name, List<String> addresses, LocalDate birthDate) {
        return new Person(name, addresses, birthDate);
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
