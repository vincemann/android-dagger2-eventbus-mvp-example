package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.di.scope.FragmentScope;
import com.github.vincemann.eventdemo.login.domain.DoLoginEventHandler;
import com.github.vincemann.eventdemo.login.presentation.CorrectLoginFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;

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
}
