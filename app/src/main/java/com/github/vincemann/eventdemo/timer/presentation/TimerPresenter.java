package com.github.vincemann.eventdemo.timer.presentation;

import android.util.Log;

import com.github.vincemann.eventdemo.common.presentation.AbstractPresenter;
//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.timer.domain.TimerElement;
import com.github.vincemann.eventdemo.timer.domain.TimerService;
import com.github.vincemann.eventdemo.timer.presentation.TimerContract;

import javax.inject.Inject;

@ActivityScope
public class TimerPresenter
        extends AbstractPresenter<TimerContract.View>
        implements TimerContract.Presenter

{
    private TimerService timerService;

    @Override
    public void onTimerItemSwiped(int elementPos) {
        view.deleteTimerElement(elementPos);
    }

    @Inject
    public TimerPresenter(TimerService timerService) {
        this.timerService = timerService;
    }

    @Override
    public void startTimer(){
        view.displayTimerStarted();
        timerService.startTimer();
    }

    @Override
    public void stopTimer(){
        view.displayTimerStopped();
        timerService.stopTimer();
    }


    @Override
    public void onTimerItemClicked(TimerElement timerElement) {
        Log.d(this.getClass().getSimpleName()+":onTimerItemClicked", "onTimerItemClicked: clicked on element: " + timerElement);
        view.navigateToLoginScreen();
    }



}
