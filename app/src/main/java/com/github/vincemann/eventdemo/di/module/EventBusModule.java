package com.github.vincemann.eventdemo.di.module;

import android.content.Context;


import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;
import com.github.vincemann.eventdemo.login.domain.DoLoginEventHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EventBusModule {

    @Provides
    public Set<GlobalEventBusSubscriber> provideDefaultEventbusSubscribers(DoLoginEventHandler loginEventHandler){
        Set<GlobalEventBusSubscriber> subscribers = new HashSet<>();
        subscribers.add(loginEventHandler);
        return subscribers;
    }

    @Singleton
    @Provides
    public GlobalEventBusRegistry createGlobalEventBusRegistry(Context context,
                                                               Set<GlobalEventBusSubscriber> defaultGlobalEventbusSubscribers){
        GlobalEventBusRegistry registry = new GlobalEventBusRegistry(context);
        for (GlobalEventBusSubscriber subscriber : defaultGlobalEventbusSubscribers){
            registry.registerSubscriber(subscriber);
        }
//        registry.registerSubscriber(defaultGlobalEventbusSubscribers);
//        registry.registerDefaultSubscribers();
        return registry;
    }
}
