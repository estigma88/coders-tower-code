package com.coderstower.blog.composition_inheritance_unit_testing.step2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AbstractServiceTest {
  @InjectMocks
  @Spy
  private NullObjectAbstractService nullObjectAbstractService;

  @Test
  public void generateId_UUID_generated(){
    UUID uuid = UUID.randomUUID();

    doReturn(uuid).when(nullObjectAbstractService).getUUID();

    String id = nullObjectAbstractService.generateId();

    assertThat(id).isEqualTo(uuid.toString());
  }
}