package com.github.vincemann.eventdemo.common.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Subscriber for one specific eventbus.
 * Provides default implementation for register and unregister methods for convenience.
 */
public interface EventBusSubscriber<T extends EventBus> {

//    private EventBus eventBus;

    /**
     * These Methods should only be called by {@link AbstractEventBusRegistry} indirect via its {@link AbstractEventBusRegistry#registerSubscriber(EventBusSubscriber)}
     * and {@link AbstractEventBusRegistry#unregisterSubscriber(EventBusSubscriber)}
     */
    public default void register(T eventBus) {
        eventBus.register(this);
//        this.eventBus = eventBus;
//        this.eventBus.register(this);
//        return this;
    }

    /**
     * These Methods should only be called by {@link AbstractEventBusRegistry} indirect via its {@link AbstractEventBusRegistry#registerSubscriber(EventBusSubscriber)}
     * and {@link AbstractEventBusRegistry#unregisterSubscriber(EventBusSubscriber)}
     */
    public default void unregister(T eventBus) {
        eventBus.unregister(this);
//        this.eventBus = null;
    }

    // todo put this in a util class with the eventbus as an argument or variable
//    private final ScheduledExecutorService mExecutorService;
//
//    mExecutorService = Executors.newSingleThreadScheduledExecutor();


//    public ScheduledFuture<Object> postDelayed(Object event, long delay) {
//        return mExecutorService.schedule(new EDEventBus.PostEventCallable(this, event), delay, TimeUnit.MILLISECONDS);
//    }
//
//    private class PostEventCallable implements Callable<Object> {
//        private final EDEventBus mEventBus;
//        private final Object mEvent;
//
//        public PostEventCallable(EDEventBus eventBus, Object event) {
//            mEventBus = eventBus;
//            mEvent = event;
//        }
//
//        @Override
//        public Object call() throws Exception {
//            mEventBus.post(mEvent);
//            return null;
//        }
//    }


    // todo I dont see why one should not use the EventBus's API directly. Why should a Subscriber be pushed to event himself publish events
    //  and why should it be limited or guide towards publishing on the bus itself is subscribed to?
    //  Maybe put this in some utility class with the stuff commented out above?
//    protected void post(Object event) {
//        if (eventBus == null) {
//            throw new NullPointerException("EventRegistry.register() was not called. Is the subscriber registered in the EventBusRegistry? Maybe it was unregistered before this call?");
//        }
//        eventBus.post(event);
//    }
//
//    protected void postSticky(Object event) {
//        if (eventBus == null) {
//            throw new NullPointerException("EventRegistry.register() was not called. Is the subscriber registered in the EventBusRegistry? Maybe it was unregistered before this call?");
//        }
//        eventBus.postSticky(event);
//    }
//
//    protected <T> T removeStickyEvent(Class<T> eventType) {
//        if (eventBus == null) {
//            throw new NullPointerException("EventRegistry.register() was not called. Is the subscriber registered in the EventBusRegistry? Maybe it was unregistered before this call?");
//        }
//        return eventBus.removeStickyEvent(eventType);
//    }
//
//    protected boolean removeStickyEvent(Object event) {
//        if (eventBus == null) {
//            throw new NullPointerException("EventRegistry.register() was not called. Is the subscriber registered in the EventBusRegistry? Maybe it was unregistered before this call?");
//        }
//        return eventBus.removeStickyEvent(event);
//    }
//
//    protected <T> T getStickyEvent(Class<T> eventType) {
//        if (eventBus == null) {
//            throw new NullPointerException("EventRegistry.register() was not called. Is the subscriber registered in the EventBusRegistry? Maybe it was unregistered before this call?");
//        }
//        return eventBus.getStickyEvent(eventType);
//    }
}