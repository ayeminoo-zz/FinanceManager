package com.amo.finance.util;

import java.util.Calendar;

/**
 * Created by ayeminoosc on 8/15/15.
 */

public class CalendarUtil {

    public static Calendar getStartTimeOfDay(Calendar calendar){
        Calendar cal =  (Calendar) calendar.clone();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static Calendar getEndTimeOfDay(Calendar calendar){
        Calendar cal = (Calendar) calendar.clone();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal;
    }

    public static Calendar getStartTimeOfWeek(Calendar calendar){
        // "calculate" the start date of the week
        Calendar first = (Calendar) calendar.clone();
        first.add(Calendar.DAY_OF_WEEK,
                first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK));
        return getStartTimeOfDay(first);
    }

    public static Calendar getEndTimeOfWeek(Calendar calendar){
        Calendar last = (Calendar) calendar.clone();
        last.add(Calendar.DAY_OF_WEEK,
                last.getFirstDayOfWeek() - last.get(Calendar.DAY_OF_WEEK));
        last.add(Calendar.DAY_OF_YEAR, 6);

        return  getEndTimeOfDay(last);
    }

    public static Calendar getStartTimeOfMonth(Calendar calendar){
        Calendar cal = (Calendar) calendar.clone();
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getStartTimeOfDay(cal);
    }

    public static Calendar getEndTimeOfMonth(Calendar calendar){
        Calendar cal = (Calendar) calendar.clone();
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getEndTimeOfDay(cal);
    }

    public static Calendar getStartTimeOfYear(Calendar calendar){
        Calendar cal = (Calendar) calendar.clone();
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return getStartTimeOfDay(cal);
    }

    public static Calendar getEndTimeOfYear(Calendar calendar){
        Calendar cal = (Calendar) calendar.clone();
        cal.set(Calendar.MONTH, 11); // 11 = december
        cal.set(Calendar.DAY_OF_MONTH, 31); // new years eve
        return getEndTimeOfDay(cal);
    }


}
