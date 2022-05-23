package com.fit.fast.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.R;
import com.fit.fast.callbacks.FoodData;
import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.FoodItemBinding;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    private Context context;
    private List<List<String>> foodData;
    private FoodData foodDataI;

    public FoodAdapter(Context context, List<List<String>> foodData, FoodData foodDataI) {
        this.context = context;
        this.foodData = foodData;
        this.foodDataI = foodDataI;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodHolder(FoodItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {

        holder.binding.foodRb.setText(foodData.get(0).get(position));

        holder.binding.foodDropdown.setDropDownHeight(700);
        holder.binding.foodDropdown.setDropDownBackgroundResource(R.color.dropdown_background);
        holder.binding.foodDropdown.setText("100");
        String[] grams = {"50", "100", "150"};
        holder.binding.foodDropdown.setAdapter(new ArrayAdapter(context, R.layout.sport_item, grams));

        final boolean[] isChecked = {false};
        holder.binding.foodRb.setOnClickListener(v -> {
            if (isChecked[0]) {
                holder.binding.foodRb.setChecked(false);
                isChecked[0] = false;
                foodDataI.foodData(holder.binding.foodRb.getText().toString(),
                        holder.binding.foodDropdown.getText().toString(),
                        -getCalories(holder, position));
            } else {
                holder.binding.foodRb.setChecked(true);
                isChecked[0] = true;

                String quantity = holder.binding.foodDropdown.getText().toString();
                foodDataI.foodData(holder.binding.foodRb.getText().toString(),
                        quantity,
                        getCalories(holder, position));
            }
        });

        String quantity = holder.binding.foodDropdown.getText().toString();
        Log.i("abdo", "onBindViewHolder: " + quantity);
    }

    private double getCalories(FoodHolder holder, int position) {
        if (Double.parseDouble(holder.binding.foodDropdown.getText().toString()) == 100) {
            return Double.parseDouble(foodData.get(2).get(position));
        } else if (Double.parseDouble(holder.binding.foodDropdown.getText().toString()) == 150) {
           return (Double.parseDouble(foodData.get(2).get(position)) +
                    0.5 * (Double.parseDouble(foodData.get(2).get(position))));
        }else if (Double.parseDouble(holder.binding.foodDropdown.getText().toString()) == 50){
            return (0.5 * (Double.parseDouble(foodData.get(2).get(position))));
        }
        return 0.0;
    }

    @Override
    public int getItemCount() {
        return foodData.size();
    }

    public class FoodHolder extends RecyclerView.ViewHolder {
        FoodItemBinding binding;

        public FoodHolder(@NonNull FoodItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
