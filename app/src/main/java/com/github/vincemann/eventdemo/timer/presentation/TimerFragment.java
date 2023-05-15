package com.github.vincemann.eventdemo.timer.presentation;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vincemann.eventdemo.common.domain.AttachFragmentEvent;
import com.github.vincemann.eventdemo.di.DIFragment;
import com.github.vincemann.eventdemo.event.GlobalEventBus;
import com.github.vincemann.eventdemo.event.GlobalEventBusRegistry;
import com.github.vincemann.eventdemo.event.GlobalEventBusSubscriber;
import com.github.vincemann.eventdemo.login.presentation.LoginFragment;
import com.github.vincemann.eventdemo.timer.domain.AddTimerElementEvent;
import com.github.vincemann.eventdemo.timer.domain.StopTimerEvent;
import com.github.vincemann.eventdemo.timer.domain.TimerService;
import com.gunhansancar.eventbusexample.R;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

public class TimerFragment extends DIFragment implements GlobalEventBusSubscriber {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    TimerRecyclerAdapter adapter;

//    @Inject
//    LoginFragment loginFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timer_fragment, container, false);
        ButterKnife.bind(this, view);
//        presenter = new LoginPresenter();



        adapter = new TimerRecyclerAdapter();
        adapter.setOnItemClickListener(new TimerRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TimerRecyclerAdapter.ItemHolder item, int position) {
                GlobalEventBus.getInstance().post(new AttachFragmentEvent(new LoginFragment()));
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        GlobalEventBusRegistry.getInstance().registerSubscriber(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        GlobalEventBusRegistry.getInstance().unregisterSubscriber(this);
    }

    @OnClick(R.id.startButton)
    public void onStartClicked() {
        Toast.makeText(getActivity(), "Timer is started.", Toast.LENGTH_SHORT).show();
        getActivity().startService(new Intent(getActivity(), TimerService.class));
    }

    @OnClick(R.id.stopButton)
    public void onStopClicked() {
        // todo usually you want to call the presenter here, which then triggers the event, handled in the presenter/service which calls methods on the
        // view interface this class is implementing. Abbreviated here
        Toast.makeText(getActivity(), "Timer is stopped.", Toast.LENGTH_SHORT).show();
        GlobalEventBus.getInstance().post(new StopTimerEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(AddTimerElementEvent event) {
        adapter.append(event);
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback
            = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }


        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            adapter.delete(viewHolder.getAdapterPosition());
        }
    };
}
