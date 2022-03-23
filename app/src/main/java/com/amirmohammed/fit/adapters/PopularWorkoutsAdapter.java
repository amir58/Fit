package com.amirmohammed.fit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirmohammed.fit.databinding.PopularWorkoutItemBinding;

public class PopularWorkoutsAdapter extends RecyclerView.Adapter<PopularWorkoutsAdapter.Holder>{

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(PopularWorkoutItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class Holder extends RecyclerView.ViewHolder {

        PopularWorkoutItemBinding binding;

        public Holder(@NonNull PopularWorkoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}