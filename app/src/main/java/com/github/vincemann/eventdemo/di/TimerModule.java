package com.github.vincemann.eventdemo.di;

import com.github.vincemann.eventdemo.timer.domain.TimerPresenter;
import com.github.vincemann.eventdemo.timer.domain.TimerService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class TimerModule {

    @Provides
    @Singleton
    public TimerService timerService(){
        return new TimerService();
    }

//    @Provides
//    @Singleton
//    public TimerPresenter timerPresenter(TimerPresenter.View view, TimerService timerService){
//        return new TimerPresenter(view,timerService);
//    }
}
