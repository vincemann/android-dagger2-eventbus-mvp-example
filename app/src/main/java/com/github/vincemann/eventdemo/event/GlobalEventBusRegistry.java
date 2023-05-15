package com.github.vincemann.eventdemo.event;

import android.content.Context;

import com.github.vincemann.eventdemo.common.domain.AbstractEventBusRegistry;
import com.github.vincemann.eventdemo.common.domain.EventBusSubscriber;
import com.github.vincemann.eventdemo.login.domain.DoLoginEventHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalEventBusRegistry extends AbstractEventBusRegistry<GlobalEventBus> {

    // todo move out to DI @Provides method in EventBusModule, that also calls createDefaultSubscribers(subscribers) and autowires subs in

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

    @Override
    protected List<EventBusSubscriber<GlobalEventBus>> createDefaultSubscribers() {
        List<EventBusSubscriber<GlobalEventBus>> subscribers = new ArrayList<>();
        subscribers.addAll(Arrays.asList(
                new DoLoginEventHandler()
        ));
        return subscribers;
    }
}
