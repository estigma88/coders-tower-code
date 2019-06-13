package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.constructor.immutability;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

public class Person {
    private final String name;
    private final List<String> addresses;
    private final LocalDate birthDate;

    public Person(String name, List<String> addresses, LocalDate birthDate) {
        this.name = name;
        this.addresses = Collections.unmodifiableList(addresses);
        this.birthDate = birthDate;
    }

    public Integer calculateAgeFrom(LocalDate currentDate){
        return Period
                .between(currentDate, birthDate).getDays();
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
