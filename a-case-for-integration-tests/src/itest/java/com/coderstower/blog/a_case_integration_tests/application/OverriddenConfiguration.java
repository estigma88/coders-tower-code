package com.coderstower.blog.a_case_integration_tests.application;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@TestConfiguration
public class OverriddenConfiguration {
    @Bean
    public Clock clock() {
        return Clock.fixed(ZonedDateTime.of(2020, 3, 3, 5, 6, 8, 1, ZoneId.of("UTC")).toInstant(), ZoneId.of("UTC"));
    }
}
