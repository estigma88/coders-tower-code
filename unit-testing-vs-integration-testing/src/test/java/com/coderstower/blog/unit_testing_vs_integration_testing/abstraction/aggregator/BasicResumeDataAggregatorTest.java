package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class BasicResumeDataAggregatorTest {
  @Rule
  public ExpectedException thrown = ExpectedException
          .none();

  @InjectMocks
  @Spy
  private BasicResumeDataAggregator basicResumeDataAggregator;

  @Test
  public void aggregate_nullData_exception() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
            "Not valid data for basic resume");
    Map<String, Object> data = basicResumeDataAggregator
            .aggregate(null);
  }

  @Test
  public void aggregate_emptyData_exception() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
            "Not valid data for basic resume");
    Map<String, Object> data = basicResumeDataAggregator
            .aggregate(Map.of());
  }

  @Test
  public void aggregate_noPersonName_exception() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
            "Not valid data for basic resume");
    Map<String, Object> data = basicResumeDataAggregator
            .aggregate(Map
                    .of("ke1", "value2",
                            "key2", "value2"));
  }

  @Test
  public void aggregate_personName_newData() {
    doReturn(LocalDateTime.of(2020, 1, 1, 1, 1, 1))
            .when(basicResumeDataAggregator).getNow();

    Map<String, Object> data = basicResumeDataAggregator
            .aggregate(Map
                    .of("personName", "daniel",
                            "key2", "value2"));

    assertThat(data).isEqualTo(Map
            .of("personName", "daniel",
                    "key2", "value2",
                    "validUntil",
                    LocalDateTime.of(2020, 1, 1, 1, 1, 1)));
  }
}