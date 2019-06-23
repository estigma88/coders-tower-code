package com.coderstower.blog.breaking_immutability_avoiding_a_developers_mistake.objectfinal.fixed.unmodifiable;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    @Test(expected = UnsupportedOperationException.class)
    public void addAddress_newOne_immutability() {
        //Creating a mutable list
        List<String> addressesDaniel = new ArrayList<>();
        addressesDaniel.add("My address 1");
        addressesDaniel.add("My address 2");
        Person daniel = new Person("Daniel", addressesDaniel, LocalDate.of(1988, 9, 8));

        List<String> addressesDanielCopy = new ArrayList<>();
        addressesDanielCopy.add("My address 1");
        addressesDanielCopy.add("My address 2");

        Person danielCopy = new Person("Daniel", addressesDanielCopy, LocalDate.of(1988, 9, 8));

        //Breaking immutability
        daniel.getAddresses().add("Breaking the immutability 3");
    }
}