package com.emdata.ivvs.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import cn.hutool.core.date.DatePattern;

/**
 * 日期工具类 getMonthSpace
 */
public class DateUtils {

    public static String getCurrentDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }


    public static String getCurrentDateWfsj(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }

    /**
     * 将日期字符串转换成指定格式的date
     *
     * 
     */
    public static Date formatStr(String str, String formatStr) {
        Date date = null;
        if (str != null) {
            DateFormat sdf = new SimpleDateFormat(formatStr);
            try {
                sdf.setLenient(false);
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 将日期转换成指定格式字符串
     *
     * @param date
     * @param str
     * @return
     */
    public static String formatDate(Date date, String str) {

        SimpleDateFormat sdf = new SimpleDateFormat(str);
        return sdf.format(date);
    }

    public static String formatDateTo24(String date, String str) {

        SimpleDateFormat formatter = new SimpleDateFormat(str);
        formatter.setLenient(false);
        Date newDate = null;
        try {
            newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter.format(newDate);
    }

    /**
     * 得到下个月的第一天
     */
    public static String getNextMonthFirstDay() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        return formatDate(calendar.getTime(), DatePattern.NORM_DATE_PATTERN);
    }

    /**
     * 得到前一个月的第一天(23:59:59)
     * 
     * @param date
     * @return
     */
    public static String getAgoMonthLastDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        // 获取前一个月最后一天
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(calendar2.getTime());
    }

    /**
     * 得到前一个月的最后一天(23:59:59)
     * 
     * @param date
     * @return
     */
    public static String getAgoMonthFirstDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        // 获取前一个月第一天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar1.getTime());
    }

    public static final String parseToDateTimeStr(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            // smdate
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            // bdate
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            throw new RuntimeException("daysBetween error" + smdate + ";" + bdate, e);
        }
    }

    /**
     * 按照日期格式，将字符串解析为日期对象
     * 
     * @param aMask
     *            输入字符串的格式
     * @param strDate
     *            一个按aMask格式排列的日期的字符串描述
     * @return Date 对象
     * @see SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method generates a string representation of a date's date/time in the format you specify on input
     *
     * @param aMask
     *            the date pattern the string is in
     * @param aDate
     *            a date object
     * @return a formatted string representation of the date
     *
     * @see SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            return returnValue;
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 时间相加
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date addHour(Date date, int hour) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    /**
     * 
     * return yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        String sDate = f.format(date);
        return sDate;
    }

    public static String formatDate(String formatPattern, Date date) {
        SimpleDateFormat f = new SimpleDateFormat(formatPattern);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 获取当天的开始时间
     * 
     * @return
     */
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当天的结束时间
     * 
     * @return
     */
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取本周的开始时间
     * 
     * @return
     */
    public static Date getBeginDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    /**
     * 获取某个日期的开始时间
     * 
     * @param d
     * @return
     */
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 两个日期相减得到的天数
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDiffDays(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }
        long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
        return (int)diff;
    }

    /**
     * 两个日期相减得到的毫秒数
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }

    /**
     * 获取两个日期中的最大日期
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return beginDate;
        }
        return endDate;
    }

    /**
     * 获取两个日期中的最小日期
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }

    /**
     * 返回某月该季度的第一个月
     * 
     * @param date
     * @return
     */
    public static Date getFirstSeasonDate(Date date) {
        final int[] SEASON = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);
        return cal.getTime();
    }

    /**
     * 返回某个日期下几天的日期
     * 
     * @param date
     * @param i
     * @return
     */
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }

    /**
     * 返回某个日期前几天的日期
     * 
     * @param date
     * @param i
     * @return
     */
    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }

    /**
     * 获取某年某月到某年某月按天的切片日期集合（间隔天数的日期集合）
     * 
     * @param beginYear
     * @param beginMonth
     * @param endYear
     * @param endMonth
     * @param k
     * @return
     */
    public static List getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
        List<List<Date>> list = new ArrayList<>();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));

            }
        } else {
            for (int j = beginMonth; j < 12; j++) {
                list.add(getTimeList(beginYear, j, k));
            }

            for (int i = beginYear + 1; i < endYear; i++) {
                for (int j = 0; j < 12; j++) {
                    list.add(getTimeList(i, j, k));
                }
            }
            for (int j = 0; j <= endMonth; j++) {
                list.add(getTimeList(endYear, j, k));
            }
        }
        return list;
    }

    /**
     * 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     * 
     * @param beginYear
     * @param beginMonth
     * @param k
     * @return
     */
    public static List<Date> getTimeList(int beginYear, int beginMonth, int k) {
        List<Date> list = new ArrayList<>();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }

    /**
     * 获取当前时间指定时间天数差
     */
    public static Date getDaysCalendarDATE(Integer days) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Date endDate = null;
        try {
            Calendar date = Calendar.getInstance();
            date.setTime(beginDate);
            date.set(Calendar.DATE, date.get(Calendar.DATE) - days);
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException ePe) {
            endDate = new Date();
        }
        return endDate;
    }

    /**
     * 计算后的时间在重新累计天数增加
     * 
     * @param dDate
     * @param days
     * @return
     */
    public static Date getDaysCalendarForTimeFormat(Date dDate, Integer days) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        try {
            Calendar date = Calendar.getInstance();
            date.setTime(dDate);
            date.set(Calendar.DATE, date.get(Calendar.DATE) - days);
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException ePe) {
            endDate = new Date();
        }
        return endDate;
    }

}
