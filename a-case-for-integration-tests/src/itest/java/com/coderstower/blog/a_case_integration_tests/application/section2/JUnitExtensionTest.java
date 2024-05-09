package com.coderstower.blog.a_case_integration_tests.application.section2;

import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("itest")
@ExtendWith(ITestExtension.class)
public class JUnitExtensionTest {
    @Test
    public void contextUp(ITestHandler iTestHandler) {
        assertNotNull(iTestHandler);
    }
}
