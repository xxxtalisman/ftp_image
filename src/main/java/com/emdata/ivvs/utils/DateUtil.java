package com.emdata.ivvs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanglingxin on 2019/12/25.
 */
public class DateUtil {

    public static String DEFAULT_FORMAT = "yyyy-MM-dd";

    public static String timePattern2 = "yyyyMMddHHmmss";

    public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";

    public static String dateTimePattern3 = "yyyyMMdd";

    public static Date parseStrToDate (String str) {
        try {
            return new SimpleDateFormat(DEFAULT_FORMAT).parse(str);
        }catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            return new SimpleDateFormat(timePattern2).parse(str);
        }catch (Exception e){
            //e.printStackTrace();
        }
        try {
            return new SimpleDateFormat(dateTimePattern).parse(str);
        }catch (Exception e){
            //e.printStackTrace();
        }
        try {
            return new SimpleDateFormat(dateTimePattern3).parse(str);
        }catch (Exception e){
            //e.printStackTrace();
        }
        return null;
    }


    public static String getNowSd(){
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimePattern3);
        return sdf.format(new Date());
    }


    /**
     * 时间相隔天数
     * @param minTime 最小的时间
     * @param maxTime 传递最大的时间
     * @return
     */
    public static long getDistanceTime(Date minTime, Date maxTime) {
        long days = 0;
        Date d1;
        try {
            d1 = maxTime;
            Date d2 = minTime;
            long diff = d1.getTime() - d2.getTime();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (Exception e) {}
        return days;
    }

}
