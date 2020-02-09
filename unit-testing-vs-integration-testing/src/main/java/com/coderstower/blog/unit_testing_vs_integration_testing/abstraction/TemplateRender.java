package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction;

import java.util.Map;

public interface TemplateRender {
  String render(String name, Map<String, Object> data);
}
