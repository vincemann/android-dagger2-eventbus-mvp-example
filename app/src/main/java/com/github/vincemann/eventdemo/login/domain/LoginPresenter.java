package com.github.vincemann.eventdemo.login.domain;


import com.github.vincemann.eventdemo.common.presentation.AbstractPresenter;
//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.event.GlobalEventBus;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

// @PerFragment
public class LoginPresenter extends AbstractPresenter {

    private View view;

    @Inject
    public LoginPresenter(View view) {
        this.view = view;
    }



    public void performLogin(String username, String password) {
        GlobalEventBus.getInstance().post(new DoLoginEvent(username, password));
    }

    @Subscribe
    public void onEvent(CorrectLoginEvent event) {
        view.navigateToCorrectLoginScreen();
    }

    public interface View{
        void navigateToCorrectLoginScreen();
    }
}
