package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fit.fast.R;
import com.fit.fast.adapters.FoodAdapter;
import com.fit.fast.adapters.MealAdapter;
import com.fit.fast.callbacks.FoodData;
import com.fit.fast.callbacks.ShowItemDataI;
import com.fit.fast.databinding.ActivityCreateMyMealBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Food;
import com.fit.fast.responses.RegisterResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CreateMyMealActivity extends AppCompatActivity {
    private static final String TAG = "CreateMyMealActivity";
    ActivityCreateMyMealBinding binding;


    List<Food> foods = new ArrayList<>();

    String mealName = "MEAL 1";
    String optionNumber = "firstOption";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateMyMealBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getFoodData();

        @SuppressLint("SetTextI18n") FoodData foodData = (food0) -> {
            int calories = 0;
            int protein = 0;
            int carb = 0;
            int fats = 0;
            int fibers = 0;

            SharedPreferences preferences = getSharedPreferences("registerResponse", MODE_PRIVATE);
            Gson gson = new Gson();
            RegisterResponse response = gson.fromJson(preferences.getString("userData", ""), RegisterResponse.class);


            for (Food food : foods) {
                if (food.isSelected()) {
                    calories += Double.parseDouble(food.getCalories()) * food.getRealQuantity();
                    protein += Double.parseDouble(food.getProtein()) * food.getRealQuantity();
                    carb += Double.parseDouble(food.getCarb()) * food.getRealQuantity();
                    fats += Double.parseDouble(food.getFats()) * food.getRealQuantity();
                    fibers += Double.parseDouble(food.getFibers()) * food.getRealQuantity();
                }
            }

            if (calories > getPrecisedCalories(response)) {
//                Toast.makeText(this, "That is a big amount of CALORIES(" + calories + " cal)," +
//                        " you can't eat any more", Toast.LENGTH_LONG).show();

                binding.errorMessageTv.setVisibility(View.VISIBLE);
            } else {
                binding.errorMessageTv.setVisibility(View.GONE);

            }

            binding.caloriesLayout.setText(
                    calories + " calories" + "\n" +
                            protein + " protein" + "\n" +
                            carb + " carb" + "\n" +
                            fats + " fats" + "\n" +
                            fibers + " fibers" + "\n"
            );
        };

        binding.foodRV.setAdapter(new FoodAdapter(this, foods, foodData));

        clicks();
    }

    private double getPrecisedCalories(RegisterResponse response) {
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

    private void clicks() {
        binding.meal1Btn.setOnClickListener(view -> changeCurrentMeal("MEAL 1"));

        binding.meal2Btn.setOnClickListener(view -> changeCurrentMeal("MEAL 2"));

        binding.meal3Btn.setOnClickListener(view -> changeCurrentMeal("MEAL 3"));

        binding.firstChoice.setOnClickListener(view -> {
            changeCurrentOption("firstOption");
            binding.rbFirst.setChecked(true);
        });

        binding.secondChoice.setOnClickListener(view -> {
            changeCurrentOption("secondOption");
            binding.rbSecond.setChecked(true);
        });

        binding.thirdChoice.setOnClickListener(view -> {
            changeCurrentOption("thirdOption");
            binding.rbThird.setChecked(true);
        });

        binding.thirdChoice.setOnClickListener(view -> {
            changeCurrentOption("thirdOption");
            binding.rbThird.setChecked(true);
        });



    }

    private void changeCurrentMeal(String mealName) {
        this.mealName = mealName;
        binding.tvMealName.setText(mealName);
    }

    private void changeCurrentOption(String optionName) {
        this.optionNumber = optionName;
        binding.rbFirst.setChecked(false);
        binding.rbSecond.setChecked(false);
        binding.rbThird.setChecked(false);
    }

    private List<Food> getFoodData() {
        String fileName = "food_data.xls";
        foods = ExcelFileReader.readerClient(fileName, this).getFoodDataFromExcel();
        return foods;
    }

}

