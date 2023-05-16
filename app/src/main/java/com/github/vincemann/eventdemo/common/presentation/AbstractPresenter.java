package com.github.vincemann.eventdemo.common.presentation;

import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;

public abstract class AbstractPresenter<T> implements BasePresenter<T> {
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

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
