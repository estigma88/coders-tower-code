package com.coderstower.blog.open_close_principle_templates.step4.abstraction;

import com.coderstower.blog.open_close_principle_templates.step4.abstraction.aggregator.DataAggregator;

import java.util.Map;

public class TemplateProcess {
  private final TemplateRender templateRender;
  private final DataAggregator resumeDataAggregator;
  private final DataAggregator longResumeDataAggregator;

  public TemplateProcess(
          TemplateRender templateRender,
          DataAggregator resumeDataAggregator,
          DataAggregator longResumeDataAggregator) {
    this.templateRender = templateRender;
    this.resumeDataAggregator = resumeDataAggregator;
    this.longResumeDataAggregator = longResumeDataAggregator;
  }

  public String processTemplate(String templateName,
                                Map<String, Object> data) {
    if (templateName.equals("longResume")) {
      data = longResumeDataAggregator.aggregate(data);

      return templateRender
              .render("resumeLongTemplate.template",
                      data);
    } else {
      if (templateName.equals("basicResume")) {
        data = resumeDataAggregator.aggregate(data);

        return templateRender
                .render("basicResumeTemplate.template",
                        data);
      }else{
        throw new IllegalArgumentException(
                "Template not supported: " + templateName);
      }
    }
  }
}
