package com.coderstower.blog.the_object_instantiation_nightmare_setters_constructors.setters;

class PersonValidation {

  public boolean validate(Person person) {
    return person.getBirthDate() != null;
  }

}
