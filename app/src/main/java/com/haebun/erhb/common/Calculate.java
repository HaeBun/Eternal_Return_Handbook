package com.haebun.erhb.common;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculate {

    public static String deadline(String endDay) {
        long time = System.currentTimeMillis();
        Date mDate = new Date(time);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date FirstDate = format.parse(format.format(mDate));
            Date SecondDate = format.parse(endDay);
            // "2021-10-28 11"
            Log.d("DATECAL", FirstDate.toString());
            Log.d("DATECAL", SecondDate.toString());

            long calDate = FirstDate.getTime() - SecondDate.getTime();
            long calDateDays = calDate / (60*60000);

            calDateDays = Math.abs(calDateDays);

            long day = calDateDays / 24;
            long hour = calDateDays % 24;

            return String.valueOf(day)+"일 "+String.valueOf(hour) +"시";

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "일 시";
    }
}
