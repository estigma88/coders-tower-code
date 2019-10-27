package com.coderstower.blog.dont_let_the_unit_tests_coverage_cheat_you.step2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
  @Mock
  private Repository repository;
  @InjectMocks
  private Service service;

  @Test
  public void testSave(){
    User user = new User("id", "name");

    when(repository.save(user)).thenReturn(user);

    User userResult = service.save(user);

    assertThat(userResult).isEqualTo(user);
  }
}