package com.github.vincemann.eventdemo.timer.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.vincemann.eventdemo.timer.domain.TimerElement;
import com.gunhansancar.eventbusexample.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

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


    private List<TimerElement> timerElements = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    @Override
    public TimerElementRecyclerAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timer_event, parent, false);
        return new ItemHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(TimerElementRecyclerAdapter.ItemHolder holder, int position) {
        holder.bind(timerElements.get(position));
    }

    @Override
    public int getItemCount() {
        return timerElements.size();
    }

    public void append(TimerElement element) {
        timerElements.add(element);
        notifyItemInserted(getItemCount());
    }

    public void delete(int position) {
        timerElements.remove(position);
        notifyItemRemoved(position);
    }

    public TimerElement getItem(int position) {
        return timerElements.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ItemHolder item, int position);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textView1) TextView textView1;
        @BindView(R.id.textView2) TextView textView2;
        @BindView(R.id.parentLayout) View parentLayout;

        private TimerElementRecyclerAdapter adapter;

        public ItemHolder(View itemView, TimerElementRecyclerAdapter parent) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            this.adapter = parent;
        }

        public void bind(TimerElement item) {
            parentLayout.setBackgroundResource(COLORS[item.getId() % COLORS.length]);
            textView1.setText(String.format(Locale.ENGLISH, "Event ID: %d", item.getId()));
            textView2.setText(DATE_FORMAT.format(item.getDate()));
        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = adapter.getOnItemClickListener();
            if (listener != null) {
                listener.onItemClick(this, getAdapterPosition());
            }
        }
    }
}