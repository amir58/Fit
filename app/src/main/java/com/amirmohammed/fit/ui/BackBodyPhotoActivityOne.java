package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.network.RegisterSingleton;
import com.amirmohammed.fit.network.RetrofitSingleton;
import com.amirmohammed.fit.requests.RegisterRequest;
import com.amirmohammed.fit.requests.RegisterRequestErrorBody;
import com.amirmohammed.fit.responses.RegisterResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BackBodyPhotoActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_body_photo_one);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {
        startActivity(new Intent(this, FrontBodyPhotoActivityOne.class));
        finish();
    }

    public void finish(View view) {

        Uri uri = Uri.parse("android.resource://amirmohammed/drawable/logo_image");
        InputStream stream;
        try {
            stream = getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Log.i("abdo", "finish: before");
        Log.i("abdo", "finish: register request data "+ RegisterSingleton.registerRequest.toString());
//        RegisterSingleton.setData().setImage(uri);
        RetrofitSingleton.getClient().register(RegisterSingleton.registerRequest)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                        if (response.isSuccessful()){
                            Log.i("abdo", "abdo onResponse: "+ response.body().toString());
                            startActivity(new Intent(BackBodyPhotoActivityOne.this, PhotoOrInBodyLoadingActivity.class));
                            finish();
                        }
                        else {

                            Log.i("abdo", "onResponse: "+ response.code());

                            Gson gson = new Gson();
                            RegisterRequestErrorBody requestErrorBody = new RegisterRequestErrorBody();
                            try {
                                requestErrorBody = gson.fromJson(response.errorBody().string(), RegisterRequestErrorBody.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(BackBodyPhotoActivityOne.this, requestErrorBody.toString(), Toast.LENGTH_SHORT).show();
                            Log.i("abdo", "onResponse: not "+ requestErrorBody);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Log.i("abdo", "abdo onFailure: "+ t.getLocalizedMessage());
                    }
                });

        Log.i("abdo", "finish: after");
    }
}