package com.coderstower.blog.open_close_principle_templates.step4.abstraction.aggregator;

import java.time.LocalDateTime;
import java.util.Map;

public class ResumeDataAggregator implements DataAggregator {
  @Override
  public Map<String, Object> aggregate(
          Map<String, Object> data) {
    if (!isValidResume(data)) {
      throw new IllegalArgumentException(
              "Not valid data for resume");
    }

    data.put("currentDate", LocalDateTime.now());

    return data;
  }

  private boolean isValidResume(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }
}