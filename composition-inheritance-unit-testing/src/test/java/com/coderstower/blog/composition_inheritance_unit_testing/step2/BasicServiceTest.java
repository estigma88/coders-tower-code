package com.coderstower.blog.composition_inheritance_unit_testing.step2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicServiceTest {
  @Mock
  private UserRepository userRepository;
  @InjectMocks
  @Spy
  private BasicService basicService;

  @Test
  public void save_newId_saved(){
    User user = new User(null, "myName");
    User expectedUser = new User("newId", "myName");

    doReturn("newId").when(basicService).generateId();
    when(userRepository.save(expectedUser)).thenReturn(expectedUser);

    User newUser = basicService.save(user);

    assertThat(newUser).isEqualTo(expectedUser);
  }

}