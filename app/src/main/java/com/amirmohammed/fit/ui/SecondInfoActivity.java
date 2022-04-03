package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivitySecondInfoBinding;
import com.amirmohammed.fit.network.RegisterSingleton;

public class SecondInfoActivity extends AppCompatActivity {

    ActivitySecondInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {
        startActivity(new Intent(this, FirstInfoActivity.class));
        finish();
    }

    public void next(View view) {
        RegisterSingleton.setData().setHours(String.valueOf(binding.activitySecondInfoWorkingHoursEt.getText()));

        Log.i("abdo", "next: "+ RegisterSingleton.registerRequest.toString());

        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
    }
}