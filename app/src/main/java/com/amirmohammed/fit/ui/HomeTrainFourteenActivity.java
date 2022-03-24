package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amirmohammed.fit.R;

public class HomeTrainFourteenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_train_fourteen);
    }

    public void back(View view) {
        startActivity(new Intent(this, HomeTrainActivityOne.class));
    }

    public void navigateToHomeTrainBottomNavigationActivity(View view) {
        startActivity(new Intent(this, HomeTrainBottomNavigationActivity.class));
    }
}