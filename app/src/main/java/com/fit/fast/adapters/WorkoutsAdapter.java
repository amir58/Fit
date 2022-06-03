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
import com.fit.fast.ui.DetailsTrainOneActivity;

import java.util.List;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.Holder> {

    private String sport;
    private int days;

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
            public void openTrainDetails(List<Workout> data) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsTrainOneActivity.class);
                intent.putExtra("sport", data.get(finalPosition));
                holder.itemView.getContext().startActivity(intent);
            }
        }, getSportList(sport, ++position, holder.itemView.getContext()), days));
    }

    private List<Workout> getSportList(String sport, int position, Context context) {
        Log.i("abdo", "getSportList: ssss "+ sport);
        switch (sport.trim()) {
            case "SP":
                if (position == 1)
                    return ExcelFileReader.readerClient("s1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return ExcelFileReader.readerClient("s2.xls", context).getWorkoutDataFromExcel();
            case "MMA":
                if (position == 1)
                    return ExcelFileReader.readerClient("m1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return ExcelFileReader.readerClient("m2.xls", context).getWorkoutDataFromExcel();
            case "BB":
                if (position == 1)
                    return ExcelFileReader.readerClient("b1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return ExcelFileReader.readerClient("b2.xls", context).getWorkoutDataFromExcel();
            default:
                if (position == 1)
                    return ExcelFileReader.readerClient("g6_1.xls", context).getWorkoutDataFromExcel();
                else if (position == 2)
                    return ExcelFileReader.readerClient("g6_2.xls", context).getWorkoutDataFromExcel();
                else if (position == 3){
                    Log.i("abdo", "getSportList: pppp "+ position);
                    return ExcelFileReader.readerClient("g6_3.xls", context).getWorkoutDataFromExcel();
                }
                else if (position == 4){
                    Log.i("abdo", "getSportList: pppp "+ position);
                    return ExcelFileReader.readerClient("g6_4.xls", context).getWorkoutDataFromExcel();
                }
                else if (position == 5)
                    return ExcelFileReader.readerClient("g6_5.xls", context).getWorkoutDataFromExcel();
                else if (position == 6)
                    return ExcelFileReader.readerClient("g6_6.xls", context).getWorkoutDataFromExcel();
        }
        return ExcelFileReader.readerClient("s2.xls", context).getWorkoutDataFromExcel();
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
