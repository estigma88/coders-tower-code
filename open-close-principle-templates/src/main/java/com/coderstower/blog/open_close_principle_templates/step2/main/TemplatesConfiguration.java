package com.coderstower.blog.open_close_principle_templates.step2.main;

import com.coderstower.blog.open_close_principle_templates.step2.abstraction.ResumeTemplateProcess;
import com.coderstower.blog.open_close_principle_templates.step2.abstraction.TemplateRender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplatesConfiguration {
  @Bean
  public ResumeTemplateProcess resumeTemplateProcess(
          TemplateRender templateRender){
    return new ResumeTemplateProcess(templateRender);
  }

  @Bean
  public TemplateRender templateRender(){
    return new BasicTemplateRender();
  }
}
