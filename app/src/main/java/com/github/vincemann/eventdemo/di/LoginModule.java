package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.login.domain.DoLoginEventHandler;
import com.github.vincemann.eventdemo.login.domain.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

//    @Singleton
//    @Binds
//    public abstract LoginPresenter loginPresenter(LoginPresenter presenter);

//    @Provides
//    @Singleton
//    public LoginPresenter loginPresenter(LoginPresenter.View view){
//        return new LoginPresenter(view);
//    }

    @Provides
    @Singleton
    public DoLoginEventHandler doLoginEventHandler(){
        return new DoLoginEventHandler();
    }
//    @Singleton
//    @Binds
//    public abstract DoLoginEventHandler doLoginEventHandler(DoLoginEventHandler presenter);
}
