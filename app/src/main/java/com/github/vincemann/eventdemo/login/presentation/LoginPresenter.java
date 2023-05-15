package com.github.vincemann.eventdemo.login.presentation;


import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.login.domain.DoLoginEvent;

public class LoginPresenter {



    public void performLogin(String username, String password) {
        GlobalEventBus.getInstance().post(new DoLoginEvent(username, password));
    }
}
