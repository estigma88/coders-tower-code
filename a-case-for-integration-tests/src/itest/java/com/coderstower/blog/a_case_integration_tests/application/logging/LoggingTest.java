package com.coderstower.blog.a_case_integration_tests.application.logging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
public class LoggingTest {
    @Test
    public void checkLog(CapturedOutput capturedOutput) {
        System.out.println(
                "This is a log to the console"
        );

        String all = capturedOutput.getAll();

        Assertions.assertTrue(
                all.contains("This is a log to the console")
        );
    }
}
