package com.coderstower.blog.fixing_the_object_construction_nightmare_the_factory_method_pattern.setters;

class PersonValidation {

  public boolean validate(Person person) {
    return person.getBirthDate() != null;
  }

}
