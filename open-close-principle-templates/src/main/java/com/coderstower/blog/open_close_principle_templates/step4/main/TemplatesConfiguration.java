package com.coderstower.blog.open_close_principle_templates.step4.main;

import com.coderstower.blog.open_close_principle_templates.step4.abstraction.TemplateProcess;
import com.coderstower.blog.open_close_principle_templates.step4.abstraction.TemplateRender;
import com.coderstower.blog.open_close_principle_templates.step4.abstraction.aggregator.DataAggregator;
import com.coderstower.blog.open_close_principle_templates.step4.abstraction.aggregator.LongResumeDataAggregator;
import com.coderstower.blog.open_close_principle_templates.step4.abstraction.aggregator.ResumeDataAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplatesConfiguration {
  @Bean
  public TemplateProcess resumeTemplateProcess(
          TemplateRender templateRender,
          DataAggregator longResumeDataAggregator,
          DataAggregator resumeDataAggregator) {
    return new TemplateProcess(templateRender,
            resumeDataAggregator,
            longResumeDataAggregator);
  }

  @Bean
  public DataAggregator resumeDataAggregator() {
    return new ResumeDataAggregator();
  }

  @Bean
  public DataAggregator longResumeDataAggregator() {
    return new LongResumeDataAggregator();
  }

  @Bean
  public TemplateRender templateRender() {
    return new BasicTemplateRender();
  }
}
