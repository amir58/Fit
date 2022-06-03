package com.fit.fast.ui;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.fit.fast.adapters.DaysAdapter;
import com.fit.fast.adapters.WorkoutsAdapter;
import com.fit.fast.callbacks.DaysCallback;
import com.fit.fast.databinding.FragmentHomeTrainFiveBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Workout;
import com.fit.fast.network.RegisterSingleton;
import com.fit.fast.responses.RegisterResponse;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


//        binding.workoutBtn.setStrokeWidth(1);
//
//        setClicks(binding.workoutBtn, binding.legDayBtn, binding.pullDyBtn, binding.pushDayBtn);
//
//        setClicks(binding.pushDayBtn, binding.legDayBtn, binding.pullDyBtn, binding.workoutBtn);
//
//        setClicks(binding.pullDyBtn, binding.legDayBtn, binding.workoutBtn, binding.pushDayBtn);
//
//        setClicks(binding.legDayBtn, binding.workoutBtn, binding.pullDyBtn, binding.pushDayBtn);
        
//        String sport = String.valueOf(ExcelFileReader.readerClient(
//                "1_1.xls", requireActivity()).getWorkoutDataFromExcel()
//        );

        SharedPreferences preferences = getActivity().getSharedPreferences("registerResponse", MODE_PRIVATE);

        Gson gson = new Gson();
        RegisterResponse response =
                gson.fromJson(preferences.getString("userData", ""), RegisterResponse.class);

        int days = response.getTrain().intValue();

        binding.workoutRv.setAdapter(new WorkoutsAdapter(switchOnSport("SP")));


        binding.daysBtnRV.setAdapter(new DaysAdapter(requireActivity(), days, new DaysCallback() {
            @Override
            public void days(int days) {
                Objects.requireNonNull(binding.daysBtnRV.getLayoutManager()).smoothScrollToPosition(binding.daysBtnRV, new RecyclerView.State(), days);

                RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(requireContext()) {
                    @Override
                    protected int getVerticalSnapPreference() {
                        return LinearSmoothScroller.SNAP_TO_START;
                    }
                };

                smoothScroller.setTargetPosition(days);
                Objects.requireNonNull(binding.daysBtnRV.getLayoutManager()).startSmoothScroll(smoothScroller);
            }
        }));
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