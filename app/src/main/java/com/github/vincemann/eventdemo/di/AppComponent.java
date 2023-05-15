package com.github.vincemann.eventdemo.di;

import android.app.Application;

import com.github.vincemann.eventdemo.App;
import com.github.vincemann.eventdemo.di.view.LoginViewComponent;
import com.github.vincemann.eventdemo.di.view.LoginViewModule;
import com.github.vincemann.eventdemo.di.view.TimerViewComponent;
import com.github.vincemann.eventdemo.di.view.TimerViewModule;

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
        EventBusModule.class,
        LoginModule.class,
        TimerModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);
    LoginViewComponent plus(LoginViewModule module);
    TimerViewComponent plus(TimerViewModule module);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }


}
