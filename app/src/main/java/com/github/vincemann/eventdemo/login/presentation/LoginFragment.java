package com.github.vincemann.eventdemo.login.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.vincemann.eventdemo.common.domain.AttachFragmentEvent;
import com.github.vincemann.eventdemo.di.DIFragment;
import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.login.domain.LoginPresenter;
import com.gunhansancar.eventbusexample.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends DIFragment implements LoginPresenter.View{

    @BindView(R.id.editTextUsername)
    TextView editTextUsername;

    @BindView(R.id.editTextPassword)
    TextView editTextPassword;

    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    @Inject
    LoginPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void navigateToCorrectLoginScreen() {
        GlobalEventBus.getInstance().post(new AttachFragmentEvent(new CorrectLoginFragment()));
    }

    @OnClick(R.id.buttonLogin)
    public void onLoginClicked() {
        presenter.performLogin(editTextUsername.getText().toString(),editTextPassword.getText().toString());
    }

}
