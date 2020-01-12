package com.coderstower.blog.open_close_principle_templates.step4.abstraction;

import java.util.Map;

public interface TemplateRender {
  String render(String name, Map<String, Object> data);
}
