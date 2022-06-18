package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.databinding.ActivitySecondInfoBinding;
import com.fit.fast.network.RegisterSingleton;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SecondInfoActivity extends AppCompatActivity {

    ActivitySecondInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.activitySecondGainWeightRb.setOnClickListener(view -> {
            binding.rgGainWeight.setVisibility(View.VISIBLE);
            binding.rgLoseFat.setVisibility(View.GONE);
        });

        binding.activitySecondInfoLoseFatRb.setOnClickListener(view -> {
            binding.rgGainWeight.setVisibility(View.GONE);
            binding.rgLoseFat.setVisibility(View.VISIBLE);
        });

        binding.activitySecondInfoWorkStableWeightRb.setOnClickListener(view -> {
            binding.rgGainWeight.setVisibility(View.GONE);
            binding.rgLoseFat.setVisibility(View.GONE);
        });


    }

    public void back(View view) {
        startActivity(new Intent(this, FirstInfoActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, FirstInfoActivity.class));
        finish();
    }

    public void next(View view) {
        RegisterSingleton.setData().setHours(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                binding.activitySecondInfoWorkingHoursEt.getText().toString()));

        if (binding.activitySecondInfoLightlyActiveRb.isChecked()) {
            RegisterSingleton.setData().setEffort(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "LA ")
            );
        } else if (binding.activitySecondModeratelyActiveRb.isChecked()) {
            RegisterSingleton.setData().setEffort(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "MA")
            );
        } else if (binding.activitySecondInfoWorkHighlyActiveRb.isChecked()) {
            RegisterSingleton.setData().setEffort(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "HA")
            );
        } else {
            Toast.makeText(this, "Please select your effort", Toast.LENGTH_SHORT).show();
            return;
        }

        //////////
        boolean isStablility;

        if (binding.activitySecondInfoLoseFatRb.isChecked()) {
            RegisterSingleton.setData().setGoalType(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "L ")
            );
            isStablility = true;

        } else if (binding.activitySecondGainWeightRb.isChecked()) {
            RegisterSingleton.setData().setGoalType(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "G")
            );
            isStablility = true;

        } else if (binding.activitySecondInfoWorkStableWeightRb.isChecked()) {
            RegisterSingleton.setData().setGoalType(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "S")
            );
            isStablility = false;
        } else {
            Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            return;
        }

        //////////

        if ((binding.activitySecondInfo025kgRb.isChecked() ||
                binding.activitySecondInfoSecond025kgRb.isChecked()) || !isStablility) {
            RegisterSingleton.setData().setGoalWeight(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "1 ")
            );
        } else if ((binding.activitySecondInfo05kgRb.isChecked() ||
                binding.activitySecondInfoSecond05kgRb.isChecked()) || !isStablility) {
            RegisterSingleton.setData().setGoalWeight(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "2")
            );
        } else if ((binding.activitySecondInfo1kgRb.isChecked() ||
                binding.activitySecondInfoSecond1kgRb.isChecked()) || !isStablility) {
            RegisterSingleton.setData().setGoalWeight(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "3")
            );
        } else {
            Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("abdo", "next: " + RegisterSingleton.registerRequestBody.toString());

        if (binding.activitySecondInfoWorkingHoursEt.getText().toString().equals("")) {
            Toast.makeText(this, "Fields can not be empty", Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
    }
}