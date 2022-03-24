package com.amirmohammed.fit.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.adapters.MealAdapter;
import com.amirmohammed.fit.adapters.WorkoutsAdapter;
import com.amirmohammed.fit.callbacks.ShowItemDataI;
import com.amirmohammed.fit.databinding.FragmentHomeTrainSixBinding;
import com.google.android.material.button.MaterialButton;

public class HomeTrainSixFragment extends Fragment {

    FragmentHomeTrainSixBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeTrainSixBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setClicks(binding.nutritionPlanBtn, binding.meal1Btn, binding.meal2Btn, binding.meal3Btn);

        setClicks(binding.meal1Btn, binding.nutritionPlanBtn, binding.meal2Btn, binding.meal3Btn);

        setClicks(binding.meal2Btn, binding.nutritionPlanBtn, binding.meal1Btn, binding.meal3Btn);

        setClicks(binding.meal3Btn, binding.nutritionPlanBtn, binding.meal1Btn, binding.meal2Btn);

        binding.mealRv.setAdapter(new MealAdapter(new ShowItemDataI() {
            @Override
            public void showItemData(String txt) {
                /**
                 * Here where we receive the item data from the adapter through {ShowItemDataI}
                 * to show it in the ui;
                 */
                binding.mealDetailsLayout.setVisibility(View.VISIBLE);
                Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show();
            }
        }));

        binding.createMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.playImage.setVisibility(View.INVISIBLE);
                binding.searchLayout.setVisibility(View.INVISIBLE);

                binding.radioBtnsLayout.setVisibility(View.VISIBLE);
                binding.caloriesCalculatorTv.setVisibility(View.VISIBLE);
                binding.caloriesLayout.setVisibility(View.VISIBLE);
            }
        });
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