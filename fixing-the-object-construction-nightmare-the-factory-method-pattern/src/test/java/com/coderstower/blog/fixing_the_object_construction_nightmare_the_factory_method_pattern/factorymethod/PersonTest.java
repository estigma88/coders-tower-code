package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.factorymethod;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonTest {

    @Test
    public void calculateAgeFrom_from1988_ageIs31() {
        Person person = Person.newPersonWithBirthDate(
                LocalDate.of(1988, 5, 5));

        Integer age = person.calculateAgeFrom(
                LocalDate.of(2019, 5, 5));

        assertThat(age).isEqualTo(31);
    }
}