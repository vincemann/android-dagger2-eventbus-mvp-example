package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.login.domain.LoginPresenter;
import com.github.vincemann.eventdemo.login.presentation.CorrectLoginFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;
import com.github.vincemann.eventdemo.timer.domain.TimerPresenter;
import com.github.vincemann.eventdemo.timer.presentation.TimerFragment;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract TimerFragment bindTimerFragment();

    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();

//    @Binds
//    @Singleton
//    abstract LoginPresenter.View loginPresenterView(LoginFragment loginFragment);
//
//    @Binds
//    @Singleton
//    abstract TimerPresenter.View timerPresenterView(TimerFragment loginFragment);

    @ContributesAndroidInjector
    abstract CorrectLoginFragment bindCorrectLoginFragment();
}
