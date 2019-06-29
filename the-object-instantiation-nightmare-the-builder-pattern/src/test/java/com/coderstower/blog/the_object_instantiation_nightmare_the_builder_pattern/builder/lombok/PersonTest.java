package com.coderstower.blog.the_object_instantiation_nightmare_the_builder_pattern.builder.lombok;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonTest {
  @Test
  public void calculateAgeFrom_from1988_ageIs31() {
    Person.PersonBuilder personBuilder = Person.builder();

    Person person = personBuilder
            .birthDate(
                    LocalDate
                            .of(1988, 5, 5)).build();
    Person personCopy = personBuilder
            .build();

    Integer age = person.calculateAgeFrom(
            LocalDate.of(2019, 5, 5));

    assertThat(age).isEqualTo(31);
    assertThat(person).isEqualTo(personCopy);
  }
}