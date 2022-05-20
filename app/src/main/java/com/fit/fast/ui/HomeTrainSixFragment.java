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
import android.widget.Toast;

import com.fit.fast.adapters.MealAdapter;
import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.FragmentHomeTrainSixBinding;
import com.fit.fast.models.ExcelFileReader;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

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

        requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        extractFoodDataFromExcelFile();

        binding.nutritionPlanBtn.setStrokeWidth(1);

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
                binding.logo2Image.setVisibility(View.VISIBLE);
                binding.searchLayout.setVisibility(View.VISIBLE);

                binding.logoImage.setVisibility(View.INVISIBLE);
                binding.caloriesCalculatorTv.setVisibility(View.INVISIBLE);
                binding.caloriesLayout.setVisibility(View.INVISIBLE);
                binding.radioBtnsLayout.setVisibility(View.INVISIBLE);

                Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show();
            }
        }));

        binding.createMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.playImage.setVisibility(View.INVISIBLE);
                binding.searchLayout.setVisibility(View.INVISIBLE);
                binding.logo2Image.setVisibility(View.INVISIBLE);
                binding.mealDetailsLayout.setVisibility(View.INVISIBLE);

                binding.radioBtnsLayout.setVisibility(View.VISIBLE);
                binding.caloriesCalculatorTv.setVisibility(View.VISIBLE);
                binding.caloriesLayout.setVisibility(View.VISIBLE);
                binding.logoImage.setVisibility(View.VISIBLE);
            }
        });
    }

    private void extractFoodDataFromExcelFile() {
        List<String> foodName;
        List<String> foodQuantity;
        List<String> foodCal;
        List<String> foodProtein;
        List<String> foodCarbs;
        List<String> foodFats;
        List<String> foodFibers;

        foodName = getFoodData(0);
        foodQuantity = getFoodData(1);
        foodCal = getFoodData(2);
        foodProtein = getFoodData(3);
        foodCarbs = getFoodData(4);
        foodFats = getFoodData(5);
        foodFibers = getFoodData(6);

        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodName + "\n");
        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodQuantity + "\n");
        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodCal + "\n");
        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodProtein + "\n");
        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodCarbs + "\n");
        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodFats + "\n");
        Log.i("abdo", "extractFoodDataFromExcelFile: lists " + foodFibers + "\n");
    }


    private List<String> getFoodData(int index) {
        String fileName = "food_data.xls";
        return ExcelFileReader.readerClient(fileName, requireContext()).getFoodDataFromExcel().get(index);
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