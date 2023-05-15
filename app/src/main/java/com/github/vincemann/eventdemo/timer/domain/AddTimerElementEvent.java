package com.github.vincemann.eventdemo.timer.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddTimerElementEvent {
    private TimerElement element;
}
