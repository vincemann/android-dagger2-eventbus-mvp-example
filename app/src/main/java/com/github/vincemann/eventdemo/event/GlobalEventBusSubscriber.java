package com.github.vincemann.eventdemo.event;

import com.github.vincemann.eventdemo.common.domain.EventBusSubscriber;
import com.github.vincemann.eventdemo.event.GlobalEventBus;

public interface GlobalEventBusSubscriber extends EventBusSubscriber<GlobalEventBus> {
}
