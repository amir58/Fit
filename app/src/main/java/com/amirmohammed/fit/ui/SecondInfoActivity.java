package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.amirmohammed.fit.R;

public class SecondInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_info);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {
        startActivity(new Intent(this, FirstInfoActivity.class));
    }

    public void next(View view) {
        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
    }
}