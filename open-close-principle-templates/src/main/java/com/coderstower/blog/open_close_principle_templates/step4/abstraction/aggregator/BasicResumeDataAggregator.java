package com.coderstower.blog.open_close_principle_templates.step4.abstraction.aggregator;

import java.time.LocalDateTime;
import java.util.Map;

public class BasicResumeDataAggregator implements DataAggregator {
  @Override
  public Map<String, Object> aggregate(
          Map<String, Object> data) {
    if (!isValidBasicResume(data)) {
      throw new IllegalArgumentException(
              "Not valid data for basic resume");
    }

    data.put("validUntil", LocalDateTime.now());

    return data;
  }

  private boolean isValidBasicResume(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }
}