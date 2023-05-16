package com.github.vincemann.eventdemo.timer.presentation;

import android.app.Activity;
import android.graphics.Movie;

import com.github.vincemann.eventdemo.common.presentation.BasePresenter;
import com.github.vincemann.eventdemo.timer.domain.TimerElement;
import com.github.vincemann.eventdemo.timer.domain.TimerItemOnClickListener;
import com.github.vincemann.eventdemo.timer.domain.TimerItemSwipeListener;

import java.util.ArrayList;

public interface TimerContract {

    interface View{
        public void insertTimerElement(TimerElement timerElement);
        public void navigateToLoginScreen();
        public void deleteTimerElement(int pos);
        public void displayTimerStarted();
        public void displayTimerStopped();
    }

    interface Presenter extends BasePresenter<View>, TimerItemOnClickListener, TimerItemSwipeListener {
        public void startTimer();
        public void stopTimer();
    }
}
