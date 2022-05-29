package com.fit.fast.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.fit.fast.adapters.WorkoutsAdapter;
import com.fit.fast.databinding.FragmentHomeTrainFiveBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Workout;
import com.fit.fast.network.RegisterSingleton;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class HomeTrainFiveFragment extends Fragment {

    FragmentHomeTrainFiveBinding binding;

    private List<Workout> workouts;
    private Workout workoutSport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeTrainFiveBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.workoutRv.setAdapter(new WorkoutsAdapter(switchOnSport("SP")));

        binding.workoutBtn.setStrokeWidth(1);

        setClicks(binding.workoutBtn, binding.legDayBtn, binding.pullDyBtn, binding.pushDayBtn);

        setClicks(binding.pushDayBtn, binding.legDayBtn, binding.pullDyBtn, binding.workoutBtn);

        setClicks(binding.pullDyBtn, binding.legDayBtn, binding.workoutBtn, binding.pushDayBtn);

        setClicks(binding.legDayBtn, binding.workoutBtn, binding.pullDyBtn, binding.pushDayBtn);
        
//        String sport = String.valueOf(ExcelFileReader.readerClient(
//                "1_1.xls", requireActivity()).getWorkoutDataFromExcel()
//        );

    }

    private List<Workout> switchOnSport(String sport) {
        switch (sport) {
            case "SP":
                return getSportWithSpecificFile("s1.xls");
            case "MMA":
                sport = "MMA";
                break;
            case "FB":
                sport = "FB";
                break;
            case "BB":
                sport = "BB";
                break;
            default:
                sport = "GE ";
                break;
        }
        
        return workouts = new ArrayList<>();
    }

    private void setClicks(MaterialButton pressedBtn, MaterialButton unpressedBtn1,
                           MaterialButton unpressedBtn2, MaterialButton unpressedBtn3) {

        pressedBtn.setOnClickListener(view -> {
            pressedBtn.setStrokeWidth(1);
            unpressedBtn1.setStrokeWidth(0);
            unpressedBtn2.setStrokeWidth(0);
            unpressedBtn3.setStrokeWidth(0);
        });
    }

    private List<Workout> getSportWithSpecificFile(String fileName) {
        return ExcelFileReader.readerClient(fileName, requireActivity()).getWorkoutDataFromExcel();
    }
}