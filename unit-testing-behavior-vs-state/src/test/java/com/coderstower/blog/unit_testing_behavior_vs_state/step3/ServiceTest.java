package com.coderstower.blog.unit_testing_behavior_vs_state.step3;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { Service.class, LocalDateTime.class})
public class ServiceTest {
  @Mock
  private Repository repository;
  @InjectMocks
  private Service service;

  @Test
  public void save() throws Exception {
    User user = new User(null, "Daniel", null);

    LocalDateTime createdAtExpected = LocalDateTime
            .of(2019, 2, 3, 4, 5, 8, 123);
    User userExpected = new User(null, "Daniel",
            createdAtExpected);

    PowerMockito.mockStatic(LocalDateTime.class);
    when(LocalDateTime.now()).thenReturn(createdAtExpected);

    when(repository.save(user)).thenReturn(user);

    User userSaved = service.save(user);

    assertThat(userSaved).isEqualTo(
            userExpected);

    verify(repository).save(user);
  }

}