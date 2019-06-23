package com.coderstower.blog.object_immutability_the_basics.state;

import org.junit.Test;

import java.time.LocalDate;

public class PersonTest {
    @Test
    public void create_directAccess_newPerson(){
        Person daniel = new Person();
        daniel.name = "Daniel";
        daniel.address = "Daniel's Address";
        daniel.birthDate = LocalDate.of(1988, 9, 8);

        Person rafael = new Person();
        rafael.name = "Rafael";
        rafael.address = "Rafael's Address";
        rafael.birthDate = LocalDate.of(1970, 9, 8);
    }

}