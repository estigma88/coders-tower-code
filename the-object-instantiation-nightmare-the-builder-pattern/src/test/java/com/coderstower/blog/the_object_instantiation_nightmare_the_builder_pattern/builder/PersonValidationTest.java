package com.coderstower.blog.the_object_instantiation_nightmare_the_builder_pattern.builder;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonValidationTest {
  private PersonValidation personValidation = new PersonValidation();

  @Test
  public void validate_birthDayNotNull_true() {
    Person.PersonBuilder personBuilder = new Person.PersonBuilder(
            "name");

    Person person = personBuilder.birthDate(LocalDate
            .of(1988, 5, 5)).build();

    boolean valid = personValidation
            .validate(person);

    assertThat(valid).isTrue();
  }
}