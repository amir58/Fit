package com.fit.fast.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.R;
import com.fit.fast.databinding.ActivityBodyPhotoOneBinding;
import com.fit.fast.models.RealPathUtil;
import com.fit.fast.network.RegisterSingleton;

import org.jetbrains.annotations.NotNull;

import gun0912.tedimagepicker.builder.TedImagePicker;
import gun0912.tedimagepicker.builder.listener.OnSelectedListener;

public class BodyPhotoActivityOne extends AppCompatActivity {

    ActivityBodyPhotoOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBodyPhotoOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.activityBodyPhotoNextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BodyPhotoActivityOne.this, PhotoOrInBodyLoadingActivity.class));
            }
        });
    }

    public void back(View view) {
        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
        finish();
    }

    public void insertBody(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            requestPermission();
            return;
        }
        TedImagePicker.with(this)
                .start(new OnSelectedListener() {
                    @Override
                    public void onSelected(@NotNull Uri uri) {

                        Log.i("abdo", "onSelected: " + uri);

                        String path = RealPathUtil.getRealPath(BodyPhotoActivityOne.this, uri);

                        binding.activityInbodyResultSheetImage.setImageURI(uri);
                        binding.imageLayout.setBackground(null);

                        RegisterSingleton.setData().setImage(path);
                    }
                });
    }

    private void requestPermission() {
        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            TedImagePicker.with(this)
                    .start(uri -> {

                        Log.i("abdo", "onSelected: " + uri);

                        String path = RealPathUtil.getRealPath(BodyPhotoActivityOne.this, uri);

                        binding.activityInbodyResultSheetImage.setImageURI(uri);

                        RegisterSingleton.setData().setImage(path);
                    });
        } else {
            Toast.makeText(this, "Required a photo to continue !!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
        finish();
    }
}