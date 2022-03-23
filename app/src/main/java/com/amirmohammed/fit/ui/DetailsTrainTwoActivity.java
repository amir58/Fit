package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityDetailsTrainTwoBinding;

public class DetailsTrainTwoActivity extends AppCompatActivity {

    private ActivityDetailsTrainTwoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsTrainTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void navigateToDetailsOneActivity(View view) {
        startActivity(new Intent(this, DetailsTrainOneActivity.class));
    }

    public void oneTimeClick(View view) {
        binding.oneClickImage.setVisibility(View.INVISIBLE);
        binding.oneClickBtn.setVisibility(View.VISIBLE);
    }

    public void cancel(View view) {
    }
}