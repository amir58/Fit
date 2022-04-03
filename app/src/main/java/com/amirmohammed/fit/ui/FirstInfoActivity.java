package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

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

        String[] sports = {"GYM EXERCISE", "CROSSFIT", "SWIMMING", "FOOTBALL", "HANDBALL"};
        binding.activityFirstInfoSportMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.month_item, sports));

    }

    public void back(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    public void next(View view) {
        RegisterSingleton.setData().setWeight(String.valueOf(binding.activityFirstInfoWeightEt.getText()));
        RegisterSingleton.setData().setHeight(String.valueOf(binding.activityFirstInfoHeightEt.getText()));
        RegisterSingleton.setData().setSport(binding.activityFirstInfoSportMenu.getText().toString());
        RegisterSingleton.setData().setTrain(binding.activityFirstInfoExerciseEt.getText().toString());
        startActivity(new Intent(this, SecondInfoActivity.class));
    }
}