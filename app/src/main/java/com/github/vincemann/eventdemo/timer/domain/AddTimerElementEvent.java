package com.github.vincemann.eventdemo.timer.domain;

import java.util.Date;

/**
 * Created by gunhansancar on 06/04/16.
 */
public class AddTimerElementEvent {
    private Date date;
    private int id;

    public AddTimerElementEvent(int id) {
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
