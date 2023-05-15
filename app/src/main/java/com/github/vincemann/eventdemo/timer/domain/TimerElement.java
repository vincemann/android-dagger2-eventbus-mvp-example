package com.github.vincemann.eventdemo.timer.domain;

import java.util.Date;

public class TimerElement {
    private Date date;
    private int id;

    public TimerElement(int id) {
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
