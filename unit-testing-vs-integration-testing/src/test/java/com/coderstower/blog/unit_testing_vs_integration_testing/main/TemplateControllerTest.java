package com.coderstower.blog.unit_testing_vs_integration_testing.main;

import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.TemplateProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TemplateControllerTest {
  @Mock
  private TemplateProcess templateProcess;
  @InjectMocks
  private TemplateController templateController;

  @Test
  public void renderResume_userTemplateProcess_render() {
    when(templateProcess.processTemplate("tempplate1",
            Map
                    .of("ke1", "value2",
                            "key2", "value2")))
            .thenReturn("rendered template");

    String render = templateController.renderResume("tempplate1",
            Map
                    .of("ke1", "value2",
                            "key2", "value2"));

    assertThat(render).isEqualTo("rendered template");
  }

}