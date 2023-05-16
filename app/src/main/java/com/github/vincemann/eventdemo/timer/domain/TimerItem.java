package com.github.vincemann.eventdemo.timer.domain;

import java.util.Date;

public class TimerItem {
    private Date date;
    private int id;

    public TimerItem(int id) {
        this.id = id;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

}
