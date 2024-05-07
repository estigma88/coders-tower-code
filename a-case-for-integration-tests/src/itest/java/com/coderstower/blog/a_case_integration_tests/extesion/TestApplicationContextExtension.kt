package com.coderstower.blog.a_case_integration_tests.extesion

import com.coderstower.blog.a_case_integration_tests.extesion.CachedApplicationContextValidator
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class TestApplicationContextExtension : ParameterResolver {
    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean {
        return parameterContext.parameter.type == CachedApplicationContextValidator::class.java
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): CachedApplicationContextValidator {
        val store = extensionContext.root.getStore(ExtensionContext.Namespace.GLOBAL)

        return store.getOrComputeIfAbsent(
            CachedApplicationContextValidator::class,
            { CachedApplicationContextValidator() },
            CachedApplicationContextValidator::class.java
        )
    }
}
