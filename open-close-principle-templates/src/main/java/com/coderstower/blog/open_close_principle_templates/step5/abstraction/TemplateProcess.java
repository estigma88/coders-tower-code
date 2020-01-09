package com.coderstower.blog.open_close_principle_templates.step5.abstraction;

import com.coderstower.blog.open_close_principle_templates.step5.abstraction.aggregator.DataAggregator;

import java.util.Map;

public class TemplateProcess {
  private final TemplateRender templateRender;
  private final Map<String, DataAggregator> dataAggregators;

  public TemplateProcess(
          TemplateRender templateRender,
          Map<String, DataAggregator> dataAggregators) {
    this.templateRender = templateRender;
    this.dataAggregators = dataAggregators;
  }


  public String processTemplate(String templateName,
                                Map<String, Object> data) {
    if (dataAggregators.containsKey(templateName)) {
      DataAggregator dataAggregator = dataAggregators
              .get(templateName);

      data = dataAggregator.aggregate(data);

      return templateRender
              .render(templateName + ".template",
                      data);
    } else {
      throw new IllegalArgumentException(
              "Template not supported: " + templateName);
    }
  }
}
