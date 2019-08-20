package com.coderstower.blog.a_tdd_case_transforming_between_objects.addfield.tdd.step2;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

class PersonDTO {
  private String name;
  private String address;
  private LocalDate birthDate;
  private String phone;

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

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PersonDTO personDTO = (PersonDTO) o;
    return Objects
            .equals(name, personDTO.name) &&
            Objects.equals(address,
                    personDTO.address) &&
            Objects.equals(birthDate,
                    personDTO.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects
            .hash(name, address, birthDate);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ",
            PersonDTO.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("address='" + address + "'")
            .add("birthDate=" + birthDate)
            .add("phone='" + phone + "'")
            .toString();
  }
}
