package com.fit.fast.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.callbacks.DaysCallback;
import com.fit.fast.databinding.DayBtnItemBinding;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysHolder>{

    private Context context;
    private int days;
    private DaysCallback daysCallback;

    public DaysAdapter(Context context, int days, DaysCallback daysCallback) {
        this.context = context;
        this.days = days;
        this.daysCallback = daysCallback;
    }

    @NonNull
    @Override
    public DaysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysHolder(DayBtnItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DaysHolder holder, int position) {
        holder.binding.pushDayBtn.setText("Day "+ ++position);
        holder.binding.pushDayBtn.setStrokeWidth(1);

        int finalPosition = ++position;
        holder.binding.pushDayBtn.setOnClickListener(v->{
            daysCallback.days(finalPosition);
        });
    }

    @Override
    public int getItemCount() {
        return days;
    }

    public class DaysHolder extends RecyclerView.ViewHolder {
        DayBtnItemBinding binding;
        public DaysHolder(@NonNull DayBtnItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
