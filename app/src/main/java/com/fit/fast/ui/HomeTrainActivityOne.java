package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.fit.fast.databinding.ActivityHomeTrainOneBinding;
import com.fit.fast.responses.RegisterResponse;
import com.google.gson.Gson;

public class HomeTrainActivityOne extends AppCompatActivity {

    ActivityHomeTrainOneBinding binding;
    private static final String TAG = "HomeTrainActivityOne";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeTrainOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.activityHomeTrainOneCaloriesTv.setText(getPrecisedCalories() + "CAL");
        binding.fatTv.setText(getFat() + "g");
        binding.proteinTv.setText(getProtein() + "g");
        binding.carbohydratesTv.setText(getCarbs() + "g");

    }

    private int getFat() {
        return (int) (getPrecisedCalories() * 0.25 / 9);
    }

    private int getCarbs() {
        return getPrecisedCalories() - (getProtein() * 4) - (getFat() * 9) / 4;
    }

    private int getProtein() {
        SharedPreferences preferences = this.getSharedPreferences("registerResponse", MODE_PRIVATE);
        Gson gson = new Gson();
        RegisterResponse response = gson.fromJson(preferences.getString("userData", ""), RegisterResponse.class);

        if (response.getWeight() >= 95){
            return (int) (response.getWeight() * 2.2);
        }else {
            return (int) (response.getWeight() * 1.8);
        }
    }

    private int getPrecisedCalories() {
        SharedPreferences preferences = this.getSharedPreferences("registerResponse", MODE_PRIVATE);
        Gson gson = new Gson();
        RegisterResponse response = gson.fromJson(preferences.getString("userData", ""), RegisterResponse.class);


        Log.i(TAG, "getPrecisedCalories: " + response.getCalculateBMR());
        Log.i(TAG, "getPrecisedCalories: " + response.getCalculateTDEE());
        switch (response.getGoalType().trim()) {
            case "L":
                switch (response.getGoalWeight().trim()) {
                    case "1":
                        return (int) (response.getCalculateTDEE() - 1100);
                    case "1/2":
                        return (int) (response.getCalculateTDEE() - 550);
                    case "1/4":
                        return (int) (response.getCalculateTDEE() - 275);
                }
            case "G":
                switch (response.getGoalWeight().trim()) {
                    case "1":
                        return (int) (response.getCalculateTDEE() + 1100);
                    case "1/2":
                        return (int) (response.getCalculateTDEE() + 550);
                    case "1/4":
                        return (int) (response.getCalculateTDEE() + 275);
                }
            default:
                return (int) (response.getCalculateTDEE() + 0);
        }
    }

    public void navigateToHomeTrainBottomNavigationActivity(View view) {
        startActivity(new Intent(this, HomeTrainBottomNavigationActivity.class));
        finish();
    }

    public void navigateToHomeTrainFour(View view) {
        startActivity(new Intent(this, HomeTrainActivityTwo.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}