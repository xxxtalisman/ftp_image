package com.emdata.ivvs.entity;

/**
 * Created on 2019/7/5.
 */
public class FAllHoliday {

    String id;
    String title;
    String holiday_date;

    public FAllHoliday(String id,String title,String holiday_date)
    {
        this.id = id;
        this.title = title;
        this.holiday_date = holiday_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHoliday_date() {
        return holiday_date;
    }

    public void setHoliday_date(String holiday_date) {
        this.holiday_date = holiday_date;
    }
}
