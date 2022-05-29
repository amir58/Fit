package com.fit.fast.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.fit.fast.adapters.PopularWorkoutsAdapter;
import com.fit.fast.adapters.WorkoutsAdapter;
import com.fit.fast.callbacks.OpenTrainDetailsI;
import com.fit.fast.databinding.FragmentPopularWorkoutBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Workout;

import java.util.ArrayList;
import java.util.List;

public class PopularWorkoutFragment extends Fragment {

    FragmentPopularWorkoutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPopularWorkoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.popularWorkoutRv.setAdapter(new WorkoutsAdapter(switchOnSport("SP")));
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

        return new ArrayList<>();
    }

    private List<Workout> getSportWithSpecificFile(String fileName) {
        return ExcelFileReader.readerClient(fileName, requireActivity()).getWorkoutDataFromExcel();
    }
}