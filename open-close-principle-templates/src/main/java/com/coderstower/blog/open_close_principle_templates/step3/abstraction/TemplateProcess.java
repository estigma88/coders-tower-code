package com.coderstower.blog.open_close_principle_templates.step3.abstraction;

import java.time.LocalDateTime;
import java.util.Map;

public class TemplateProcess {
  private final TemplateRender templateRender;

  public TemplateProcess(
          TemplateRender templateRender) {
    this.templateRender = templateRender;
  }

  public String processTemplate(String templateName,
                                Map<String, Object> data) {
    if (templateName.equals("longResume")) {
      if (!isValidLongResume(data)) {
        throw new IllegalArgumentException(
                "Not valid data for long resume");
      }

      data.put("validUntil",
              LocalDateTime.now().plusDays(7));

      return templateRender
              .render("longResumeTemplate.template",
                      data);
    } else {
      if (templateName.equals("basicResume")) {
        if (!isValidBasicResume(data)) {
          throw new IllegalArgumentException(
                  "Not valid data for resume");
        }

        data.put("validUntil", LocalDateTime.now());

        return templateRender
                .render("basicResumeTemplate.template",
                        data);
      }else{
        throw new IllegalArgumentException(
                "Template not supported: " + templateName);
      }
    }
  }

  private boolean isValidBasicResume(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }

  private boolean isValidLongResume(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName") && data
            .containsKey("description");
  }
}
