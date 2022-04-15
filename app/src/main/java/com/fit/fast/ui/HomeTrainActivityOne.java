package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.fit.fast.databinding.ActivityHomeTrainOneBinding;

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