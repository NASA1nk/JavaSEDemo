package com.ink.Date;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
        Date date = new Date();
        instance.setTime(date);
        int days = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

    }
}
