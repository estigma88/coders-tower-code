package com.coderstower.blog.date_and_time_java.calendar;

import com.coderstower.blog.date_and_time.calendar.CalendarUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalendarTest {
    @Mock
    private CalendarUtils calendarUtils;

    @Test
    public void testNow(){
        Calendar now = Calendar.getInstance();

        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    public void testRandomDate(){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.YEAR, 2020);
        now.set(Calendar.MONTH, 3);
        now.set(Calendar.DAY_OF_MONTH, 23);
        now.set(Calendar.HOUR, 8);
        now.set(Calendar.MINUTE, 30);
        now.set(Calendar.MILLISECOND, 10);

        System.out.println(now);

        assertEquals(now.get(Calendar.YEAR), 2020);
    }

    @Test
    public void testDateToString(){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.YEAR, 2020);
        now.set(Calendar.MONTH, 3);
        now.set(Calendar.DAY_OF_MONTH, 23);
        now.set(Calendar.HOUR, 8);
        now.set(Calendar.MINUTE, 30);
        now.set(Calendar.SECOND, 10);
        now.set(Calendar.MILLISECOND, 10);

        Date nowDate = now.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        String dateFormat = simpleDateFormat.format(nowDate);

        System.out.println(dateFormat);

        assertEquals("2020-04-23T20:30:10.010-0500", dateFormat);
    }

    @Test
    public void testStringToDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        Date date = simpleDateFormat.parse("2020-04-23T08:30:10.010-0500");

        Calendar now = Calendar.getInstance();
        now.setTime(date);

        System.out.println(date);

        assertNotNull(now);
    }

    @Test
    public void testTimeZone() {
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        now.set(Calendar.YEAR, 2020);
        now.set(Calendar.MONTH, 3);
        now.set(Calendar.DAY_OF_MONTH, 23);
        now.set(Calendar.HOUR, 8);
        now.set(Calendar.MINUTE, 30);
        now.set(Calendar.SECOND, 10);
        now.set(Calendar.MILLISECOND, 10);

        System.out.println(now);

        assertEquals(TimeZone.getTimeZone("UTC"), now.getTimeZone());
    }

    @Test
    public void testMockDate() {
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.YEAR, 2020);
        expected.set(Calendar.MONTH, 3);
        expected.set(Calendar.DAY_OF_MONTH, 23);
        expected.set(Calendar.HOUR, 8);
        expected.set(Calendar.MINUTE, 30);
        expected.set(Calendar.SECOND, 10);
        expected.set(Calendar.MILLISECOND, 10);

        when(calendarUtils.getNow()).thenReturn(expected);
        
        Calendar now = calendarUtils.getNow();

        System.out.println(now);

        assertEquals(expected, now);
    }
}
