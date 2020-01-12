package com.coderstower.blog.open_close_principle_templates.step2.main;

import com.coderstower.blog.open_close_principle_templates.step2.abstraction.ResumeTemplateProcess;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TemplateController {
  private final ResumeTemplateProcess resumeTemplateProcess;

  public TemplateController(
          ResumeTemplateProcess resumeTemplateProcess) {
    this.resumeTemplateProcess = resumeTemplateProcess;
  }

  @PutMapping("/templates/resume")
  public String renderResume(@RequestBody
                                     Map<String, Object> data) {
    return resumeTemplateProcess
            .processResumeTemplate(data);
  }

  @PutMapping("/templates/resumelong")
  public String renderResumeLong(@RequestBody
                                     Map<String, Object> data) {
    return resumeTemplateProcess
            .processResumeLongTemplate(data);
  }
}
