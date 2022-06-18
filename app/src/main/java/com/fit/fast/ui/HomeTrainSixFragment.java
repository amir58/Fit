package com.fit.fast.ui;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.fit.fast.adapters.FoodPlanAdapter;
import com.fit.fast.adapters.MealAdapter;
import com.fit.fast.databinding.FragmentHomeTrainSixBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Food;
import com.fit.fast.responses.RegisterResponse;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomeTrainSixFragment extends Fragment {
    private static final String TAG = "HomeTrainSixFragment";
    FragmentHomeTrainSixBinding binding;
    List<Food> foodData;

    public HomeTrainSixFragment(List<Food> foodData) {
        this.foodData = foodData;
    }

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

        binding.nutritionPlanBtn.setStrokeWidth(1);
        createMeals();

        setClicks(binding.nutritionPlanBtn, binding.meal1Btn, binding.meal2Btn, binding.meal3Btn, 0);

        setClicks(binding.meal1Btn, binding.nutritionPlanBtn, binding.meal2Btn, binding.meal3Btn, 0);

        setClicks(binding.meal2Btn, binding.nutritionPlanBtn, binding.meal1Btn, binding.meal3Btn, 1);

        setClicks(binding.meal3Btn, binding.nutritionPlanBtn, binding.meal1Btn, binding.meal2Btn, 2);

//        binding.mealRv.setAdapter(new MealAdapter(new ShowItemDataI() {
//            @Override
//            public void showItemData(String txt) {
//                /*
//                 * Here where we receive the item data from the adapter through {ShowItemDataI}
//                 * to show it in the ui;
//                 */
//                binding.mealDetailsLayout.setVisibility(View.VISIBLE);
//                binding.logo2Image.setVisibility(View.VISIBLE);
//                binding.searchLayout.setVisibility(View.VISIBLE);
//
//                binding.logoImage.setVisibility(View.INVISIBLE);
//                binding.caloriesCalculatorTv.setVisibility(View.INVISIBLE);
//                binding.caloriesLayout.setVisibility(View.INVISIBLE);
//                binding.foodRV.setVisibility(View.INVISIBLE);
//
//                Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show();
//            }
//        }, getFoodData()));
        binding.createMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(requireContext(), CreateMyMealActivity.class);
                startActivity(intent);

//                binding.playImage.setVisibility(View.INVISIBLE);
//                binding.searchLayout.setVisibility(View.INVISIBLE);
//                binding.logo2Image.setVisibility(View.INVISIBLE);
//                binding.mealDetailsLayout.setVisibility(View.INVISIBLE);
//
//                binding.foodRV.setVisibility(View.VISIBLE);
//                binding.caloriesCalculatorTv.setVisibility(View.VISIBLE);
//                binding.caloriesLayout.setVisibility(View.VISIBLE);
//                binding.logoImage.setVisibility(View.VISIBLE);
            }
        });
    }

    private void createMeals() {
        List<Food> selectedFoods = new ArrayList<>();

        double totalCalories = getPrecisedCalories();
        Collections.shuffle(foodData);

        double calculateCalories = 0;

        for (Food food : foodData) {
            if (calculateCalories + 150 >= totalCalories) break;
            Log.i("PLANS", "createMeals: " + calculateCalories);
            Log.i("PLANS", "createMeals: " + food.toString());
            selectedFoods.add(food);
            calculateCalories += Double.parseDouble(food.getCalories());
        }

        binding.firstMeal.setText(calculateCalories + " Calories");
        binding.mealRv.setAdapter(new FoodPlanAdapter(selectedFoods));
    }

    private double getPrecisedCalories() {
        SharedPreferences preferences = requireContext().getSharedPreferences("registerResponse", MODE_PRIVATE);
        Gson gson = new Gson();
        RegisterResponse response = gson.fromJson(preferences.getString("userData", ""), RegisterResponse.class);

        Log.i(TAG, "getPrecisedCalories: " + response.getCalculateBMR());
        Log.i(TAG, "getPrecisedCalories: " + response.getCalculateTDEE());
        switch (response.getGoalType().trim()) {
            case "L":
                switch (response.getGoalWeight().trim()) {
                    case "1":
                        return response.getCalculateTDEE() - 1100;
                    case "1/2":
                        return response.getCalculateTDEE() - 550;
                    case "1/4":
                        return response.getCalculateTDEE() - 275;
                }
            case "G":
                switch (response.getGoalWeight().trim()) {
                    case "1":
                        return response.getCalculateTDEE() + 1100;
                    case "1/2":
                        return response.getCalculateTDEE() + 550;
                    case "1/4":
                        return response.getCalculateTDEE() + 275;
                }
            default:
                return response.getCalculateTDEE();
        }
    }

    private void setClicks(MaterialButton pressedBtn, MaterialButton unpressedBtn1,
                           MaterialButton unpressedBtn2, MaterialButton unpressedBtn3, int position) {


        pressedBtn.setOnClickListener(view -> {
            createMeals();
            pressedBtn.setStrokeWidth(1);
            unpressedBtn1.setStrokeWidth(0);
            unpressedBtn2.setStrokeWidth(0);
            unpressedBtn3.setStrokeWidth(0);
        });
    }
}