package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.factorymethod.immutability;

import com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.factorymethod.immutability.Person;
import com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.factorymethod.immutability.PersonValidation;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonValidationTest {

    private PersonValidation personValidation = new PersonValidation();

    @Test
    public void validate_birthDayNotNull_true() {
        Person person = Person
                .newPersonWithBirthDate(
                        LocalDate.of(1988, 5, 5));

        boolean valid = personValidation
                .validate(person);

        assertThat(valid).isTrue();
    }

}