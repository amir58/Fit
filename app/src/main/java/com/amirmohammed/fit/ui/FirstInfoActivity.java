package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityFirstInfoBinding;
import com.amirmohammed.fit.network.RegisterSingleton;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class FirstInfoActivity extends AppCompatActivity {

    private ActivityFirstInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.activityFirstInfoSportMenu.setText("GYM EXERCISE");
        binding.activityFirstInfoSportMenu.setDropDownHeight(700);
        binding.activityFirstInfoSportMenu.setDropDownBackgroundResource(R.color.dropdown_background);
        String[] sports = {"GYM EXERCISE", "CROSSFIT", "SWIMMING", "FOOTBALL", "HANDBALL"};
        binding.activityFirstInfoSportMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.sport_item, sports));

    }

    public void back(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    public void next(View view) {
        RegisterSingleton.setData().setWeight(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityFirstInfoWeightEt.getText()))
        );
        RegisterSingleton.setData().setHeight(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityFirstInfoHeightEt.getText()))
        );
        RegisterSingleton.setData().setTrain(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityFirstInfoExerciseEt.getText()))
        );

        String sport;

        switch (binding.activityFirstInfoSportMenu.getText().toString()){
            case "CROSSFIT":
                sport = "CR";
                break;
            case "SWIMMING":
                sport = "SW";
                break;
            case "FOOTBALL":
                sport = "FB";
                break;
            case "HANDBALL":
                sport = "HB";
                break;
            default:
                sport = "GE ";
                break;
        }

        RegisterSingleton.setData().setSport(
                RequestBody.create(MediaType.parse("multipart/form-data"), sport)
        );

        startActivity(new Intent(this, SecondInfoActivity.class));
    }
}