package com.github.vincemann.eventdemo.di.view;

//import com.github.vincemann.eventdemo.di.PerFragment;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;

import dagger.Subcomponent;

// @PerFragment
@Subcomponent(modules = LoginViewModule.class)
public interface LoginViewComponent {
    public LoginFragment inject(LoginFragment loginFragment);
}
