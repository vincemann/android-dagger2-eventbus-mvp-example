package com.github.vincemann.eventdemo.timer.domain;

import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;


public class TimerService implements GlobalEventBusSubscriber {

    private Timer timer;
    private AtomicInteger counter = new AtomicInteger();


    @Inject
    public TimerService() {
//        GlobalEventBusRegistry.getInstance().registerSubscriber(this);
    }

    public void startTimer() {
        stopTimer();
        timer = new Timer();
        timer.scheduleAtFixedRate(new SimpleTimerTask(counter), 0, 3000);
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
//        GlobalEventBusRegistry.getInstance().unregisterSubscriber(this);
    }



    private static class SimpleTimerTask extends TimerTask {

        private AtomicInteger current;

        public SimpleTimerTask(AtomicInteger current) {
            this.current = current;
        }

        @Override
        public void run() {
            GlobalEventBus.getInstance().postSticky(
                    new AddTimerItemEvent(
                            new TimerItem(current.addAndGet(1))
                    )
            );
        }
    }
}
