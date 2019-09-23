package com.coderstower.blog.unit_testing_behavior_vs_state.step2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
  @Mock
  private Repository repository;
  @InjectMocks
  private Service service;

  @Test
  public void save(){
    User user = new User(null, "Daniel", null);

    when(repository.save(user)).thenReturn(user);

    User userSaved = service.save(user);

    assertThat(userSaved.getCreatedAt()).isNotNull();
    //assertThat(userSaved.getCreatedAt()).isEqualTo(
    //        LocalDateTime.now());
    assertThat(userSaved.getCreatedAt().withNano(0))
            .isEqualTo(LocalDateTime.now().withNano(0));

    verify(repository).save(user);
  }

}