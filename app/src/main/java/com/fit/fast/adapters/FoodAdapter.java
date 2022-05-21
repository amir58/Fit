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
import com.fit.fast.databinding.FoodItemBinding;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder>{

    private Context context;
    private List<List<String>> foodData;

    public FoodAdapter(Context context, List<List<String>> foodData) {
        this.context = context;
        this.foodData = foodData;
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
        String[] grams = {"50", "100", "150"};
        holder.binding.foodDropdown.setAdapter(new ArrayAdapter(context, R.layout.sport_item, grams));

        final boolean[] isChecked = {false};
        holder.binding.foodRb.setOnClickListener( v-> {
            Log.i("abdo", "onBindViewHolder: "+ isChecked[0]);
            if (isChecked[0]){
                holder.binding.foodRb.setChecked(false);
                isChecked[0] = false;
            }else {
                holder.binding.foodRb.setChecked(true);
                isChecked[0] = true;
            }
        });
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
