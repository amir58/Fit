package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.List;

public class CreateMyMealActivity extends AppCompatActivity {

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

            for (Food food : foods) {
                if (food.isSelected()) {
                    calories += Double.parseDouble(food.getCalories()) * food.getRealQuantity();
                    protein += Double.parseDouble(food.getProtein()) * food.getRealQuantity();
                    carb += Double.parseDouble(food.getCarb()) * food.getRealQuantity();
                    fats += Double.parseDouble(food.getFats()) * food.getRealQuantity();
                    fibers += Double.parseDouble(food.getFibers()) * food.getRealQuantity();
                }
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

