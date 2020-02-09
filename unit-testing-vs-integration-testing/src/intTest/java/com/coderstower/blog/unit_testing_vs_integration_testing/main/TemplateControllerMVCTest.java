package com.coderstower.blog.unit_testing_vs_integration_testing.main;

import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.TemplateProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TemplateController.class)
public class TemplateControllerMVCTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private TemplateProcess templateProcess;

  @Test
  public void renderResume_userTemplateProcess_render()
          throws Exception {
    given(templateProcess.processTemplate("template1",
            Map
                    .of("ke1", "value2",
                            "key2", "value2")))
            .willReturn("rendered template");

    mvc.perform(MockMvcRequestBuilders
            .put("/templates/template1")
            .content(asJsonString(Map
                    .of("ke1", "value2",
                            "key2", "value2")))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content()
                    .string("rendered template"));
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper()
              .writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}