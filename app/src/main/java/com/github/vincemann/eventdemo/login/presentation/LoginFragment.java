package com.github.vincemann.eventdemo.login.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.vincemann.eventdemo.common.domain.AttachFragmentEvent;
import com.github.vincemann.eventdemo.di.DaggerFragment;
import com.github.vincemann.eventdemo.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.gunhansancar.eventbusexample.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ActivityScope
public class LoginFragment extends DaggerFragment implements LoginContract.View{

    @BindView(R.id.editTextUsername)
    TextView editTextUsername;

    @BindView(R.id.editTextPassword)
    TextView editTextPassword;

    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    @Inject
    LoginContract.Presenter presenter;

    @Inject
    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ((App) getActivity().getApplication()).getAppComponent()
//                .plus(new LoginViewModule(this))
//                .inject(this);


        View mainView = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, mainView);
        presenter.takeView(this);
        presenter.initialize();
        return mainView;
    }

    @Override
    public void navigateToCorrectLoginScreen() {
        GlobalEventBus.getInstance().post(new AttachFragmentEvent(new CorrectLoginFragment()));
    }

    @OnClick(R.id.buttonLogin)
    public void onLoginClicked() {
        presenter.performLogin(editTextUsername.getText().toString(),editTextPassword.getText().toString());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.dropView();
    }
}
