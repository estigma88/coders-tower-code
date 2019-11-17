package com.coderstower.blog.composition_inheritance_unit_testing.step4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class UUIDKeyGeneratorTest {
  @InjectMocks
  @Spy
  private UUIDKeyGenerator uuidKeyGenerator;

  @Test
  public void generateId_UUID_generated() {
    UUID uuid = UUID.randomUUID();

    doReturn(uuid).when(uuidKeyGenerator).getUUID();

    String id = uuidKeyGenerator.generateId();

    assertThat(id).isEqualTo(uuid.toString());
  }

}