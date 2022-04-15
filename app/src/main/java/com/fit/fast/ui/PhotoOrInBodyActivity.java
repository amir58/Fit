package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.fit.fast.R;

public class PhotoOrInBodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_or_in_body);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {
        startActivity(new Intent(this, SecondInfoActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, SecondInfoActivity.class));
        finish();
    }

    public void navigateToBodyPhoto(View view) {
        startActivity(new Intent(this, BodyPhotoActivityOne.class));
    }

    public void navigateToInBodyPhoto(View view) {
        startActivity(new Intent(this, InBodyActivity.class));
    }
}