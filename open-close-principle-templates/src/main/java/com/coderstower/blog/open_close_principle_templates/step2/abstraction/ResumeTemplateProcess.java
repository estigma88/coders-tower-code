package com.coderstower.blog.open_close_principle_templates.step2.abstraction;

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

    if (!isValidResume(data)) {
      throw new IllegalArgumentException("Not valid data for resume");
    }

    data.put("currentDate", LocalDateTime.now());

    return templateRender
            .render("resumeTemplate.template", data);
  }

  private boolean isValidResume(Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }

  public String processResumeLongTemplate(
          Map<String, Object> data) {
    if (!isValidResume(data)) {
      throw new IllegalArgumentException("Not valid data for resume long");
    }

    data.put("currentDate", LocalDateTime.now().plusDays(7));

    return templateRender
            .render("resumeLongTemplate.template", data);
  }

  private boolean isValidResumeLong(Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName") && data
            .containsKey("description");
  }
}
