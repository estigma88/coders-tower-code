package com.coderstower.blog.open_close_principle_templates.step2.abstraction;

import java.time.LocalDateTime;
import java.util.Map;

public class ResumeTemplateProcess {
  private final TemplateRender templateRender;

  public ResumeTemplateProcess(
          TemplateRender templateRender) {
    this.templateRender = templateRender;
  }

  public String processBasicResumeTemplate(
          Map<String, Object> data) {

    if (!isValidBasicResume(data)) {
      throw new IllegalArgumentException("Not valid data for basic resume");
    }

    data.put("validUntil", LocalDateTime.now());

    return templateRender
            .render("basicResumeTemplate.template", data);
  }

  private boolean isValidBasicResume(Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }

  public String processLongResumeTemplate(
          Map<String, Object> data) {
    if (!isValidLongResume(data)) {
      throw new IllegalArgumentException("Not valid data for long resume");
    }

    data.put("validUntil", LocalDateTime.now().plusDays(7));

    return templateRender
            .render("longResumeTemplate.template", data);
  }

  private boolean isValidLongResume(Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName") && data
            .containsKey("description");
  }
}
