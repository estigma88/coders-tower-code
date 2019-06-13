package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.constructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

class Person {
    private String name;
    private List<String> addresses;
    private LocalDate birthDate;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name,
                  List<String> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    public Person(String name,
                  List<String> addresses,
                  LocalDate birthDate) {
        this.name = name;
        this.addresses = addresses;
        this.birthDate = birthDate;
    }

    public Person(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer calculateAgeFrom(
            LocalDate currentDate) {
        return Period
                .between(birthDate, currentDate)
                .getYears();
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
