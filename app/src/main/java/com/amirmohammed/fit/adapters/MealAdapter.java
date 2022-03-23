package com.amirmohammed.fit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirmohammed.fit.databinding.MealItemBinding;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.Holder>{

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(MealItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.mealRv.setAdapter(new MealItemsAdapter());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class Holder extends RecyclerView.ViewHolder {
        MealItemBinding binding;
        public Holder(@NonNull MealItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}