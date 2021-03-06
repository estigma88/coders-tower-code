package com.coderstower.blog.a_case_favor_tdd_transforming_entity_to_dto.addfield.tdd.step4;

class PersonTransformer {
  public PersonDTO transform(
          Person person){
    PersonDTO personDTO = new PersonDTO();
    personDTO.setAddress(person.getAddress());
    personDTO.setBirthDate(person.getBirthDate());
    personDTO.setName(person.getName());
    personDTO.setPhone(person.getPhone());

    return personDTO;
  }
}
