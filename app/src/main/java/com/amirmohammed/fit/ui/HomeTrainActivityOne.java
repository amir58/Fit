package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.amirmohammed.fit.databinding.ActivityHomeTrainOneBinding;

public class HomeTrainActivityOne extends AppCompatActivity {

    ActivityHomeTrainOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeTrainOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    public void navigateToHomeTrainTwo(View view) {
        startActivity(new Intent(this, HomeTrainActivityTwo.class));
    }

    public void navigateToHomeTrainFour(View view) {
        startActivity(new Intent(this, HomeTrainFourteenActivity.class));
    }
}