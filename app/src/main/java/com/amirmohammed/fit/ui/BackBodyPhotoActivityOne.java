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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

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

    public void finish(View view) {

        Log.i("abdo", "finish: before");
        Log.i("abdo", "finish: register request data "+ RegisterSingleton.registerRequest.toString());
//        RegisterSingleton.setData().setImage(uri);

        //pass it like this
        File file = new File(RegisterSingleton.registerRequest.getImageUri());

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        // add another part within the multipart request

        RetrofitSingleton.getClient().register(
                setRequestBody("name", RegisterSingleton.registerRequest.getName()),
                setRequestBody("username", RegisterSingleton.registerRequest.getUsername()),
                setRequestBody("age", RegisterSingleton.registerRequest.getAge()),
                setRequestBody("sport", RegisterSingleton.registerRequest.getSport()),
                setRequestBody("email", RegisterSingleton.registerRequest.getEmail()),
                setRequestBody("gender", RegisterSingleton.registerRequest.getGender()),
                setRequestBody("train", RegisterSingleton.registerRequest.getTrain()),
                setRequestBody("weight", RegisterSingleton.registerRequest.getWeight()),
                setRequestBody("height", RegisterSingleton.registerRequest.getHeight()),
                setRequestBody("hours", RegisterSingleton.registerRequest.getHours()),
                setRequestBody("effort", RegisterSingleton.registerRequest.getEffort()),
                setRequestBody("goalType", RegisterSingleton.registerRequest.getGoalType()),
                setRequestBody("goalWeight", RegisterSingleton.registerRequest.getGoalWeight()),
                setRequestBody("password", RegisterSingleton.registerRequest.getPassword()),
                body)
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

    public RequestBody setRequestBody(String bodyName, Object content){
        return RequestBody.create(MediaType.parse("multipart/form-data"),
                String.valueOf(content));

    }
}