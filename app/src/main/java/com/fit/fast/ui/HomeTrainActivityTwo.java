package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.fit.fast.databinding.ActivityHomeTrainTwoBinding;

public class HomeTrainActivityTwo extends AppCompatActivity {

    ActivityHomeTrainTwoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeTrainTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    public void back(View view) {
        startActivity(new Intent(this, HomeTrainActivityOne.class));
        finish();
    }

    public void navigateToLoading(View view) {

        binding.poweredbyImage.setVisibility(View.INVISIBLE);
        binding.backImage.setVisibility(View.INVISIBLE);
        binding.loadingTv.setVisibility(View.VISIBLE);
        binding.loadingCv.setVisibility(View.VISIBLE);
        binding.smallPoeredbyImage.setVisibility(View.VISIBLE);

        startActivity(new Intent(this, HomeTrainFourteenActivity.class));
        finish();
    }
}