package com.github.vincemann.eventdemo.common.domain;

import android.app.Fragment;

import lombok.Data;

@Data
public class AttachFragmentEvent {
    private Class<? extends Fragment> fragmentClass;

    private Fragment fragment;

    public AttachFragmentEvent(Class<? extends Fragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public AttachFragmentEvent(Fragment fragment) {
        this.fragment = fragment;
    }
}