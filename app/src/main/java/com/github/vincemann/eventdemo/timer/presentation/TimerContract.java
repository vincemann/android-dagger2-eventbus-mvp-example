package com.github.vincemann.eventdemo.timer.presentation;

import com.github.vincemann.eventdemo.common.presentation.BasePresenter;
import com.github.vincemann.eventdemo.timer.domain.TimerItem;
import com.github.vincemann.eventdemo.timer.domain.TimerItemOnClickListener;
import com.github.vincemann.eventdemo.timer.domain.TimerItemSwipeListener;

public interface TimerContract {

    interface View{
        public void insertTimerElement(TimerItem timerItem);
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
