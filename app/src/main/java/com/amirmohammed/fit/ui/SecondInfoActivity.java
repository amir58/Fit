package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

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
        RegisterSingleton.setData().setHours(Double.parseDouble(binding.activitySecondInfoWorkingHoursEt.getText().toString()));

        if (binding.activitySecondInfoLightlyActiveRb.isChecked()){
            RegisterSingleton.setData().setEffort("LA ");
        }
        else if (binding.activitySecondModeratelyActiveRb.isChecked()){
            RegisterSingleton.setData().setEffort("MA ");
        }
        else if (binding.activitySecondInfoWorkHighlyActiveRb.isChecked()){
            RegisterSingleton.setData().setEffort("HA ");
        }
        else{
            Toast.makeText(this, "Please select your effort", Toast.LENGTH_SHORT).show();
            return;
        }

        //////////

        if (binding.activitySecondInfoLoseFatRb.isChecked()){
            RegisterSingleton.setData().setGoalType("L ");
        }
        else if (binding.activitySecondGainWeightRb.isChecked()){
            RegisterSingleton.setData().setGoalType("G ");
        }
        else if (binding.activitySecondInfoWorkStableWeightRb.isChecked()){
            RegisterSingleton.setData().setGoalType("S ");
        }
        else{
            Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            return;
        }

        //////////

        if (binding.activitySecondInfo025kgRb.isChecked() ||
                binding.activitySecondInfoSecond025kgRb.isChecked()){
            RegisterSingleton.setData().setGoalWeight("1/4 ");
        }
        else if (binding.activitySecondInfo05kgRb.isChecked()||
                binding.activitySecondInfoSecond05kgRb.isChecked()){
            RegisterSingleton.setData().setGoalWeight("1/2 ");
        }
        else if (binding.activitySecondInfo1kgRb.isChecked() ||
                binding.activitySecondInfoSecond1kgRb.isChecked()){
            RegisterSingleton.setData().setGoalWeight("1 ");
        }
        else{
            Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("abdo", "next: "+ RegisterSingleton.registerRequest.toString());

        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
    }
}