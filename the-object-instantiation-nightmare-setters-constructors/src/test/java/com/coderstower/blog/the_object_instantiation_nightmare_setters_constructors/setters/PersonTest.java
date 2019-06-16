package com.coderstower.blog.the_object_instantiation_nightmare_setters_constructors.setters;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonTest {

    @Test
    public void calculateAgeFrom_from1988_ageIs31() {
        Person person = new Person();

        person.setBirthDate(
                LocalDate.of(1988, 5, 5));

        Integer age = person.calculateAgeFrom(
                LocalDate.of(2019, 5, 5));

        assertThat(age).isEqualTo(31);
    }

}