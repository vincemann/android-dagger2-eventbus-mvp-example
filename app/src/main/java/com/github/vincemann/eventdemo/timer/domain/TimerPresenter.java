package com.github.vincemann.eventdemo.timer.domain;

import android.util.Log;

import com.github.vincemann.eventdemo.common.presentation.AbstractPresenter;
import com.github.vincemann.eventdemo.event.GlobalEventBus;

import javax.inject.Inject;

public class TimerPresenter extends AbstractPresenter
        implements TimerItemOnClickListener, TimerItemSwipeListener
{

    private View view;
    private TimerService timerService;

    @Override
    public void onTimerItemSwiped(int elementPos) {
        view.deleteTimerElement(elementPos);
    }

    @Inject
    public TimerPresenter(View view, TimerService timerService) {
        this.view = view;
        this.timerService = timerService;
    }

    public void startTimer(){
        view.displayTimerStarted();
        timerService.startTimer();
    }

    public void stopTimer(){
        view.displayTimerStopped();
        timerService.stopTimer();
    }


    @Override
    public void onTimerItemClicked(TimerElement timerElement) {
        Log.d(this.getClass().getSimpleName()+":onTimerItemClicked", "onTimerItemClicked: clicked on element: " + timerElement);
        view.navigateToLoginScreen();
    }


    public interface View{
        public void navigateToLoginScreen();
        public void deleteTimerElement(int pos);
        public void displayTimerStarted();
        public void displayTimerStopped();
    }
}
