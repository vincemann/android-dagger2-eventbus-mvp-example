package com.github.vincemann.eventdemo.timer.domain;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;

import org.greenrobot.eventbus.Subscribe;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

/**
 * Created by gunhansancar on 06/04/16.
 *
 * @modifiedBy vincemann
 */
public class TimerService implements GlobalEventBusSubscriber {

    private Timer timer;
    private AtomicInteger counter = new AtomicInteger();

    @Inject
    public TimerService() {
        GlobalEventBusRegistry.getInstance().registerSubscriber(this);
    }

    protected void startTimer() {
        stopTimer();
        timer = new Timer();
        timer.scheduleAtFixedRate(new SimpleTimerTask(counter), 0, 3000);
    }

    protected void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        GlobalEventBusRegistry.getInstance().unregisterSubscriber(this);
    }

    private static class SimpleTimerTask extends TimerTask {

        private AtomicInteger current;

        public SimpleTimerTask(AtomicInteger current) {
            this.current = current;
        }

        @Override
        public void run() {
            GlobalEventBus.getInstance().postSticky(
                    new AddTimerElementEvent(
                            new TimerElement(current.addAndGet(1))
                    )
            );
        }
    }
}
