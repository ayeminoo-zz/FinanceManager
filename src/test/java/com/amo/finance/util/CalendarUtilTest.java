package com.amo.finance.util;

import com.amo.finance.FinanceManagerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by ayeminoosc on 8/15/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FinanceManagerApplication.class)
@WebAppConfiguration
public class CalendarUtilTest {
    private Calendar calendar;

    @Before
    public void setUp() {
        calendar = Calendar.getInstance();
    }

    @Test
    public void testGetStartTimeOfDay() throws Exception {
        Calendar cal = CalendarUtil.getStartTimeOfDay(calendar);
        assertStartTime(cal);
    }

    private void assertStartTime(Calendar calendar) {
        assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));
        assertEquals(0, calendar.get(Calendar.MILLISECOND));
    }

    private void assertEndTime(Calendar calendar) {
        assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(59, calendar.get(Calendar.MINUTE));
        assertEquals(59, calendar.get(Calendar.SECOND));
        assertEquals(999, calendar.get(Calendar.MILLISECOND));
    }

    @Test
    public void testGetEndTimeOfDay() throws Exception {
        Calendar cal = CalendarUtil.getEndTimeOfDay(calendar);
        assertEndTime(cal);
    }

    @Test
    public void testGetStartTimeOfWeek() throws Exception {
        Calendar cal = CalendarUtil.getStartTimeOfWeek(calendar);
        assertStartTime(cal);
        assertEquals(cal.getFirstDayOfWeek(), cal.get(Calendar.DAY_OF_WEEK));

    }

    @Test
    public void testGetLastTimeOfWeek() throws Exception {
        Calendar cal = CalendarUtil.getEndTimeOfWeek(calendar);
        assertEndTime(cal);
        assertEquals(7, cal.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void testGetStartTimeOfMonth() throws Exception {
        Calendar cal = CalendarUtil.getStartTimeOfMonth(calendar);
        assertStartTime(cal);
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testGetEndTimeOfMonth() throws Exception {
        Calendar cal = CalendarUtil.getEndTimeOfMonth(calendar);
        assertEndTime(cal);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testGetStartTimeOfYear() throws Exception {
        Calendar cal = CalendarUtil.getStartTimeOfYear(calendar);
        assertStartTime(cal);
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(1, cal.get(Calendar.DAY_OF_YEAR));
    }

    @Test
    public void testGetEndTimeOfYear() throws Exception {
        Calendar cal = CalendarUtil.getEndTimeOfYear(calendar);
        assertEndTime(cal);
        assertEquals(11, cal.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
}