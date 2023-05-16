package com.github.vincemann.eventdemo.common.presentation;

import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;

public abstract class AbstractPresenter<T> implements GlobalEventBusSubscriber, BasePresenter<T> {
    protected T view;

    public AbstractPresenter() {
    }

    /**
     * Binds presenter with a View when resumed. The Presenter will perform initialization here.
     *
     * @param view the View associated with this presenter
     */
    public void takeView(T view) {
        this.view = view;
    }


    /**
     * Drops the reference to the View when destroyed
     */
    public void dropView(){
        this.view = null;
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
