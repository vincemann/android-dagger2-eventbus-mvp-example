package com.github.vincemann.eventdemo.di.view;

//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.login.domain.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginViewModule {

    private LoginPresenter.View view;

    public LoginViewModule(LoginPresenter.View view) {
        this.view = view;
    }

    @Provides
//    // @PerFragment
    public LoginPresenter.View provideView(){
        return view;
    }
}
