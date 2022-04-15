package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.fit.fast.R;

public class HomeTrainFourteenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_train_fourteen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {
        startActivity(new Intent(this, HomeTrainActivityOne.class));
        finish();
    }

    public void navigateToHomeTrainBottomNavigationActivity(View view) {
        startActivity(new Intent(this, HomeTrainBottomNavigationActivity.class));
    }
}