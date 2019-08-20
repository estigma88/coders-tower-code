package com.coderstower.blog.a_tdd_case_transforming_between_objects.addfield.tdd.step4;

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
