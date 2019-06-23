package com.coderstower.blog.breaking_immutability_avoiding_a_developers_mistake.objectfinal.wrong;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private final String name;
    private final List<String> addresses;
    private final LocalDate birthDate;

    public Person(String name, List<String> addresses, LocalDate birthDate) {
        this.name = name;
        this.addresses = addresses;
        this.birthDate = birthDate;
    }

    public Person setName(String name) {
        return new Person(name, this.addresses, this.birthDate);
    }

    public Person setAddress(List<String> addresses) {
        return new Person(this.name, addresses, this.birthDate);
    }

    public Person setBirthDate(LocalDate birthDate) {
        return new Person(this.name, this.addresses, birthDate);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getAddresses() {
        return this.addresses;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(addresses, person.addresses) &&
                Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, addresses, birthDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("addresses=" + addresses)
                .add("birthDate=" + birthDate)
                .toString();
    }
}
