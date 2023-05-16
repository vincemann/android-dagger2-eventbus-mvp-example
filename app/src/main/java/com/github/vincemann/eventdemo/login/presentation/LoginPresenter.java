package com.github.vincemann.eventdemo.login.presentation;


import com.github.vincemann.eventdemo.common.presentation.AbstractPresenter;
//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.login.domain.CorrectLoginEvent;
import com.github.vincemann.eventdemo.login.domain.DoLoginEvent;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

@ActivityScope
public class LoginPresenter
        extends AbstractPresenter<LoginContract.View>
        implements LoginContract.Presenter{


    @Inject
    public LoginPresenter() {
    }

    @Override
    public void performLogin(String username, String password) {
        GlobalEventBus.getInstance().post(new DoLoginEvent(username, password));
    }

    @Subscribe
    public void onEvent(CorrectLoginEvent event) {
        view.navigateToCorrectLoginScreen();
    }


}
