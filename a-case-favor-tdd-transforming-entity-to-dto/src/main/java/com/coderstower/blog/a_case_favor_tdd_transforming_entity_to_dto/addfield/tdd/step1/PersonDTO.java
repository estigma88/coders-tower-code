package com.coderstower.blog.a_case_favor_tdd_transforming_entity_to_dto.addfield.tdd.step1;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

class PersonDTO {
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
    PersonDTO person = (PersonDTO) o;
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

  @Override
  public String toString() {
    return new StringJoiner(", ",
            PersonDTO.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("address='" + address + "'")
            .add("birthDate=" + birthDate)
            .toString();
  }
}