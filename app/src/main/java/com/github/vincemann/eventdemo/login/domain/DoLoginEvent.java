package com.github.vincemann.eventdemo.login.domain;

import lombok.Data;

@Data
public class DoLoginEvent {
    private String username;
    private String password;

    public DoLoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
}