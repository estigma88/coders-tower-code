package com.coderstower.blog.date_and_time.localdatetime;

import java.time.Clock;
import java.time.LocalDateTime;

public class LocalDateTimeUtils {
    private final Clock clock;

    public LocalDateTimeUtils(Clock clock) {
        this.clock = clock;
    }

    public LocalDateTime getNow() {
        return LocalDateTime.now(clock);
    }
}
