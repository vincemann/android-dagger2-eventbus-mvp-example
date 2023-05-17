package com.github.vincemann.eventdemo.event;

import android.content.Context;

import com.github.vincemann.eventdemo.common.event.AbstractEventBusRegistry;
import com.github.vincemann.eventdemo.common.event.EventBusSubscriber;

import java.util.ArrayList;
import java.util.List;

public class GlobalEventBusRegistry extends AbstractEventBusRegistry<GlobalEventBus> {

    protected static GlobalEventBusRegistry INSTANCE;

    public GlobalEventBusRegistry(Context applicationContext) {
        super(applicationContext);
        INSTANCE = this;
    }

    @Override
    protected GlobalEventBus createEventBus() {
        return GlobalEventBus.getInstance();
    }


    public static GlobalEventBusRegistry getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("No Instance of DefaultEventBusRegistry found. Create a new Instance through your subclass and set this INSTANCE");
        }
        return INSTANCE;
    }

//    @Override
//    protected List<EventBusSubscriber<GlobalEventBus>> createDefaultSubscribers() {
//        List<EventBusSubscriber<GlobalEventBus>> subscribers = new ArrayList<>();
//        subscribers.addAll(Arrays.asList(
//                new DoLoginEventHandler()
//        ));
//        return subscribers;
//    }


    @Override
    protected List<EventBusSubscriber<GlobalEventBus>> createDefaultSubscribers() {
        return new ArrayList<>();
    }
}
