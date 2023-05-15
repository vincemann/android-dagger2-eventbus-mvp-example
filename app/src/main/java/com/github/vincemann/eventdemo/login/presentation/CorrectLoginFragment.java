package com.github.vincemann.eventdemo.login.presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vincemann.eventdemo.di.DIFragment;
import com.gunhansancar.eventbusexample.R;

import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class CorrectLoginFragment extends DIFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.correct_login_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
