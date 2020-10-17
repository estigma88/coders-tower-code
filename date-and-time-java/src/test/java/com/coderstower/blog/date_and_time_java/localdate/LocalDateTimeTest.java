package com.coderstower.blog.date_and_time_java.localdate;

import com.coderstower.blog.date_and_time.localdatetime.LocalDateTimeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class LocalDateTimeTest {

  @Test
  public void testNow() {
    LocalDateTime now = LocalDateTime.now();

    System.out.println(now);

    assertNotNull(now);
  }

  @Test
  public void testRandomDate() {
    LocalDateTime now = LocalDateTime
            .of(2020, 3, 23,
                    8, 30, 10, 20);

    System.out.println(now);

    assertEquals(now.getYear(), 2020);
  }

  @Test
  public void testOperations() {
    LocalDateTime now = LocalDateTime
            .of(2020, 3, 23,
                    8, 30, 10, 20);

    LocalDateTime plus5Days = now.plusDays(5);

    LocalDateTime expected = LocalDateTime
            .of(2020, 3, 28,
                    8, 30, 10, 20);

    assertEquals(expected, plus5Days);
  }

  @Test
  public void testDateToString() {
    LocalDateTime now = LocalDateTime
            .of(2020, 3, 23, 8, 30, 10, 20);

    DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    String dateFormat = now.format(formatter);

    System.out.println(dateFormat);

    assertEquals("2020-03-23T08:30:10.000",
            dateFormat);
  }

  @Test
  public void testStringToDate() {
    DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern(
                    "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");

    LocalDateTime date = LocalDateTime
            .parse("2020-04-23T08:30:10.000000010",
                    formatter);

    System.out.println(date);

    assertEquals(LocalDateTime
            .of(2020, 4, 23, 8, 30, 10, 10), date);
  }

  @Test
  public void testTimeZone() {
    ZonedDateTime now = ZonedDateTime
            .of(2020, 3, 23, 8, 30, 10, 20,
                    ZoneId.of("UTC"));

    System.out.println(now);

    assertEquals(now.getZone(), ZoneId.of("UTC"));
  }

  @Test
  public void testTimeZone_moveToPST() {
    ZonedDateTime utc = ZonedDateTime
            .of(2020, 3, 23, 8, 30, 10, 20,
                    ZoneId.of("UTC"));

    ZonedDateTime pst = utc.withZoneSameInstant(
            ZoneId.of("US/Eastern"));

    System.out.println(pst);

    assertEquals(LocalDateTime
                    .of(2020, 3, 23, 4, 30, 10, 20),
            pst.toLocalDateTime());
  }

  @Test
  public void testMockDate() {
    Clock clock = Clock.fixed(ZonedDateTime
                    .of(2020, 3, 23, 8, 30, 10, 20,
                            ZoneId.of("UTC")).toInstant(),
            ZoneId.of("UTC"));

    LocalDateTimeUtils localDateTimeUtils = new LocalDateTimeUtils(
            clock);

    LocalDateTime now = localDateTimeUtils.getNow();

    System.out.println(now);

    assertEquals(LocalDateTime
            .of(2020, 3, 23, 8, 30, 10, 20), now);
  }

  @Test
  public void testLocalDateTimeToDate() {
    LocalDateTime now = LocalDateTime
            .of(2020, 3, 23,
                    8, 30, 10, 20);

    Date date = Date
            .from(now.atZone(ZoneId.systemDefault())
                    .toInstant());

    System.out.println(date);

    assertNotNull(date);
  }

  @Test
  public void testDateToLocalDateTime() {
    Date now = new Date();

    LocalDateTime date = now.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();

    System.out.println(date);

    assertNotNull(date);
  }
}
