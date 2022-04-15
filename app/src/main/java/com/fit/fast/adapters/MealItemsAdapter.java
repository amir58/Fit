package com.fit.fast.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.MealImageItemBinding;

public class MealItemsAdapter extends RecyclerView.Adapter<MealItemsAdapter.Holder> {

    ShowItemDataI showItemDataI;

    public MealItemsAdapter(ShowItemDataI showItemDataI) {
        this.showItemDataI = showItemDataI;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(MealImageItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

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

    public  class Holder extends RecyclerView.ViewHolder {

        MealImageItemBinding binding;

        public Holder(@NonNull MealImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
