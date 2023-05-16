package com.github.vincemann.eventdemo.common.presentation;

import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;

public abstract class EventConsumingPresenter<T> extends AbstractPresenter<T> implements GlobalEventBusSubscriber {

    public EventConsumingPresenter() {
    }

    /**
     * Called when the presenter is initialized, this method represents the start of the presenter
     * lifecycle.
     */
    public void initialize(){
        GlobalEventBusRegistry.getInstance().registerSubscriber(this);
    }

    /**
     * Called when the presenter is resumed. After the initialization and when the presenter comes
     * from a pause state.
     */
    public void resume(){
        GlobalEventBusRegistry.getInstance().registerSubscriber(this);
    }

    /**
     * Called when the presenter is paused.
     */
    public void pause(){
        GlobalEventBusRegistry.getInstance().unregisterSubscriber(this);
    }
}
