package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract MainActivity bindsMainActivity();
}
