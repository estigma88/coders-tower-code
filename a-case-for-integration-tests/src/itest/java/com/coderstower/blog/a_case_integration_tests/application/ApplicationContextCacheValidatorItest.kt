package com.coderstower.blog.a_case_integration_tests.application

import com.coderstower.blog.a_case_integration_tests.extesion.CachedApplicationContextValidator
import com.coderstower.blog.a_case_integration_tests.extesion.TestApplicationContextExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension
import org.springframework.test.context.ActiveProfiles

// Test run last
@Order(Integer.MAX_VALUE)
@ExtendWith(TestApplicationContextExtension::class)
@ExtendWith(OutputCaptureExtension::class)
@ActiveProfiles(value = ["newProfile"])
class ApplicationContextCacheValidatorItest : MockedEdgesConfig() {

    @Test
    @DisplayName(
        """
            Validate the amount of cached application context doesn't increase
        """
    )
    fun validate(output: CapturedOutput, cachedApplicationContextValidator: CachedApplicationContextValidator) {
        cachedApplicationContextValidator.assertCacheSizeIsLessThanOrEqualTo(output, 9)
    }
}
