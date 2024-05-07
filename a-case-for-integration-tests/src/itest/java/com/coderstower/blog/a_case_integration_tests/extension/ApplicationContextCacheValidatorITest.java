package com.coderstower.blog.a_case_integration_tests.extension;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.test.context.ActiveProfiles;

// Test run last
@Order(Integer.MAX_VALUE)
@ActiveProfiles(value = "newProfile")
class ApplicationContextCacheValidatorITest extends MockedEdgesConfig {

    @Test
    @DisplayName(
            """
                        Validate the amount of cached application context doesn't increase
                    """
    )
    public void validate(CapturedOutput output, ITestHandler iTestHandler) {
        iTestHandler.assertCacheSizeIsLessThanOrEqualTo(output, 9);
    }
}
