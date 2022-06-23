package com.fit.fast.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit.fast.callbacks.OpenTrainDetailsI;
import com.fit.fast.databinding.WorkoutsItemBinding;
import com.fit.fast.models.Days;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Workout;
import com.fit.fast.ui.DetailsTrainTwoActivity;

import java.util.List;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.Holder> {
    private static final String TAG = "WorkoutsAdapter";
    private final String sport;
    private final int days;

    public WorkoutsAdapter(String sport, int days) {
        this.sport = sport;
        this.days = days;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(WorkoutsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {

        int day = position + 1;
        holder.binding.headTv.setText("Day " + day);

        int finalPosition = position;
        holder.binding.workoutRv.setAdapter(new PopularWorkoutsAdapter(new OpenTrainDetailsI() {
            @Override
            public void openTrainDetails(Workout data) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsTrainTwoActivity.class);
                intent.putExtra("sport", data);
                holder.itemView.getContext().startActivity(intent);
            }
        }, getSportList(sport, ++position, holder.itemView.getContext()), days));
//        notifyItemChanged(position);
    }

    private List<Workout> getSportList(String sport, int position, Context context) {
        Log.i(TAG, "getSportList: ssss " + sport);
        Log.i(TAG, "getSportList: ssss " + position);
        switch (sport.trim()) {
            case "SP":
                if (position == 1)
                    return new ExcelFileReader("s1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return new ExcelFileReader("s2.xls", context).getWorkoutDataFromExcel();
            case "MMA":
                if (position == 1)
                    return new ExcelFileReader("m1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return new ExcelFileReader("m2.xls", context).getWorkoutDataFromExcel();
            case "BB":
                if (position == 1)
                    return new ExcelFileReader("b1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return new ExcelFileReader("b2.xls", context).getWorkoutDataFromExcel();
            case "FB":
                if (position == 1)
                    return new ExcelFileReader("b1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return new ExcelFileReader("b2.xls", context).getWorkoutDataFromExcel();

            case  "GE":
                if (position == 1) {
                    return new ExcelFileReader("g6_1.xls", context).getWorkoutDataFromExcel();
                } else if (position == 2) {
                    return new ExcelFileReader("g6_2.xls", context).getWorkoutDataFromExcel();
                } else if (position == 3) {
                    return new ExcelFileReader("g6_3.xls", context).getWorkoutDataFromExcel();
                } else if (position == 4) {
                    return new ExcelFileReader("g6_4.xls", context).getWorkoutDataFromExcel();
                } else if (position == 5) {
                    return new ExcelFileReader("g6_5.xls", context).getWorkoutDataFromExcel();
                } else if (position == 6) {
                    return new ExcelFileReader("g6_6.xls", context).getWorkoutDataFromExcel();
                }
        }
        return new ExcelFileReader("s2.xls", context).getWorkoutDataFromExcel();
    }

    @Override
    public int getItemCount() {
        return days;
    }

    class Holder extends RecyclerView.ViewHolder {
        WorkoutsItemBinding binding;

        public Holder(@NonNull WorkoutsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
