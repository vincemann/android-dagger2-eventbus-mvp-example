package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.login.presentation.CorrectLoginFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;
import com.github.vincemann.eventdemo.timer.presentation.TimerFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract TimerFragment bindTimerFragment();

    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();

    @ContributesAndroidInjector
    abstract CorrectLoginFragment bindCorrectLoginFragment();
}
