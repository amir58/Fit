package com.fit.fast.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.R;
import com.fit.fast.callbacks.OpenTrainDetailsI;
import com.fit.fast.databinding.PopularWorkoutItemBinding;
import com.fit.fast.models.Workout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularWorkoutsAdapter extends RecyclerView.Adapter<PopularWorkoutsAdapter.Holder> {

    OpenTrainDetailsI openTrainDetailsI;
    private List<Workout> sport;

    public PopularWorkoutsAdapter(OpenTrainDetailsI openTrainDetailsI, List<Workout> sport) {
        this.openTrainDetailsI = openTrainDetailsI;
        this.sport = sport;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(PopularWorkoutItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        String photo = sport.get(position).getPhoto().isEmpty() ?
                "\thttps://cdn.shopify.com/s/files/1/0044/7266/8275/articles/Squat_f6a8765f-d8b5-" +
                        "46e3-8aff-c327ec994283_1000x.jpg?v=1647352001\n" :
                sport.get(position).getPhoto();

        Picasso
                .get()
                .load(photo)
                .placeholder(R.drawable.six_packs_image)
                .into(holder.binding.workoutImage);

        holder.binding.workoutTv.setText(sport.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            openTrainDetailsI.openTrainDetails(sport);
        });
    }

    @Override
    public int getItemCount() {
        return sport.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        PopularWorkoutItemBinding binding;

        public Holder(@NonNull PopularWorkoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
