package com.github.vincemann.eventdemo.event;

import com.github.vincemann.eventdemo.common.domain.AbstractEventBus;

public class GlobalEventBus extends AbstractEventBus {

    private static volatile GlobalEventBus defaultInstance;

    public static GlobalEventBus getInstance() {
        if (defaultInstance == null) {
            synchronized (GlobalEventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new GlobalEventBus();
                }
            }
        }
        return defaultInstance;
    }
}
