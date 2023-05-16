package com.github.vincemann.eventdemo.login.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoLoginEvent {
    private String username;
    private String password;
}