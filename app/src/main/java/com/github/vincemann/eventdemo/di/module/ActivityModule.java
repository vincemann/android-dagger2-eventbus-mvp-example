package com.github.vincemann.eventdemo.di.module;

import com.github.vincemann.eventdemo.MainActivity;
import com.github.vincemann.eventdemo.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {TimerModule.class,LoginModule.class})
    abstract MainActivity bindMainActivity();
}
