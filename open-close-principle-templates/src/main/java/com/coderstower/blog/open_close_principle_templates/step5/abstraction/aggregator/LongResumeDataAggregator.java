package com.coderstower.blog.open_close_principle_templates.step5.abstraction.aggregator;

import java.time.LocalDateTime;
import java.util.Map;

public class LongResumeDataAggregator implements
        DataAggregator {
  @Override
  public Map<String, Object> aggregate(
          Map<String, Object> data) {
    if (!isValidResumeLong(data)) {
      throw new IllegalArgumentException(
              "Not valid data for resume long");
    }

    data.put("currentDate",
            LocalDateTime.now().plusDays(7));

    return data;
  }

  private boolean isValidResumeLong(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName") && data
            .containsKey("description");
  }
}
