package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator;

import java.util.Map;

public interface DataAggregator {
  Map<String, Object> aggregate(
          Map<String, Object> data);
}
