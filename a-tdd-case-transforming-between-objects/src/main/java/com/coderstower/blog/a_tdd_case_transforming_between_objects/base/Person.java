package com.coderstower.blog.a_tdd_case_transforming_between_objects.base;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
  private String name;
  private String address;
  private LocalDate birthDate;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) &&
            Objects
                    .equals(address, person.address) &&
            Objects
                    .equals(birthDate,
                            person.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, birthDate);
  }
}
