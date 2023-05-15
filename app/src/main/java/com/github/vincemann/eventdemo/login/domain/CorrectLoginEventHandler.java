package com.github.vincemann.eventdemo.login.domain;

import com.github.vincemann.eventdemo.common.domain.AttachFragmentEvent;
import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;
import com.github.vincemann.eventdemo.login.presentation.CorrectLoginFragment;

import org.greenrobot.eventbus.Subscribe;

public class CorrectLoginEventHandler implements GlobalEventBusSubscriber {

    @Subscribe
    public void onEvent(CorrectLoginEvent event) {
        GlobalEventBus.getInstance().post(new AttachFragmentEvent(new CorrectLoginFragment()));
    }
}