package com.coderstower.blog.a_case_integration_tests.application.reuseconfig;

import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("itest")
@ExtendWith(ITestExtension.class)
@ExtendWith(OutputCaptureExtension.class)
public abstract class ITestConfiguration {

    @Autowired
    protected MockMvc mockMvc;
}