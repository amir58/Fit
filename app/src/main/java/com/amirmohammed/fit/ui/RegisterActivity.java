package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityRegisterBinding;

import java.util.ArrayList;
import java.util.List;

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
        binding.activityRegisterDayMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.day_item, days));

        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        binding.activityRegisterMonthMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.month_item, months));

        List<String> years = new ArrayList<>();
        for (int i = 1; i < 123; i++) {
            years.add(String.valueOf(i + 1900));
        }
        binding.activityRegisterYearMenu.setText("2022");
        binding.activityRegisterYearMenu.setAdapter(new ArrayAdapter<>(this, R.layout.year_item, years));
    }

    public void back(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void next(View view) {
        startActivity(new Intent(this, FirstInfoActivity.class));
        finish();
    }
}