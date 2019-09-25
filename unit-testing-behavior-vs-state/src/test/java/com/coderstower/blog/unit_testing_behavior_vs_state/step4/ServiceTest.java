package com.coderstower.blog.unit_testing_behavior_vs_state.step4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
  @Mock
  private Repository repository;
  @Spy
  @InjectMocks
  private Service service;

  @Test
  public void save() {
    //Given

    User user = new User(null, "Daniel", null);

    LocalDateTime createdAtExpected = LocalDateTime
            .of(2019, 2, 3, 4, 5, 8, 123);
    User userExpected = new User(null, "Daniel",
            createdAtExpected);

    doReturn(createdAtExpected).when(service).getNow();
    when(repository.save(user)).thenReturn(user);

    //When

    User userSaved = service.save(user);

    //Then

    assertThat(userSaved).isEqualTo(
            userExpected);
  }

}