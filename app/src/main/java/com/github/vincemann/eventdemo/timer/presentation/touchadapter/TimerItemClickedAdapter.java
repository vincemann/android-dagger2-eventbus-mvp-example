package com.github.vincemann.eventdemo.timer.presentation.touchadapter;

import com.github.vincemann.eventdemo.timer.domain.TimerElement;
import com.github.vincemann.eventdemo.timer.domain.TimerItemOnClickListener;
import com.github.vincemann.eventdemo.timer.presentation.TimerElementRecyclerAdapter;

public class TimerItemClickedAdapter implements TimerElementRecyclerAdapter.OnItemClickListener{

    private TimerItemOnClickListener onClickListener;
    private TimerElementRecyclerAdapter adapter;

    public TimerItemClickedAdapter(TimerItemOnClickListener onClickListener, TimerElementRecyclerAdapter adapter) {
        this.onClickListener = onClickListener;
        this.adapter = adapter;
    }

    @Override
    public void onItemClick(TimerElementRecyclerAdapter.ItemHolder item, int position) {
        TimerElement timerElement = adapter.getItem(position);
        onClickListener.onTimerItemClicked(timerElement);
    }
}
