package com.fit.fast.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.R;
import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.MealImageItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MealItemsAdapter extends RecyclerView.Adapter<MealItemsAdapter.Holder> {

    ShowItemDataI showItemDataI;
    List<List<String>> foodData;

    public MealItemsAdapter(ShowItemDataI showItemDataI, List<List<String>> foodData) {
        this.showItemDataI = showItemDataI;
        this.foodData = foodData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(MealImageItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Picasso
                .get()
                .load(foodData.get(4).get(position))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.binding.mealImage);

        holder.binding.mealRb.setText(foodData.get(0).get(position));

        final boolean[] isChecked = {false};
        holder.binding.mealRb.setOnClickListener( v-> {
            Log.i("abdo", "onBindViewHolder: "+ isChecked[0]);
            if (isChecked[0]){
                holder.binding.mealRb.setChecked(false);
                isChecked[0] = false;
            }else {
                holder.binding.mealRb.setChecked(true);
                isChecked[0] = true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Here where we should send the item selected details through the {ShowItemDataI}
                 * callback interface to the parent to show it in the ui;
                 */
                showItemDataI.showItemData("details");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class Holder extends RecyclerView.ViewHolder {

        MealImageItemBinding binding;

        public Holder(@NonNull MealImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
