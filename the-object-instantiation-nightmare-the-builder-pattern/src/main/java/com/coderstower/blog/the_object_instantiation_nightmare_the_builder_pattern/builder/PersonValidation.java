package com.coderstower.blog.the_object_instantiation_nightmare_the_builder_pattern.builder;

class PersonValidation {

  public boolean validate(Person person) {
    return person.getBirthDate() != null;
  }

}
