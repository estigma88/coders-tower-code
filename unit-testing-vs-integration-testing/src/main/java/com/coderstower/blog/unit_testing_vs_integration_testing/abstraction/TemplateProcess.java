package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction;

import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator.DataAggregator;

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
