package com.coderstower.blog.the_object_instantiation_nightmare_the_builder_pattern.builder.lombok;

import lombok.Builder;
import lombok.Singular;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Builder
class Person {
  private final String name;
  @Singular
  private final List<String> addresses;
  private final LocalDate birthDate;

  private Person(String name, List<String> addresses,
                 LocalDate birthDate) {
    this.name = name;
    this.addresses = Collections
            .unmodifiableList(addresses);
    this.birthDate = birthDate;
  }

  public Integer calculateAgeFrom(
          LocalDate currentDate) {
    return Period.between(birthDate, currentDate)
            .getYears();
  }

  public String getName() {
    return name;
  }

  public List<String> getAddresses() {
    return addresses;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) &&
            Objects.equals(addresses,
                    person.addresses) &&
            Objects
                    .equals(birthDate,
                            person.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, addresses, birthDate);
  }
}
