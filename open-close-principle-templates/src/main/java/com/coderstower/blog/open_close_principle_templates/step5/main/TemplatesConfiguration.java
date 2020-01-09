package com.coderstower.blog.open_close_principle_templates.step5.main;

import com.coderstower.blog.open_close_principle_templates.step5.abstraction.TemplateProcess;
import com.coderstower.blog.open_close_principle_templates.step5.abstraction.TemplateRender;
import com.coderstower.blog.open_close_principle_templates.step5.abstraction.aggregator.DataAggregator;
import com.coderstower.blog.open_close_principle_templates.step5.abstraction.aggregator.LongResumeDataAggregator;
import com.coderstower.blog.open_close_principle_templates.step5.abstraction.aggregator.ResumeDataAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TemplatesConfiguration {

  @Bean
  public TemplateProcess resumeTemplateProcess(
          TemplateRender templateRender,
          Map<String, DataAggregator> dataAggregators) {
    return new TemplateProcess(templateRender,
            dataAggregators);
  }

  @Bean
  public DataAggregator resume() {
    return new ResumeDataAggregator();
  }

  @Bean
  public DataAggregator longResume() {
    return new LongResumeDataAggregator();
  }

  @Bean
  public TemplateRender templateRender() {
    return new BasicTemplateRender();
  }
}
