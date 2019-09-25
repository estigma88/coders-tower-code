package com.coderstower.blog.unit_testing_behavior_vs_state.step1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
  @Mock
  private Repository repository;
  @InjectMocks
  private Service service;

  @Test
  public void save(){
    //Given

    User user = mock(User.class);

    //When

    User userSaved = service.save(user);

    //Then

    verify(user).setCreatedAt(any(LocalDateTime.class));
    verify(repository).save(user);
  }

}