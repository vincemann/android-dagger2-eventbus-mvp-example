package com.github.vincemann.eventdemo.common.event;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Registry/Container for one specific eventbus.
 * Registers default {@link EventBusSubscriber}s via {@link this#createDefaultSubscribers()}.
 * Implement Singleton Pattern in subclasses and provide static access.
 *
 * @param <T> SubType of EventBus
 */
public abstract class AbstractEventBusRegistry<T extends AbstractEventBus> {


    protected final T eventBus;
    protected final List<EventBusSubscriber<? super T>> defaultEventSubscribers = new ArrayList<>();
    protected final List<EventBusSubscriber<? super T>> eventSubscribers = new ArrayList<>();
    protected final Context applicationContext;

    /**
     * Create instance once in App or with DI as a singleton.
     */
    protected AbstractEventBusRegistry(Context applicationContext) {
        this.applicationContext = applicationContext;
        this.eventBus = createEventBus();
    }

    protected abstract T createEventBus();

    public void registerDefaultSubscribers() {
        onBeforeRegisterDefaultSubscribers();
        defaultEventSubscribers.clear();
        defaultEventSubscribers.addAll(createDefaultSubscribers());
        for (EventBusSubscriber subscriber : defaultEventSubscribers) {
            registerSubscriber(subscriber);
        }
    }

    public void unregisterAllSubscribers() {
        onBeforeUnregisterAllEventSubscribers();
        for (Object subscriber : eventSubscribers) {
            eventBus.unregister(subscriber);
        }
        eventSubscribers.clear();
    }

    /**
     * Always register and unregister via the EventbusRegistry of an Eventbus!
     */
    public void registerSubscriber(EventBusSubscriber<? super T> subscriber) {
        if (eventSubscribers.contains(subscriber)) {
            Log.d(this.getClass().getSimpleName()+ "-register", "registerSubscriber: EventBusSubscriber" + subscriber + " to register is already presenet in registry's subscriber list. Skipping.");
            return;
        }

        subscriber.register(eventBus);
        eventSubscribers.add(subscriber);
    }

    /**
     * Always register and unregister via the EventbusRegistry of an Eventbus!
     */
    public void unregisterSubscriber(EventBusSubscriber<? super T> subscriber) {
        if (!eventSubscribers.contains(subscriber)) {
            Log.d(this.getClass().getSimpleName()+ "-unregister", "unregisterSubscriber: EventBusSubscriber to unregister was not found in registry's subscriber list. Please always use the " +
                    "registry's register/unregister methods. Skipping.");
            return;
        }

        subscriber.unregister(eventBus);
        eventSubscribers.remove(subscriber);
    }

    /**
     * Subscribers that live from the start of the application until either finished or explicitly removed.
     * Opposite of dynamically added or removed subscribers.
     * @return
     */
    protected abstract List<EventBusSubscriber<T>> createDefaultSubscribers();
    protected void onBeforeRegisterDefaultSubscribers(){}
    protected void onBeforeUnregisterAllEventSubscribers(){}
}
