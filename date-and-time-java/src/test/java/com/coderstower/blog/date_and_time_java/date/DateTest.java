package com.coderstower.blog.date_and_time_java.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DateTest {
    @Test
    public void testNow(){
        Date now = new Date();

        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    public void testRamdonDater(){
        Date now = new Date(2020, 0,5,8,30,0);

        System.out.println(now);

        assertEquals(now.getYear(), 2020);
    }

    @Test
    public void testDateToString_rightFormat(){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        String dateFormat = simpleDateFormat.format(now);

        System.out.println(dateFormat);

        assertNotNull(dateFormat);
    }

    @Test
    public void testDateToString_wrongFormat(){
        Date now = new Date(2020, 0,5,8,30,0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        String dateFormat = simpleDateFormat.format(now);

        System.out.println(dateFormat);

        assertEquals(dateFormat, "3920-01-05T08:30:00.000-0500");
    }

    @Test
    public void testTimeZone() {
        Date now = new Date();

        System.out.println(now.getTimezoneOffset());

        assertEquals(300, now.getTimezoneOffset());
    }

    @Test
    public void testTimeZone_changeSystemTimeZone() {
        System.setProperty("user.timezone", "UTC");

        Date now = new Date();

        System.out.println(now);

        assertNotNull(now);
    }
}
