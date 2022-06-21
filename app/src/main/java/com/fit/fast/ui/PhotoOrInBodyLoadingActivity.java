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
import android.widget.Toast;

import com.fit.fast.R;
import com.fit.fast.network.RegisterSingleton;
import com.fit.fast.network.RetrofitSingleton;
import com.fit.fast.responses.RegisterResponse;
import com.fit.fast.responses.RegisterResponseErrorBody;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoOrInBodyLoadingActivity extends AppCompatActivity {

    CountDownTimer timer = null;
    Thread thread = null;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_or_in_body_loading);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        progressBar = findViewById(R.id.mprogress_horizontal);

        // Get the Drawable custom_progressbar
        @SuppressLint("UseCompatLoadingForDrawables") Drawable draw = getResources().getDrawable(R.drawable.custom_progress_bar);

        // set the drawable as progress drawable
        progressBar.setProgressDrawable(draw);

        requestRegister();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    progressBar.setProgress(i);
                    Log.i("abdo", "onResponse: bbcc " + thread.isAlive());

                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        Log.i("abdo", "onResponse: bb " + thread.isAlive());

    }

    private void requestRegister() {
        //pass it like this
        File file = null;
        if (RegisterSingleton.registerRequestBody.getImage() == null){
            Toast.makeText(this, "Please upload an image", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, InBodyActivity.class));
            return;
        }
        try {
            file = new File(RegisterSingleton.registerRequestBody.getImage());
        } catch (Exception e) {
            Toast.makeText(PhotoOrInBodyLoadingActivity.this, "Something went wrong please try again", Toast.LENGTH_LONG).show();
        }

        assert file != null;
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("Image", file.getName(), requestFile);

        // add another part within the multipart request

        RetrofitSingleton.getClient().register(
                        RegisterSingleton.registerRequestBody.getName(),
                        RegisterSingleton.registerRequestBody.getUsername(),
                        RegisterSingleton.registerRequestBody.getAge(),
                        RegisterSingleton.registerRequestBody.getSport(),
                        RegisterSingleton.registerRequestBody.getEmail(),
                        RegisterSingleton.registerRequestBody.getGender(),
                        RegisterSingleton.registerRequestBody.getTrain(),
                        RegisterSingleton.registerRequestBody.getWeight(),
                        RegisterSingleton.registerRequestBody.getHeight(),
                        RegisterSingleton.registerRequestBody.getHours(),
                        RegisterSingleton.registerRequestBody.getEffort(),
                        RegisterSingleton.registerRequestBody.getGoalType(),
                        RegisterSingleton.registerRequestBody.getGoalWeight(),
                        RegisterSingleton.registerRequestBody.getPassword(),
                        RegisterSingleton.registerRequestBody.getPassword2(),
                        body)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i("abdo", "onResponse: bb" + thread.isAlive());
                            SharedPreferences preferences = getSharedPreferences("registerResponse", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            Gson gson = new Gson();
                            String json = gson.toJson(response.body());
                            editor.putString("userData", json);
                            editor.apply();

                            thread.interrupt();
                            progressBar.setProgress(100);

                            startActivity(new Intent(PhotoOrInBodyLoadingActivity.this,
                                    HomeTrainActivityOne.class));
                            finish();
                        } else {

                            Gson gson = new Gson();
                            RegisterResponseErrorBody requestErrorBody = new RegisterResponseErrorBody();
                            try {
                                requestErrorBody = gson.fromJson(response.errorBody().string(), RegisterResponseErrorBody.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(PhotoOrInBodyLoadingActivity.this, requestErrorBody.toString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(PhotoOrInBodyLoadingActivity.this, InBodyActivity.class));
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(PhotoOrInBodyLoadingActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PhotoOrInBodyLoadingActivity.this, InBodyActivity.class));
                        finish();
                    }
                });

    }


}