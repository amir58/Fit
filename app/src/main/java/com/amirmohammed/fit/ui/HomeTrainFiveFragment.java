package com.amirmohammed.fit.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.adapters.WorkoutsAdapter;
import com.amirmohammed.fit.databinding.FragmentHomeTrainFiveBinding;
import com.google.android.material.button.MaterialButton;

public class HomeTrainFiveFragment extends Fragment {

    FragmentHomeTrainFiveBinding binding;

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

        binding.workoutBtn.setStrokeWidth(1);

        setClicks(binding.workoutBtn, binding.legDayBtn, binding.pullDyBtn, binding.pushDayBtn);

        setClicks(binding.pushDayBtn, binding.legDayBtn, binding.pullDyBtn, binding.workoutBtn);

        setClicks(binding.pullDyBtn, binding.legDayBtn, binding.workoutBtn, binding.pushDayBtn);

        setClicks(binding.legDayBtn, binding.workoutBtn, binding.pullDyBtn, binding.pushDayBtn);

        binding.workoutRv.setAdapter(new WorkoutsAdapter());

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
}