package com.github.vincemann.eventdemo.di;

import android.app.Application;

import com.github.vincemann.eventdemo.App;
import com.github.vincemann.eventdemo.di.module.ActivityModule;
import com.github.vincemann.eventdemo.di.module.AppModule;
import com.github.vincemann.eventdemo.di.module.EventBusModule;
import com.github.vincemann.eventdemo.di.module.LoginModule;
import com.github.vincemann.eventdemo.di.module.TimerModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;




@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        EventBusModule.class,
})
public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }


}
