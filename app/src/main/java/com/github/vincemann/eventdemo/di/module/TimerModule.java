package com.github.vincemann.eventdemo.di.module;

import com.github.vincemann.eventdemo.common.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.common.di.scope.FragmentScope;
import com.github.vincemann.eventdemo.timer.domain.TimerService;
import com.github.vincemann.eventdemo.timer.presentation.TimerContract;
import com.github.vincemann.eventdemo.timer.presentation.TimerFragment;
import com.github.vincemann.eventdemo.timer.presentation.TimerPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TimerModule {


    @FragmentScope
    @ContributesAndroidInjector
    abstract TimerFragment bindTimerFragment();

    @ActivityScope
    @Provides
    public static TimerService timerService(){
        return new TimerService();
    }

    @ActivityScope
    @Binds
    abstract TimerContract.Presenter presenter(TimerPresenter presenter);

//    @Provides
//    @Singleton
//    public TimerPresenter timerPresenter(TimerPresenter.View view, TimerService timerService){
//        return new TimerPresenter(view,timerService);
//    }
}
