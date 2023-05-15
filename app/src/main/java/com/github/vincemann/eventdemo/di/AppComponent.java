package com.github.vincemann.eventdemo.di;

import android.app.Application;

import com.github.vincemann.eventdemo.App;

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
        FragmentModule.class,
        LoginModule.class,
        TimerModule.class
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
