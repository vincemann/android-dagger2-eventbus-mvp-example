package com.github.vincemann.eventdemo.di.module;

import com.github.vincemann.eventdemo.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.di.scope.FragmentScope;
import com.github.vincemann.eventdemo.timer.domain.TimerService;
import com.github.vincemann.eventdemo.timer.presentation.TimerContract;
import com.github.vincemann.eventdemo.timer.presentation.TimerFragment;
import com.github.vincemann.eventdemo.timer.presentation.TimerPresenter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TimerModule {


    @FragmentScope
    @ContributesAndroidInjector
    abstract TimerFragment bindTimerFragment();

    @Binds
    @Singleton
    abstract TimerService timerService(TimerService timerService);

    @ActivityScope
    @Binds
    abstract TimerContract.Presenter presenter(TimerPresenter presenter);

//    @Provides
//    @Singleton
//    public TimerPresenter timerPresenter(TimerPresenter.View view, TimerService timerService){
//        return new TimerPresenter(view,timerService);
//    }
}
