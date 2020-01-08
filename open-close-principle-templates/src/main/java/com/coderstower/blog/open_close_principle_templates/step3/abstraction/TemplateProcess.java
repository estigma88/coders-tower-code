package com.coderstower.blog.open_close_principle_templates.step3.abstraction;

import java.time.LocalDateTime;
import java.util.Map;

public class TemplateProcess {
  private final TemplateRender templateRender;

  public TemplateProcess(
          TemplateRender templateRender) {
    this.templateRender = templateRender;
  }

  private boolean isValidResume(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName");
  }

  private boolean isValidResumeLong(
          Map<String, Object> data) {
    return data != null && !data.isEmpty() && data
            .containsKey("personName") && data
            .containsKey("description");
  }

  public String processTemplate(String templateName,
                                Map<String, Object> data) {
    if (templateName.equals("resumeLong")) {
      if (!isValidResumeLong(data)) {
        throw new IllegalArgumentException(
                "Not valid data for resume long");
      }
      data.put("currentDate",
              LocalDateTime.now().plusDays(7));
      return templateRender
              .render("resumeLongTemplate.template",
                      data);
    } else {
      if (templateName.equals("resume")) {
        if (!isValidResume(data)) {
          throw new IllegalArgumentException(
                  "Not valid data for resume");
        }
        data.put("currentDate", LocalDateTime.now());
        return templateRender
                .render("resumeTemplate.template",
                        data);
      }else{
        throw new IllegalArgumentException(
                "Template not supported: " + templateName);
      }
    }
  }
}
