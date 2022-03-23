package com.amirmohammed.fit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirmohammed.fit.databinding.WorkoutsItemBinding;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.Holder>{

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(WorkoutsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.workoutRv.setAdapter(new PopularWorkoutsAdapter());
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class Holder extends RecyclerView.ViewHolder {
        WorkoutsItemBinding binding;
        public Holder(@NonNull WorkoutsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
