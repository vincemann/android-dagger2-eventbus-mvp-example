package com.github.vincemann.eventdemo.di.module;

import com.github.vincemann.eventdemo.common.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.common.di.scope.FragmentScope;

import com.github.vincemann.eventdemo.login.domain.DoLoginEventHandler;
import com.github.vincemann.eventdemo.login.presentation.CorrectLoginFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginContract;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginPresenter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {


    @FragmentScope
    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();

    @Binds
    @Singleton
    abstract DoLoginEventHandler doLoginEventHandler(DoLoginEventHandler eventHandler);


    @FragmentScope
    @ContributesAndroidInjector
    abstract CorrectLoginFragment bindCorrectLoginFragment();

    @ActivityScope
    @Binds
    abstract LoginContract.Presenter loginPresenter(LoginPresenter presenter);
}
