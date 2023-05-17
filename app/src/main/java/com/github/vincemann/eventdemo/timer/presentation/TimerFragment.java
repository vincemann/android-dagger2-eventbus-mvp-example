package com.github.vincemann.eventdemo.timer.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vincemann.eventdemo.common.di.DaggerFragment;
import com.github.vincemann.eventdemo.common.di.scope.ActivityScope;
import com.github.vincemann.eventdemo.common.event.AttachFragmentEvent;
import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;
import com.github.vincemann.eventdemo.timer.domain.TimerItem;
import com.gunhansancar.eventbusexample.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ActivityScope
public class TimerFragment extends DaggerFragment
        implements TimerContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    TimerElementRecyclerAdapter adapter;

    @Inject
    TimerContract.Presenter presenter;

    @Inject
    public TimerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ((App) getActivity().getApplication()).getAppComponent()
//                .plus(new TimerViewModule(this))
//                .inject(this);


        View mainView = inflater.inflate(R.layout.timer_fragment, container, false);
        presenter.takeView(this);
        ButterKnife.bind(this, mainView);
        presenter.initialize();



        adapter = new TimerElementRecyclerAdapter();
        // creating onClick IF here to separate ui logic from business logic - no android imports in presenter wanted
        adapter.setOnItemClickListener(presenter);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        // creating adapters here to separate ui logic from business logic - no android imports in presenter wanted
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TimerItemSwipeAdapter(presenter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return mainView;
    }

    @OnClick(R.id.startButton)
    public void onStartClicked() {
        presenter.startTimer();
    }

    @OnClick(R.id.stopButton)
    public void onStopClicked() {
        presenter.stopTimer();
    }


    @Override
    public void displayTimerStarted() {
        Toast.makeText(getActivity(), "Timer is started.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayTimerStopped() {
        Toast.makeText(getActivity(), "Timer is stopped.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void deleteTimerElement(int pos) {
        adapter.delete(pos);
    }

    @Override
    public void navigateToLoginScreen() {
        GlobalEventBus.getInstance().post(new AttachFragmentEvent(new LoginFragment()));
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

    @Override
    public void insertTimerElement(TimerItem timerItem) {
        adapter.append(timerItem);
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }
}
