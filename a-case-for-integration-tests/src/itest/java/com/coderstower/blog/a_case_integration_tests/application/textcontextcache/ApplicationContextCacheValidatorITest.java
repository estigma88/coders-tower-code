package com.coderstower.blog.a_case_integration_tests.application.textcontextcache;

import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.test.context.ActiveProfiles;

// Test run last
@Order(Integer.MAX_VALUE)
@ActiveProfiles({"newProfile", "itest"})
class ApplicationContextCacheValidatorITest extends com.coderstower.blog.a_case_integration_tests.application.reuseconfig.ITestConfiguration {

    @Test
    @DisplayName(
    """
        Validate the amount of cached application 
        context doesn't increase
    """
    )
    public void validate(CapturedOutput output,
                         ITestHandler iTestHandler) {
        iTestHandler.assertCacheSizeIsLessThanOrEqualTo(
                output, 1);
    }
}
