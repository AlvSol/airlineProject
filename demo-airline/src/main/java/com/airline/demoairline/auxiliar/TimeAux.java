package com.airline.demoairline.auxiliar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeAux {


    public long hourToSeconds(String time) {

        long seconds = 0;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            //TimeZone gmt = TimeZone.getTimeZone("GMT");
            //sdf.setTimeZone(gmt);
            Date date = sdf.parse(time);

            seconds = date.getTime() / 1000;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return seconds;
    }

    public String secondsToHour(long seconds) {
        Date dateObj = new Date(seconds * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateObj);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return "" + hour + ":" + minute;
    }
}
