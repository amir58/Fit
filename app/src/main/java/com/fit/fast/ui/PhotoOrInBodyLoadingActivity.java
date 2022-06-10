package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.fit.fast.R;
import com.fit.fast.responses.RegisterResponse;
import com.google.gson.Gson;

public class PhotoOrInBodyLoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_or_in_body_loading);

        SharedPreferences preferences = getSharedPreferences("registerResponse", MODE_PRIVATE);

        Gson gson = new Gson();
        RegisterResponse response =
                gson.fromJson(preferences.getString("userData", ""), RegisterResponse.class);

        Log.i("abdo", "onCreate: rererere "+ response.toString());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        ProgressBar progressBar = findViewById(R.id.mprogress_horizontal);

        // Get the Drawable custom_progressbar
        @SuppressLint("UseCompatLoadingForDrawables") Drawable draw = getResources().getDrawable(R.drawable.custom_progress_bar);

        // set the drawable as progress drawable
        progressBar.setProgressDrawable(draw);


        CountDownTimer timer = new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long l) {
                progressBar.setProgress((int) l);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(PhotoOrInBodyLoadingActivity.this,
                        HomeTrainActivityOne.class));
                finish();
            }
        };
        timer.start();
    }
}