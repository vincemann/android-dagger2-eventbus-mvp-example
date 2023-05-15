package com.github.vincemann.eventdemo.di.view;


//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.login.domain.LoginPresenter;
import com.github.vincemann.eventdemo.timer.domain.TimerPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TimerViewModule {

    private TimerPresenter.View view;

    public TimerViewModule(TimerPresenter.View view) {
        this.view = view;
    }

    @Provides
    // @PerFragment
    public TimerPresenter.View provideView(){
        return view;
    }
}
