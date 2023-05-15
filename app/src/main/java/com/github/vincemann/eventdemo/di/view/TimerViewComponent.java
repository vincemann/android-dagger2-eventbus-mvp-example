package com.github.vincemann.eventdemo.di.view;

//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;
import com.github.vincemann.eventdemo.timer.presentation.TimerFragment;

import dagger.Subcomponent;

// @PerFragment
@Subcomponent(modules = TimerViewModule.class)
public interface TimerViewComponent {
    public TimerFragment inject(TimerFragment fragment);
}
