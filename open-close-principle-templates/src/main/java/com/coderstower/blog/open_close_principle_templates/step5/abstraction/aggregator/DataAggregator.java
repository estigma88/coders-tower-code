package com.coderstower.blog.open_close_principle_templates.step5.abstraction.aggregator;

import java.util.Map;

public interface DataAggregator {
  Map<String, Object> aggregate(
          Map<String, Object> data);
}
