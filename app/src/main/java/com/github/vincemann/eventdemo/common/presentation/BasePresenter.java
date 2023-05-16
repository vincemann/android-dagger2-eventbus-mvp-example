package com.github.vincemann.eventdemo.common.presentation;

import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;

public interface BasePresenter<T> {

    /**
     * Binds presenter with a View when resumed. The Presenter will perform initialization here.
     *
     * @param view the View associated with this presenter
     */
    void takeView(T view);

    /**
     * Drops the reference to the View when destroyed
     */
    void dropView();

    public void initialize();

    /**
     * Called when the presenter is resumed. After the initialization and when the presenter comes
     * from a pause state.
     */
    public void resume();

    /**
     * Called when the presenter is paused.
     */
    public void pause();

}
