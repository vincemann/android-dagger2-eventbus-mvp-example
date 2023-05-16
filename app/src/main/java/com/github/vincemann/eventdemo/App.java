package com.github.vincemann.eventdemo;

import androidx.multidex.MultiDexApplication;

import com.github.vincemann.eventdemo.di.AppComponent;
import com.github.vincemann.eventdemo.di.DaggerAppComponent;
import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import lombok.Getter;

public class App
        extends MultiDexApplication
        implements HasAndroidInjector
{


    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Getter
    private AppComponent appComponent;

    private static App INSTANCE;
    @Inject
    GlobalEventBusRegistry eventBusRegistry;


    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        INSTANCE = this;
        appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        startEventProcessing();
        super.onCreate();
    }

    private void startEventProcessing() {
//        eventBusRegistry = new GlobalEventBusRegistry(this);
        eventBusRegistry.registerDefaultSubscribers();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        INSTANCE = null;
        eventBusRegistry.unregisterAllSubscribers();
        eventBusRegistry = null;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

}
