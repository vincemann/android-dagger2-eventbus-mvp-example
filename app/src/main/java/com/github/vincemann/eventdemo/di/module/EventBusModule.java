package com.github.vincemann.eventdemo.di.module;

import android.content.Context;

import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;
import com.github.vincemann.eventdemo.login.domain.DoLoginEventHandler;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EventBusModule {

    @Singleton
    @Provides
    public GlobalEventBusRegistry createGlobalEventBusRegistry(Context context,
                                                               DoLoginEventHandler doLoginEventHandler){
        GlobalEventBusRegistry registry = new GlobalEventBusRegistry(context);
//        for (GlobalEventBusSubscriber subscriber : subscribers){
//            registry.registerSubscriber(subscriber);
//        }
        registry.registerSubscriber(doLoginEventHandler);
//        registry.registerDefaultSubscribers();
        return registry;
    }
}
