package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.fit.fast.databinding.ActivityFrontBodyPhotoOneBinding;
import com.fit.fast.models.RealPathUtil;
import com.fit.fast.network.RegisterSingleton;

import org.jetbrains.annotations.NotNull;

import gun0912.tedimagepicker.builder.TedImagePicker;
import gun0912.tedimagepicker.builder.listener.OnSelectedListener;



public class FrontBodyPhotoActivityOne extends AppCompatActivity {

    ActivityFrontBodyPhotoOneBinding binding;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFrontBodyPhotoOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {

        startActivity(new Intent(this, BodyPhotoActivityOne.class));
        finish();
    }

    public void next(View view) {
        startActivity(new Intent(this, BackBodyPhotoActivityOne.class));
    }

    public void getImageFromGallery(View view) {

        TedImagePicker.with(this)
                .start(new OnSelectedListener() {
                    @Override
                    public void onSelected(@NotNull Uri uri) {

                        Log.i("abdo", "onSelected: "+ uri);

                        path = RealPathUtil.getRealPath(FrontBodyPhotoActivityOne.this, uri);

                        RegisterSingleton.setData().setImage(path);
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, BodyPhotoActivityOne.class));
        finish();
    }
}