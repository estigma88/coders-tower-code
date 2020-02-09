package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class LongResumeDataAggregatorTest {
  @InjectMocks
  @Spy
  private LongResumeDataAggregator longResumeDataAggregator;

  @Test
  public void aggregate_nullData_exception() {
    IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () ->
                    longResumeDataAggregator
                            .aggregate(null));
    assertThat(thrown.getMessage()).isEqualTo(
            "Not valid data for long resume");
  }

  @Test
  public void aggregate_emptyData_exception() {
    IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () ->
                    longResumeDataAggregator
                            .aggregate(Map.of()));
    assertThat(thrown.getMessage()).isEqualTo(
            "Not valid data for long resume");
  }

  @Test
  public void aggregate_noPersonName_exception() {
    IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () ->
                    longResumeDataAggregator
                            .aggregate(Map
                                    .of("ke1",
                                            "value2",
                                            "key2",
                                            "value2")));
    assertThat(thrown.getMessage()).isEqualTo(
            "Not valid data for long resume");
  }

  @Test
  public void aggregate_personNameNoDescription_exception() {
    IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () ->
                    longResumeDataAggregator
                            .aggregate(Map
                                    .of("personName",
                                            "daniel",
                                            "key2",
                                            "value2")));
    assertThat(thrown.getMessage()).isEqualTo(
            "Not valid data for long resume");
  }

  @Test
  public void aggregate_personNameDescription_newData() {
    doReturn(LocalDateTime.of(2020, 1, 1, 1, 1, 1))
            .when(longResumeDataAggregator).getNow();
    Map<String, Object> data = longResumeDataAggregator
            .aggregate(Map
                    .of("personName", "daniel",
                            "description",
                            "new resume"));
    assertThat(data).isEqualTo(Map
            .of("personName", "daniel",
                    "description", "new resume",
                    "validUntil",
                    LocalDateTime
                            .of(2020, 1, 8, 1, 1, 1)));
  }
}