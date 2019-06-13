package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.constructor.immutability;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonValidationTest {

    private PersonValidation personValidation = new PersonValidation();

    @Test
    public void validate_birthDayNotNull_true() {
        Person person = new Person(null,
                Collections
                        .emptyList(),
                LocalDate.of(1988, 5, 5));

        boolean valid = personValidation
                .validate(person);

        assertThat(valid).isTrue();
    }

}