package com.coderstower.blog.testing_immutability_is_this_a_good_idea.good;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    private Person person;
    private Person personBefore;

    @Before
    public void before() {
        this.person = new Person("myname", Arrays.asList("address1", "address2"), LocalDate.of(1988, 5, 4));
        this.personBefore = new Person("myname", Arrays.asList("address1", "address2"), LocalDate.of(1988, 5, 4));
    }

    @Test
    public void setName_newPerson_changedName() {
        assertThat(this.person.setName("otherName")).isEqualTo(new Person("otherName", Arrays.asList("address1", "address2"), LocalDate.of(1988, 5, 4)));
        assertThat(this.person).isEqualTo(this.personBefore);
    }

    @Test
    public void setAddress_newPerson_changedAddress() {
        assertThat(this.person.setAddress(Arrays.asList("address5", "address2"))).isEqualTo(new Person("myname", Arrays.asList("address5", "address2"), LocalDate.of(1988, 5, 4)));
        assertThat(this.person).isEqualTo(this.personBefore);
    }

    @Test
    public void setBirthDate_newPerson_changedAddress() {
        assertThat(this.person.setBirthDate(LocalDate.of(1919, 5, 4))).isEqualTo(new Person("myname", Arrays.asList("address1", "address2"), LocalDate.of(1919, 5, 4)));
        assertThat(this.person).isEqualTo(this.personBefore);
    }

    @Test
    public void getName_ok() {
        assertThat(this.person.getName()).isEqualTo("myname");
        assertThat(this.person).isEqualTo(this.personBefore);
    }

    @Test
    public void getAddresses_ok() {
        assertThat(this.person.getAddresses()).isEqualTo(Arrays.asList("address1", "address2"));
        assertThat(this.person).isEqualTo(this.personBefore);
    }

    @Test
    public void getBirthDate_immutability_ok() {
        assertThat(this.person.getBirthDate()).isEqualTo(LocalDate.of(1988, 5, 4));
        assertThat(this.person).isEqualTo(this.personBefore);
    }
}