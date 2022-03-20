package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.amirmohammed.fit.R;

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

        progressBar.setProgress(50);
    }
}