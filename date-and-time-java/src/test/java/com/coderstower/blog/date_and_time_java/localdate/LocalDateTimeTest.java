package com.coderstower.blog.date_and_time_java.localdate;

import com.coderstower.blog.date_and_time.calendar.CalendarUtils;
import com.coderstower.blog.date_and_time.localdatetime.LocalDateTimeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalDateTimeTest {

    @Test
    public void testNow(){
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    public void testRandomDate(){
        LocalDateTime now = LocalDateTime.of(2020, 3, 23, 8, 30, 10, 20);

        System.out.println(now);

        assertEquals(now.getYear(), 2020);
    }

    @Test
    public void testDateToString(){
        LocalDateTime now = LocalDateTime.of(2020, 3, 23, 8, 30, 10, 20);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        String dateFormat = now.format(formatter);

        System.out.println(dateFormat);

        assertEquals("2020-03-23T08:30:10.000", dateFormat);
    }

    @Test
    public void testStringToDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");

        LocalDateTime date = LocalDateTime.parse("2020-04-23T08:30:10.000000010", formatter);

        System.out.println(date);

        assertEquals(LocalDateTime.of(2020, 4, 23, 8, 30, 10, 10), date);
    }

    @Test
    public void testTimeZone() {
        ZonedDateTime now = ZonedDateTime.of(2020, 3, 23, 8, 30, 10, 20, ZoneId.of("UTC"));

        System.out.println(now);

        assertEquals(now.getZone(), ZoneId.of("UTC"));
    }

    @Test
    public void testMockDate() {
        Clock clock = Clock.fixed(ZonedDateTime.of(2020, 3, 23, 8, 30, 10, 20, ZoneId.of("UTC")).toInstant(), ZoneId.of("UTC"));

        LocalDateTimeUtils localDateTimeUtils = new LocalDateTimeUtils(clock);

        LocalDateTime now = localDateTimeUtils.getNow();

        System.out.println(now);

        assertEquals(LocalDateTime.of(2020, 3, 23, 8, 30, 10, 20), now);
    }
}
