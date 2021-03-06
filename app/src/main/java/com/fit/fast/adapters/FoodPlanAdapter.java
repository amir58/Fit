package com.fit.fast.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.R;
import com.fit.fast.callbacks.FoodData;
import com.fit.fast.callbacks.FoodQTY;
import com.fit.fast.databinding.FoodItemBinding;
import com.fit.fast.databinding.ItemFoodBinding;
import com.fit.fast.models.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodPlanAdapter extends RecyclerView.Adapter<FoodPlanAdapter.FoodHolder> {
    private final List<Food> foodData;
//    private FoodQTY foodQTY;

    public FoodPlanAdapter(List<Food> foodData) {
        this.foodData = foodData;
//        this.foodQTY = foodQTY;

    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        holder.binding.setFoodName(foodData.get(position).getName());

        Log.i("FOOD", "onBindViewHolder: " + foodData.get(position).getImageUrl());
        Picasso.get().load(foodData.get(position).getImageUrl()).into(holder.binding.imageView);

//        foodQTY.getQTY(String.valueOf(foodData.get(position).getRealQuantity()));
    }

    @Override
    public int getItemCount() {
        return foodData.size();
    }

    public class FoodHolder extends RecyclerView.ViewHolder {
        ItemFoodBinding binding;

        public FoodHolder(@NonNull ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

