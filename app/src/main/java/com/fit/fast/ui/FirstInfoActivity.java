package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.fit.fast.R;
import com.fit.fast.databinding.ActivityFirstInfoBinding;
import com.fit.fast.network.RegisterSingleton;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class FirstInfoActivity extends AppCompatActivity {

    private ActivityFirstInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////
        binding = ActivityFirstInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.activityFirstInfoSportMenu.setText("GYM EXERCISE");
        binding.activityFirstInfoSportMenu.setDropDownHeight(700);
        binding.activityFirstInfoSportMenu.setDropDownBackgroundResource(R.color.dropdown_background);
        String[] sports = {"GYM EXERCISE", "SPRINTERS", "MMA", "FOOTBALL", "BASKETBALL"};
        binding.activityFirstInfoSportMenu.setAdapter(new ArrayAdapter(this, R.layout.sport_item, sports));

        binding.activityFirstInfoExerciseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sport = binding.activityFirstInfoSportMenu.getText().toString();
                if (sport.equals("GYM EXERCISE")){
                    binding.activityFirstInfoExerciseMenu.setText("1");
                    binding.activityFirstInfoExerciseMenu.setDropDownHeight(700);
                    binding.activityFirstInfoExerciseMenu.setDropDownBackgroundResource(R.color.dropdown_background);
                    String[] days = {"1", "2", "3", "4", "5", "6"};
                    binding.activityFirstInfoExerciseMenu.setAdapter(new ArrayAdapter(view.getContext(), R.layout.sport_item, days));
                }else {
                    binding.activityFirstInfoExerciseMenu.setText("1");
                    binding.activityFirstInfoExerciseMenu.setDropDownHeight(700);
                    binding.activityFirstInfoExerciseMenu.setDropDownBackgroundResource(R.color.dropdown_background);
                    String[] days = {"1", "2"};
                    binding.activityFirstInfoExerciseMenu.setAdapter(new ArrayAdapter(view.getContext(), R.layout.sport_item, days));
                }
            }
        });
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
                String.valueOf(binding.activityFirstInfoExerciseMenu.getText()))
        );

        String sport;

        switch (binding.activityFirstInfoSportMenu.getText().toString()){
            case "SPRINTERS":
                sport = "SP";
                break;
            case "MMA":
                sport = "MMA";
                break;
            case "FOOTBALL":
                sport = "FB";
                break;
            case "BASKETBALL":
                sport = "BB";
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