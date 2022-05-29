package com.fit.fast.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.callbacks.OpenTrainDetailsI;
import com.fit.fast.databinding.WorkoutsItemBinding;
import com.fit.fast.models.Workout;
import com.fit.fast.ui.DetailsTrainOneActivity;

import java.util.List;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.Holder>{

    private List<Workout> sport;
    public WorkoutsAdapter(List<Workout> sport) {
        this.sport = sport;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(WorkoutsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.workoutRv.setAdapter(new PopularWorkoutsAdapter(new OpenTrainDetailsI() {
            @Override
            public void openTrainDetails(List<Workout> data) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsTrainOneActivity.class);
                intent.putExtra("sport", sport.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        }, sport));
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
