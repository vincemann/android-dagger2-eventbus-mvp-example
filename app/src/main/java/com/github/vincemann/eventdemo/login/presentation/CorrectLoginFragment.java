package com.github.vincemann.eventdemo.login.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vincemann.eventdemo.common.di.DaggerFragment;
import com.github.vincemann.eventdemo.common.di.scope.ActivityScope;
import com.gunhansancar.eventbusexample.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CorrectLoginFragment extends DaggerFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.correct_login_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
