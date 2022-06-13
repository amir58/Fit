package com.fit.fast.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.databinding.ActivityLoginBinding;
import com.fit.fast.network.RetrofitSingleton;
import com.fit.fast.requests.LoginRequest;
import com.fit.fast.responses.LoginResponse;
import com.fit.fast.responses.RegisterResponse;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void loginBtn(View view) {
        requestLogin();
    }

    private void requestLogin() {
        String username = binding.activityLoginUsernameEt.getText().toString();
        String password = binding.activityLoginPasswordEt.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username and password required", Toast.LENGTH_SHORT).show();
            return;
        }

        RetrofitSingleton.getClient().login(username, password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful() && response.body().getError() == null) {
                            Log.i(TAG, "onResponse: success --- " + response.body());
                            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("id", String.valueOf(response.body().getId()));
                            editor.apply();

                            getUserData(response.body().getId());

                        } else {
                            Log.i(TAG, "onResponse: not success --- " + response.body().getError());
                            Log.i(TAG, "onResponse: ---------------- " + response.errorBody());
                            Toast.makeText(LoginActivity.this, response.body().getError() + " or password is incorrect", Toast.LENGTH_LONG).show();

//                            getErrorBody(response);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
                        Toast.makeText(LoginActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getUserData(int id) {
        RetrofitSingleton.getClient().getAccountDetails(id)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        Log.i(TAG, "onResponse: " + response.code());

                        if (response.isSuccessful()) {
                            SharedPreferences preferences = getSharedPreferences("registerResponse", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            Gson gson = new Gson();
                            String json = gson.toJson(response.body());
                            Log.i(TAG, "onResponse: " + json);
                            editor.putString("userData", json);
                            editor.apply();

                            startActivity(new Intent(LoginActivity.this, HomeTrainActivityOne.class));
                            finish();

                        } else {
                            Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
                        Toast.makeText(LoginActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void getErrorBody(Response<LoginResponse> response) {
        Gson gson = new Gson();
        LoginResponse loginResponse = new LoginResponse();

        try {
            loginResponse = gson.fromJson(response.errorBody().string(), LoginResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(LoginActivity.this, loginResponse.getError() + "", Toast.LENGTH_LONG).show();

    }

    public void signupBtn(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, WelcomeActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, WelcomeActivity.class));
        finish();
    }
}