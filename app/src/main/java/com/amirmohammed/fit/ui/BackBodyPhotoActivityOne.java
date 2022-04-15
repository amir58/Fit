package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.network.RegisterSingleton;
import com.amirmohammed.fit.network.RetrofitSingleton;
import com.amirmohammed.fit.responses.RegisterResponseErrorBody;
import com.amirmohammed.fit.responses.RegisterResponse;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, FrontBodyPhotoActivityOne.class));
        finish();
    }

    public void finish(View view) {

//        Log.i("abdo", "finish: before");
//        Log.i("abdo", "finish: register request data "+ RegisterSingleton.registerRequestBody.toString());
//        Log.i("abdo", "finish: register request data "+ RegisterSingleton.registerRequestBody.getGender());
////        RegisterSingleton.setData().setImage(uri);
//
//        //pass it like this
//        File file = new File(RegisterSingleton.registerRequestBody.getImage());
//
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//
//        // MultipartBody.Part is used to send also the actual file name
//        MultipartBody.Part body =
//                MultipartBody.Part.createFormData("Image", file.getName(), requestFile);
//
//        // add another part within the multipart request
//
//        RetrofitSingleton.getClient().register(
//                RegisterSingleton.registerRequestBody.getName(),
//                RegisterSingleton.registerRequestBody.getUsername(),
//                RegisterSingleton.registerRequestBody.getAge(),
//                RegisterSingleton.registerRequestBody.getSport(),
//                RegisterSingleton.registerRequestBody.getEmail(),
//                RegisterSingleton.registerRequestBody.getGender(),
//                RegisterSingleton.registerRequestBody.getTrain(),
//                RegisterSingleton.registerRequestBody.getWeight(),
//                RegisterSingleton.registerRequestBody.getHeight(),
//                RegisterSingleton.registerRequestBody.getHours(),
//                RegisterSingleton.registerRequestBody.getEffort(),
//                RegisterSingleton.registerRequestBody.getGoalType(),
//                RegisterSingleton.registerRequestBody.getGoalWeight(),
//                RegisterSingleton.registerRequestBody.getPassword(),
//                RegisterSingleton.registerRequestBody.getPassword2(),
//                body)
//                .enqueue(new Callback<RegisterResponse>() {
//                    @Override
//                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//
//                        if (response.isSuccessful()){
//                            Log.i("abdo", "abdo onResponse: "+ response.body().toString());
//                            startActivity(new Intent(BackBodyPhotoActivityOne.this, PhotoOrInBodyLoadingActivity.class));
//                            finish();
//                        }
//                        else {
//
//                            Log.i("abdo", "onResponse: "+ response.code());
//
//                            Gson gson = new Gson();
//                            RegisterResponseErrorBody requestErrorBody = new RegisterResponseErrorBody();
//                            //                                requestErrorBody = gson.fromJson(response.errorBody().string(), RegisterResponseErrorBody.class);
//                            Toast.makeText(BackBodyPhotoActivityOne.this, requestErrorBody.toString(), Toast.LENGTH_SHORT).show();
//                            Log.i("abdo", "onResponse: not "+ requestErrorBody);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                        Log.i("abdo", "abdo onFailure: "+ t.getLocalizedMessage());
//                    }
//                });
//
//        Log.i("abdo", "finish: after");
    }
}