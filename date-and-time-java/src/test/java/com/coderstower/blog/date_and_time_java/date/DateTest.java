package com.coderstower.blog.date_and_time_java.date;

import com.coderstower.blog.date_and_time.date.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DateTest {
    @Mock
    private DateUtils dateUtils;

    @Test
    public void testNow(){
        Date now = new Date();

        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    public void testRandomDate(){
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
    public void testStringToDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        Date date = simpleDateFormat.parse("2020-01-05T08:30:00.000-0500");

        System.out.println(date);

        assertNotNull(date);
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

    @Test
    public void testMockDate() {
        when(dateUtils.getNow()).thenReturn(new Date(2020, 0,5,8,30,0));

        Date now = dateUtils.getNow();

        System.out.println(now);

        assertEquals(now, new Date(2020, 0,5,8,30,0));
    }
}
