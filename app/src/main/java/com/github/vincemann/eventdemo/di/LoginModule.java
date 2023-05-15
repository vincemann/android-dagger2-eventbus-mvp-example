package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.login.domain.LoginPresenter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class LoginModule {

    @Singleton
    @Binds
    public abstract LoginPresenter loginPresenter(LoginPresenter presenter);
}
