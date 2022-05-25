package com.fit.fast.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.MealItemBinding;
import com.fit.fast.models.Food;

import java.util.List;
import java.util.Objects;


public class MealAdapter extends RecyclerView.Adapter<MealAdapter.Holder> {

    ShowItemDataI showItemDataI;
    List<Food> foodData;

    public MealAdapter(ShowItemDataI showItemDataI, List<Food> foodData) {
        this.showItemDataI = showItemDataI;
        this.foodData = foodData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(MealItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.mealRv.setAdapter(new MealItemsAdapter(showItemDataI, foodData));

//        binding.mealRv.getLayoutManager().smoothScrollToPosition(binding.mealRv, new RecyclerView.State(), position);

//        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(holder.itemView.getContext()) {
//            @Override protected int getVerticalSnapPreference() {
//                return LinearSmoothScroller.SNAP_TO_ANY;
//            }
//        };
//        smoothScroller.setTargetPosition(position);
//        startSmoothScroll(smoothScroller);


        position += 1;
        holder.binding.headTv.setText("MEAL" + position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        MealItemBinding binding;

        public Holder(@NonNull MealItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
