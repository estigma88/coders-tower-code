package com.coderstower.blog.open_close_principle_templates.step3.main;

import com.coderstower.blog.open_close_principle_templates.step3.abstraction.TemplateProcess;
import com.coderstower.blog.open_close_principle_templates.step3.abstraction.TemplateRender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplatesFactory {
  @Bean
  public TemplateProcess resumeTemplateProcess(
          TemplateRender templateRender){
    return new TemplateProcess(templateRender);
  }

  @Bean
  public TemplateRender templateRender(){
    return new BasicTemplateRender();
  }
}
