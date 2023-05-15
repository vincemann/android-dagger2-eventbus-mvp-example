package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.timer.domain.TimerService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TimerModule {

    @Binds
    @Singleton
    abstract TimerService timerService(TimerService service);
}
