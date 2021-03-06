package com.coderstower.blog.open_close_principle_templates.step4.main;

import com.coderstower.blog.open_close_principle_templates.step4.abstraction.TemplateProcess;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TemplateController {
  private final TemplateProcess templateProcess;

  public TemplateController(
          TemplateProcess templateProcess) {
    this.templateProcess = templateProcess;
  }

  @PutMapping("/templates/{templateName}")
  public String renderResume(
          @PathVariable String templateName,
          @RequestBody Map<String, Object> data) {
    return templateProcess
            .processTemplate(templateName, data);
  }
}
