package com.fit.fast.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.callbacks.OpenTrainDetailsI;
import com.fit.fast.databinding.WorkoutsItemBinding;
import com.fit.fast.ui.DetailsTrainOneActivity;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.Holder>{

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(WorkoutsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.workoutRv.setAdapter(new PopularWorkoutsAdapter(new OpenTrainDetailsI() {
            @Override
            public void openTrainDetails(String data) {
                holder.itemView.getContext().startActivity(
                        new Intent(holder.itemView.getContext(), DetailsTrainOneActivity.class));
            }
        }));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class Holder extends RecyclerView.ViewHolder {
        WorkoutsItemBinding binding;
        public Holder(@NonNull WorkoutsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
