package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.fit.fast.R;
import com.fit.fast.databinding.ActivityAnalysisInBodyBinding;
import com.fit.fast.network.SharedPref;
import com.fit.fast.responses.RegisterResponse;
import com.google.gson.Gson;

public class AnalysisInBodyActivity extends AppCompatActivity {

    ActivityAnalysisInBodyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnalysisInBodyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("registerResponse", MODE_PRIVATE);
        String dataJson = preferences.getString("userData", "");
        RegisterResponse data = new Gson().fromJson(dataJson, RegisterResponse.class);
        if (data == null || data.getInBody() == null) return;
        binding.setData(data);
    }


}