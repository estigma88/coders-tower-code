package com.coderstower.blog.a_case_integration_tests.application.reuseconfig;

import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("itest")
@ExtendWith(ITestExtension.class)
@ExtendWith(OutputCaptureExtension.class)
public abstract class ITestConfiguration {

    @LocalServerPort
    protected Integer port;
}