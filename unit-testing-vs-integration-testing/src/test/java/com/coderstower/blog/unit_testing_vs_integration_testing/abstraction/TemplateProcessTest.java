package com.coderstower.blog.unit_testing_vs_integration_testing.abstraction;

import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator.DataAggregator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TemplateProcessTest {
  @Mock
  private TemplateRender templateRender;
  @Mock
  private DataAggregator dataAggregator1;
  @Mock
  private DataAggregator dataAggregator2;

  @Test
  public void processTemplate_templateNotFound_exception() {
    TemplateProcess templateProcess = new TemplateProcess(
            templateRender,
            Map.of("template0", dataAggregator1,
                    "template2", dataAggregator2));

    IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () ->
                    templateProcess
                            .processTemplate("template1", Map.of()));

    assertThat(thrown.getMessage()).isEqualTo(
            "Template not supported: template1");
  }

  @Test
  public void processTemplate_templateFound_render() {
    when(dataAggregator2
            .aggregate(Map.of("ke1", "value2",
                    "key2", "value2")))
            .thenReturn(Map.of("ke1", "value2",
                    "key2", "value2",
                    "keyAggregated", "value3"));
    when(templateRender.render("template2.template",
            Map.of("ke1", "value2",
                    "key2", "value2",
                    "keyAggregated", "value3"))).thenReturn("rendered");

    TemplateProcess templateProcess = new TemplateProcess(
            templateRender,
            Map.of("template0", dataAggregator1,
                    "template2", dataAggregator2));

    String result = templateProcess
            .processTemplate("template2", Map.of("ke1", "value2",
                    "key2", "value2"));

    assertThat(result).isEqualTo("rendered");
  }

}