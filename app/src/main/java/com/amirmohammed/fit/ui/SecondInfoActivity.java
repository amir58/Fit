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
        RegisterSingleton.setData().setHours(String.valueOf(binding.activitySecondInfoWorkingHoursEt.getText()));

        if (binding.activitySecondInfoLightlyActiveRb.isChecked()){
            RegisterSingleton.setData().setEffort("Lightly Active");
        }
        else if (binding.activitySecondModeratelyActiveRb.isChecked()){
            RegisterSingleton.setData().setEffort("Moderately Active");
        }
        else if (binding.activitySecondInfoWorkHighlyActiveRb.isChecked()){
            RegisterSingleton.setData().setEffort("Highly Active");
        }
        else{
            Toast.makeText(this, "Please select your effort", Toast.LENGTH_SHORT).show();
        }

        if (binding.activitySecondInfoLoseFatRb.isChecked()){
            RegisterSingleton.setData().setGoalType("Lose Fat");

            if (binding.activitySecondInfo025kgRb.isChecked()){
                RegisterSingleton.setData().setGoalType("1/4 Kgs");
            }
            else if (binding.activitySecondInfo05kgRb.isChecked()){
                RegisterSingleton.setData().setGoalType("1/2 Kgs");
            }
            else if (binding.activitySecondInfo1kgRb.isChecked()){
                RegisterSingleton.setData().setGoalType("1 Kgs");
            }
            else{
                Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            }
        }
        else if (binding.activitySecondGainWeightRb.isChecked()){
            RegisterSingleton.setData().setGoalType("Gain Weight");

            if (binding.activitySecondInfo025kgRb.isChecked()){
                RegisterSingleton.setData().setGoalType("1/4 Kgs");
            }
            else if (binding.activitySecondInfo05kgRb.isChecked()){
                RegisterSingleton.setData().setGoalType("1/2 Kgs");
            }
            else if (binding.activitySecondInfo1kgRb.isChecked()){
                RegisterSingleton.setData().setGoalType("1 Kgs");
            }
            else{
                Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            }
        }
        else if (binding.activitySecondInfoWorkStableWeightRb.isChecked()){
            RegisterSingleton.setData().setGoalType("Stable Weight");
        }
        else{
            Toast.makeText(this, "Please select your goal type", Toast.LENGTH_SHORT).show();
            return;
        }



        Log.i("abdo", "next: "+ RegisterSingleton.registerRequest.toString());

        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
    }
}