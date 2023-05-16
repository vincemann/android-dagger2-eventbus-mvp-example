package com.github.vincemann.eventdemo.login.presentation;

import com.github.vincemann.eventdemo.common.presentation.BasePresenter;

public interface LoginContract {

    interface Presenter extends BasePresenter<View> {
        void performLogin(String username, String password);
    }

    interface View{
        void navigateToCorrectLoginScreen();
    }
}
