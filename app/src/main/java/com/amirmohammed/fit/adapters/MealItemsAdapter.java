package com.amirmohammed.fit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirmohammed.fit.databinding.MealImageItemBinding;

public class MealItemsAdapter extends RecyclerView.Adapter<MealItemsAdapter.Holder> {

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(MealImageItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public  class Holder extends RecyclerView.ViewHolder {

        MealImageItemBinding binding;

        public Holder(@NonNull MealImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
