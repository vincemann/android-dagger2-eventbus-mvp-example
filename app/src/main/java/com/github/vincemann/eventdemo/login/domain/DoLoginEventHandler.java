package com.github.vincemann.eventdemo.login.domain;


import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

//@DefaultEventBusSubscriber
public class DoLoginEventHandler implements GlobalEventBusSubscriber {

    @Inject
    public DoLoginEventHandler() {
    }

    @Subscribe
    public void onEvent(DoLoginEvent event) {
        /**
         * Here is where we should perform a HTTP request to check the login credentials. Let's
         * assume the login is right
         */
        GlobalEventBus.getInstance().post(new CorrectLoginEvent());
    }
}