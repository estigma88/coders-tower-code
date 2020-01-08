package com.coderstower.blog.open_close_principle_templates.step1.abstraction;

import java.time.LocalDateTime;
import java.util.Map;

public class ResumeTemplateProcess {
  private final TemplateRender templateRender;

  public ResumeTemplateProcess(
          TemplateRender templateRender) {
    this.templateRender = templateRender;
  }

  public String processResumeTemplate(
          Map<String, Object> data) {

    if (!isValid(data)) {
      throw new IllegalArgumentException();
    }

    data.put("currentDate", LocalDateTime.now());

    return templateRender
            .render("resumeTemplate.template", data);
  }

  private boolean isValid(Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }
}
