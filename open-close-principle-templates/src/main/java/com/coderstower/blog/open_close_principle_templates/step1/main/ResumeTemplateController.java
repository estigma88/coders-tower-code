package com.coderstower.blog.open_close_principle_templates.step1.main;

import com.coderstower.blog.open_close_principle_templates.step1.abstraction.ResumeTemplateProcess;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ResumeTemplateController {
  private final ResumeTemplateProcess resumeTemplateProcess;

  public ResumeTemplateController(
          ResumeTemplateProcess resumeTemplateProcess) {
    this.resumeTemplateProcess = resumeTemplateProcess;
  }

  @PutMapping("/templates/resume")
  public String renderResume(@RequestBody
                                     Map<String, Object> data) {
    return resumeTemplateProcess
            .processResumeTemplate(data);
  }
}
