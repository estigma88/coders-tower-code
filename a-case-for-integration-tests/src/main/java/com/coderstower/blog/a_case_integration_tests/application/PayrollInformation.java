package com.coderstower.blog.a_case_integration_tests.application;

import java.time.LocalDateTime;

public record PayrollInformation(Integer id, LocalDateTime date, Double amount) {
}
