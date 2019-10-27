package com.coderstower.blog.dont_let_the_unit_tests_coverage_cheat_you.step3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private Repository repository;
  @InjectMocks
  private Service service;

  @Test
  public void save_userValid_saved(){
    User user = new User("id", "name");

    when(repository.save(user)).thenReturn(user);

    User userResult = service.save(user);

    assertThat(userResult).isEqualTo(user);
  }

  @Test
  public void save_userNotValid_throwException(){
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("User is not valid");

    service.save(null);
  }
}