package com.github.vincemann.eventdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.vincemann.eventdemo.common.domain.AttachFragmentEvent;
import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;
import com.github.vincemann.eventdemo.timer.presentation.TimerFragment;
import com.gunhansancar.eventbusexample.R;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class MainActivity extends AppCompatActivity
    implements GlobalEventBusSubscriber, HasAndroidInjector
{

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.main_activity);

        GlobalEventBusRegistry.getInstance().registerSubscriber(this);

        if (savedInstanceState == null) {
            attachFragment(new TimerFragment());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalEventBusRegistry.getInstance().unregisterSubscriber(this);
    }

    @Subscribe
    public void onEvent(AttachFragmentEvent event) {
        attachFragment(event.getFragment());
    }

    private void attachFragment(android.app.Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }


}
