package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityRegisterBinding;
import com.amirmohammed.fit.network.RegisterSingleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        List<String> days = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            days.add(String.valueOf(i));
        }
        binding.activityRegisterDayMenu.setDropDownHeight(400);
        binding.activityRegisterDayMenu.setDropDownBackgroundResource(R.color.dropdown_background);
        binding.activityRegisterDayMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.day_item, days));

        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        binding.activityRegisterMonthMenu.setDropDownHeight(400);
        binding.activityRegisterMonthMenu.setDropDownBackgroundResource(R.color.dropdown_background);
        binding.activityRegisterMonthMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.month_item, months));

        List<String> years = new ArrayList<>();
        for (int i = 1; i < 123; i++) {
            years.add(String.valueOf(i + 1900));
        }
        binding.activityRegisterYearMenu.setText("2022");
        binding.activityRegisterYearMenu.setDropDownHeight(400);
        binding.activityRegisterYearMenu.setDropDownBackgroundResource(R.color.dropdown_background);
        binding.activityRegisterYearMenu.setAdapter(new ArrayAdapter<>(this, R.layout.year_item, years));
    }

    public void back(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void next(View view) {
        Log.i("abdo", "next: "+ binding.activityRegisterNameEt.getText());
        RegisterSingleton.setData().setName(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityRegisterNameEt.getText()))
        );
        RegisterSingleton.setData().setUsername(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityRegisterUsernameEt.getText()))
        );
        RegisterSingleton.setData().setEmail(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityRegisterEmailEt.getText()))
        );
        RegisterSingleton.setData().setPassword(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityRegisterPasswordEt.getText()))
        );
        RegisterSingleton.setData().setConfirmPassword(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(binding.activityRegisterPasswordEt.getText()))
        );
        RegisterSingleton.setData().setAge(RequestBody.create(
                MediaType.parse("multipart/form-data"),
                String.valueOf(2022 - Integer.parseInt(binding.activityRegisterYearMenu.getText().toString())))
        );

        if (binding.activityRegisterFemaleRadioBtn.isChecked()){
            RegisterSingleton.setData().setGender(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "F")
            );
        }
        else if (binding.activityRegisterMaleRadioBtn.isChecked()){
            RegisterSingleton.setData().setGender(RequestBody.create(
                    MediaType.parse("multipart/form-data"), "M")
            );
        }
        else{
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("abdo", "next: "+ String.valueOf(2022 - Integer.parseInt(binding.activityRegisterYearMenu.getText().toString())));

        startActivity(new Intent(this, FirstInfoActivity.class));
        finish();
    }
}