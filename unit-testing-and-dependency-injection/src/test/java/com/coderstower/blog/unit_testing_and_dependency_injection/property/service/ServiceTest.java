package com.coderstower.blog.unit_testing_and_dependency_injection.property.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
  @Mock
  private RestTemplate restTemplate;

  private String url = "http://test.url.com/";

  @InjectMocks
  private Service service;

  @Before
  public void before() {
    ReflectionTestUtils
            .setField(service, "restTemplate",
                    restTemplate);
    ReflectionTestUtils
            .setField(service, "url",
                    url);
  }

  @Test
  public void save() {
    User user = new User("id", "name");

    when(restTemplate
            .postForObject(url, user, User.class))
            .thenReturn(user);

    User result = service.save(user);

    assertThat(result).isEqualTo(user);
  }
}