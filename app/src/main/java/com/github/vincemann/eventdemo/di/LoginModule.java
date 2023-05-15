package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.login.presentation.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Singleton
    @Provides
    public LoginPresenter loginPresenter(){
        return new LoginPresenter();
    }
}
