package com.github.vincemann.eventdemo.timer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddTimerItemEvent {
    private TimerItem item;
}
