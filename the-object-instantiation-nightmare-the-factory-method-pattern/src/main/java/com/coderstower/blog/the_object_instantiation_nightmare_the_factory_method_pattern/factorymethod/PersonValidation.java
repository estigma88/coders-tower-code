package com.coderstower.blog.the_object_instantiation_nightmare_the_factory_method_pattern.factorymethod;

class PersonValidation {

  public boolean validate(Person person) {
    return person.getBirthDate() != null;
  }

}
