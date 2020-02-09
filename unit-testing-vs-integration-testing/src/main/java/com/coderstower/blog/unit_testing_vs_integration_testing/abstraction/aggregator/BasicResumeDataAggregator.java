package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BasicResumeDataAggregator implements
        DataAggregator {
  @Override
  public Map<String, Object> aggregate(
          Map<String, Object> data) {
    if (!isValidResume(data)) {
      throw new IllegalArgumentException(
              "Not valid data for basic resume");
    }

    Map<String, Object> newData = new HashMap<>(data);

    newData.put("validUntil", getNow());

    return newData;
  }

  LocalDateTime getNow() {
    return LocalDateTime.now();
  }

  private boolean isValidResume(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }
}