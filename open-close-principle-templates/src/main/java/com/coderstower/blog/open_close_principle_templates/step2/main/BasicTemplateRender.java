package com.coderstower.blog.open_close_principle_templates.step2.main;

import com.coderstower.blog.open_close_principle_templates.step2.abstraction.TemplateRender;

import java.util.Map;

public class BasicTemplateRender implements
        TemplateRender {
  @Override
  public String render(String name,
                       Map<String, Object> data) {
    return "Template to be replaced: " + name + ", with data: " + data;
  }
}
