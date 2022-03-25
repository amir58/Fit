package com.amirmohammed.fit.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.adapters.PopularWorkoutsAdapter;
import com.amirmohammed.fit.callbacks.OpenTrainDetailsI;
import com.amirmohammed.fit.databinding.FragmentPopularWorkoutBinding;

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

        binding.popularWorkoutRv.setAdapter(new PopularWorkoutsAdapter(new OpenTrainDetailsI() {
            @Override
            public void openTrainDetails(String data) {
                startActivity(new Intent(requireContext(), DetailsTrainOneActivity.class));
            }
        }));
    }
}