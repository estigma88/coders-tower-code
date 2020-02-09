package com.coderstower.blog.unit_testing_vs_integration_testing;

import com.coderstower.blog.unit_testing_vs_integration_testing.main.TemplateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainTest {

  @Autowired
  private TemplateController controller;

  @Test
  public void startContext(){
    assertThat(controller).isNotNull();
  }
}