package com.fit.fast.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.R;
import com.fit.fast.callbacks.FoodData;
import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.FoodItemBinding;
import com.fit.fast.models.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {
    private static final String TAG = "FoodAdapter";
    private final Context context;
    private final List<Food> foodData;
    private final FoodData foodDataI;

    public FoodAdapter(Context context, List<Food> foodData, FoodData foodDataI) {
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
        Log.i(TAG, "onBindViewHolder: " + foodData.get(position));

        holder.binding.foodRb.setText(foodData.get(position).getName());

        holder.binding.foodDropdown.setDropDownHeight(700);
        holder.binding.foodDropdown.setDropDownBackgroundResource(R.color.dropdown_background);
        holder.binding.foodDropdown.setText("100");
        String[] grams = {"50", "100", "150"};
        holder.binding.foodDropdown.setAdapter(new ArrayAdapter(context, R.layout.sport_item, grams));

        holder.binding.foodRb.setChecked(foodData.get(position).isSelected());

        holder.binding.foodRb.setOnClickListener(v -> {
            if (foodData.get(position).isSelected()) {
                foodData.get(position).setSelected(false);
                holder.binding.foodRb.setChecked(false);

            } else {
                foodData.get(position).setSelected(true);
                holder.binding.foodRb.setChecked(true);

                String quantity = holder.binding.foodDropdown.getText().toString();
                foodData.get(position).setSelectedQuantity(quantity);
            }

            foodDataI.foodData(foodData.get(position));
        });

        holder.binding.foodDropdown.setOnItemClickListener((adapterView, view, i, l) -> {
            holder.binding.foodRb.setChecked(true);
            foodData.get(position).setSelected(true);

            String quantity = holder.binding.foodDropdown.getText().toString();
            foodData.get(position).setSelectedQuantity(quantity);
            foodDataI.foodData(foodData.get(position));
        });

    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: " + foodData.size());
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
