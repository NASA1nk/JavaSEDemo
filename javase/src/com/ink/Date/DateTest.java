package com.ink.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(date1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date1);
        System.out.println(format);
        String str = "2021//14 晚上5:33";
        try {
            Date parse = simpleDateFormat.parse(str);
            System.out.println(parse);
        }catch (ParseException e){
            System.out.println("exception");
        }
    }
}
