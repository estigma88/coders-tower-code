package com.coderstower.blog.unit_testing_vs_integration_testing.main;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTemplateRenderTest {

  @Test
  public void render_data_string() {
    BasicTemplateRender basicTemplateRender = new BasicTemplateRender();

    String render = basicTemplateRender
            .render("template1",
                    new HashMap<>(Map.of("ke1", "value2",
                            "key2", "value2")));

    assertThat(render).isEqualTo("Template to be replaced: template1, with data: {key2=value2, ke1=value2}");
  }
}