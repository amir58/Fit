package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityFirstInfoBinding;
import com.amirmohammed.fit.network.RegisterSingleton;

public class FirstInfoActivity extends AppCompatActivity {

    private ActivityFirstInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    public void next(View view) {
        RegisterSingleton.setData().setWeight(String.valueOf(binding.activityFirstInfoWeightEt.getText()));
        RegisterSingleton.setData().setHeight(String.valueOf(binding.activityFirstInfoHeightEt.getText()));
        startActivity(new Intent(this, SecondInfoActivity.class));
    }
}