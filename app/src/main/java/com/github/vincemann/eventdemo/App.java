package com.github.vincemann.eventdemo;

import androidx.multidex.MultiDexApplication;

import com.github.vincemann.eventdemo.di.AppComponent;
import com.github.vincemann.eventdemo.di.DaggerAppComponent;
import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class App
        extends MultiDexApplication
        implements HasAndroidInjector
{


//    @Inject
//    DispatchingAndroidInjector<Activity> activityInjector;
//    @Inject
//    DispatchingAndroidInjector<Fragment> fragmentInjector;


    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    private AppComponent mComponent;

    private static App INSTANCE;
    private GlobalEventBusRegistry eventBusRegistry;


    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        INSTANCE = this;
        mComponent = DaggerAppComponent.builder().application(this).build();
        mComponent.inject(this);
        startEventProcessing();
        super.onCreate();
    }

    private void startEventProcessing() {
        eventBusRegistry = new GlobalEventBusRegistry(this);
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

//    // Dependency Injection
//    @Override
//    public DispatchingAndroidInjector<Activity> activityInjector() {
//        return activityInjector;
//    }
//
//    @Override
//    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
//        return fragmentInjector;
//    }
}
