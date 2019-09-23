package com.coderstower.blog.unit_testing_behavior_vs_state.step1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { LocalDateTime.class, UUID.class})
public class ServiceTest {
  @Mock
  private Repository repository;
  @InjectMocks
  private Service service;

  @Before
  public void before(){
    PowerMockito.mockStatic(LocalDateTime.class);
    PowerMockito.mockStatic(UUID.class);
  }

  @Test
  public void save(){
    User user = mock(User.class);

    User userSaved = service.save(user);

    verify(user).setId(anyString());
    verify(user).setCreatedAt(any(LocalDateTime.class));
    verify(repository).save(user);
  }

}