package com.coderstower.blog.unit_testing_vs_integration_testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WholeAppTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void renderResume_noTemplate_exception() {
    NestedServletException thrown = assertThrows(
            NestedServletException.class,
            () ->
                    mvc.perform(MockMvcRequestBuilders
                            .put("/templates/template1")
                            .content(asJsonString(Map
                                    .of("ke1",
                                            "value2",
                                            "key2",
                                            "value2")))
                            .contentType(
                                    MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk())
                            .andExpect(content()
                                    .string("rendered template")));
    assertThat(thrown.getCause()).isOfAnyClassIn(
            IllegalArgumentException.class);
    assertThat(thrown.getCause().getMessage())
            .isEqualTo(
                    "Template not supported: template1");
  }

  @Test
  public void renderResume_longResume_render()
          throws Exception {
    MvcResult result = mvc
            .perform(MockMvcRequestBuilders
                    .put("/templates/longResume")
                    .content(asJsonString(Map
                            .of("personName", "Daniel",
                                    "description",
                                    "My cv")))
                    .contentType(
                            MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
    assertThat(
            result.getResponse().getContentAsString())
            .contains(
                    "Template to be replaced: longResume.template, with data: {personName=Daniel, description=My cv, validUntil=");
  }

  @Test
  public void renderResume_basicResume_render()
          throws Exception {
    MvcResult result = mvc
            .perform(MockMvcRequestBuilders
                    .put("/templates/basicResume")
                    .content(asJsonString(Map
                            .of("personName",
                                    "Daniel")))
                    .contentType(
                            MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
    assertThat(
            result.getResponse().getContentAsString())
            .contains(
                    "Template to be replaced: basicResume.template, with data: {personName=Daniel, validUntil=");
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