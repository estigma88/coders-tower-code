package com.coderstower.blog.a_case_integration_tests.extesion

import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.system.CapturedOutput
import java.util.regex.Matcher
import java.util.regex.Pattern

class CachedApplicationContextValidator {

    fun assertCacheSizeIsLessThanOrEqualTo(output: CapturedOutput, maxCacheSize: Int) {
        val text = output.all
        val regex = "Spring test ApplicationContext cache statistics:.*?size\\s*=\\s*(\\d+)"
        val pattern = Pattern.compile(regex)
        val matcher: Matcher = pattern.matcher(text)

        assertThat(matcher.find())
            .withFailMessage(
                """
                Cannot extract the size from ApplicationContext cache statistics,
                Be sure you have the following config in your test profile:
                
                logging:
                  level:
                    org:
                      springframework:
                        test:
                          context:
                            cache: DEBUG
                """.trimIndent()
            )
            .isTrue()

        val sizeValue: String = matcher.group(1)

        assertThat(sizeValue.toInt())
            .withFailMessage(
                """
                Expected max allowed cache size $maxCacheSize, and actual was $sizeValue.
                
                If this assertion failed, it means new ITESTs were created and they are creating
                new ApplicationContext, which is not cached previously. This causes the ITESTs to be
                slow.
                
                As a suggestion, try to refactor your ITEST to reuse previous ApplicationContext configuration,
                so, no new ApplicationContext is created.
                
                If the refactor is not possible or the use case requires a new ApplicationContext configuration,
                update this tests to fit the new cache size.
                """.trimIndent()
            )
            .isLessThanOrEqualTo(maxCacheSize)
    }
}
