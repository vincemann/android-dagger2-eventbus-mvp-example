package com.github.vincemann.eventdemo.timer.presentation.touchadapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vincemann.eventdemo.timer.domain.TimerItemSwipeListener;

public class TimerItemSwipeAdapter extends ItemTouchHelper.SimpleCallback{
    private TimerItemSwipeListener itemSwipeListener;


    public TimerItemSwipeAdapter(TimerItemSwipeListener itemSwipeListener) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.itemSwipeListener = itemSwipeListener;
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        itemSwipeListener.onTimerItemSwiped(viewHolder.getAdapterPosition());
    }
}
