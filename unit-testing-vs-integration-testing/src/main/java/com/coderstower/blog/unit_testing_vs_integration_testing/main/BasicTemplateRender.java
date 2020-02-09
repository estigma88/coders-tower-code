package com.coderstower.blog.unit_testing_vs_integration_testing.main;

import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.TemplateRender;

import java.util.Map;

public class BasicTemplateRender implements
        TemplateRender {
  @Override
  public String render(String name,
                       Map<String, Object> data) {
    return "Template to be replaced: " + name + ", with data: " + data;
  }
}
