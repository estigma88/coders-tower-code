package com.coderstower.blog.the_object_instantiation_nightmare_setters_constructors.constructor.immutability;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonValidationTest {

    private PersonValidation personValidation = new PersonValidation();

    @Test
    public void validate_birthDayNotNull_true() {
        Person person = new Person(
                LocalDate.of(1988, 5, 5));

        boolean valid = personValidation
                .validate(person);

        assertThat(valid).isTrue();
    }

}