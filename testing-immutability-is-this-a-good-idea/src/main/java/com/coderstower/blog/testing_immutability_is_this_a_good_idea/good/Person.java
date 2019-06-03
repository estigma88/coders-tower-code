package com.coderstower.blog.testing_immutability_is_this_a_good_idea.good;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", addresses=").append(addresses);
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
