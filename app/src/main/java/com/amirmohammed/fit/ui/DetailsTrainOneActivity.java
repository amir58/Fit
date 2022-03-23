package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityDetailsTrainOneBinding;

public class DetailsTrainOneActivity extends AppCompatActivity {

    private ActivityDetailsTrainOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsTrainOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void next(View view) {
        startActivity(new Intent(this, DetailsTrainTwoActivity.class));
    }

    public void oneTimeClick(View view) {
        binding.oneClickImage.setVisibility(View.INVISIBLE);
        binding.oneClickBtn.setVisibility(View.VISIBLE);
    }
}