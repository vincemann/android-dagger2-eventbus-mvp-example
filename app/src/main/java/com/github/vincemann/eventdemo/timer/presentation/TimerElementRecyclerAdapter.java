package com.github.vincemann.eventdemo.timer.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.vincemann.eventdemo.timer.domain.TimerItem;
import com.github.vincemann.eventdemo.timer.domain.TimerItemOnClickListener;
import com.gunhansancar.eventbusexample.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gunhansancar on 06/04/16.
 */
public class TimerElementRecyclerAdapter extends RecyclerView.Adapter<TimerElementRecyclerAdapter.ItemHolder> {
    private static int[] COLORS = {
            R.color.blue_500,
            R.color.green_500,
            R.color.orange_500,
            R.color.pink_500
    };
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);


    private List<TimerItem> timerItems = new ArrayList<>();
    private TimerItemOnClickListener onItemClickListener;

    @Override
    public TimerElementRecyclerAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timer_element, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TimerElementRecyclerAdapter.ItemHolder holder, int position) {
        holder.bind(timerItems.get(position));
    }

    @Override
    public int getItemCount() {
        return timerItems.size();
    }

    public void append(TimerItem element) {
        timerItems.add(element);
        notifyItemInserted(getItemCount());
    }

    public void delete(int position) {
        timerItems.remove(position);
        notifyItemRemoved(position);
    }

    public TimerItem getItem(int position) {
        return timerItems.get(position);
    }

    public void setOnItemClickListener(TimerItemOnClickListener listener) {
        onItemClickListener = listener;
    }

    public TimerItemOnClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

//    public interface OnItemClickListener {
//        void onItemClick(TimerElement item);
//    }

    class ItemHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        @BindView(R.id.timer_item_id_text) TextView timerItemIdTextView;
        @BindView(R.id.timer_item_time_text) TextView timerItemTimeTextView;
        @BindView(R.id.timer_item) View timerItem;

//        private TimerElementRecyclerAdapter adapter;

        public ItemHolder(View itemView/*, TimerElementRecyclerAdapter parent*/) {
            super(itemView);
            ButterKnife.bind(this, itemView);

//            itemView.setOnClickListener(this);
//            this.adapter = parent;
        }

        public void bind(TimerItem item) {
            timerItem.setBackgroundResource(COLORS[item.getId() % COLORS.length]);
            timerItemIdTextView.setText(String.format(Locale.ENGLISH, "Event ID: %d", item.getId()));
            timerItemTimeTextView.setText(DATE_FORMAT.format(item.getDate()));
        }

        @OnClick(R.id.timer_item)
        public void onClickTimerItem(){
            TimerItemOnClickListener listener = getOnItemClickListener();
            if (listener != null) {
                listener.onTimerItemClicked(getItem(getAdapterPosition()));
            }
        }

//        @Override
//        public void onClick(View v) {
//            final OnItemClickListener listener = adapter.getOnItemClickListener();
//            if (listener != null) {
//                listener.onItemClick(this, getAdapterPosition());
//            }
//        }
    }
}