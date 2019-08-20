package com.coderstower.blog.a_case_favor_tdd_transforming_entity_to_dto.addfield.tdd.step1;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTransformerTest {
  private PersonTransformer personTransformer = new PersonTransformer();

  @Test
  public void transformFromPersonToPersonDTO() {
    Person person = new Person();
    person.setAddress("Street 1");
    person.setBirthDate(LocalDate.of(1980, 7, 4));
    person.setName("Daniel");
    //person.setPhone("111111");

    PersonDTO personDTOExpected = new PersonDTO();
    personDTOExpected.setAddress("Street 1");
    personDTOExpected
            .setBirthDate(LocalDate.of(1980, 7, 4));
    personDTOExpected.setName("Daniel");
    //personDTOExpected.setPhone("22222");

    PersonDTO personDTO = personTransformer
            .transform(person);

    assertThat(personDTO).isEqualTo(personDTOExpected);
  }
}