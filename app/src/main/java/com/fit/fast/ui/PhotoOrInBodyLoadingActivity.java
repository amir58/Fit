package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.fit.fast.R;

public class PhotoOrInBodyLoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_or_in_body_loading);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        ProgressBar progressBar = findViewById(R.id.mprogress_horizontal);

        // Get the Drawable custom_progressbar
        @SuppressLint("UseCompatLoadingForDrawables") Drawable draw = getResources().getDrawable(R.drawable.custom_progress_bar);

        // set the drawable as progress drawable
        progressBar.setProgressDrawable(draw);


        CountDownTimer timer = new CountDownTimer(1000, 10) {
            @Override
            public void onTick(long l) {
                progressBar.setProgress((int) l);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(PhotoOrInBodyLoadingActivity.this, HomeTrainActivityOne.class));
                finish();
            }
        };
        timer.start();
    }
}