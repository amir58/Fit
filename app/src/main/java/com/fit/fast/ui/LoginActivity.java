package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.databinding.ActivityLoginBinding;
import com.fit.fast.network.RetrofitSingleton;
import com.fit.fast.requests.LoginRequest;
import com.fit.fast.responses.LoginResponse;
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

        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Username and password required", Toast.LENGTH_SHORT).show();
            return;
        }

        RetrofitSingleton.getClient().login(new LoginRequest(username, password))
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            Log.i(TAG, "onResponse: success --- "+ response.body());
                            startActivity(new Intent(LoginActivity.this,
                                    HomeTrainBottomNavigationActivity.class));
                            finish();
                        }
                        else{
                            Log.i(TAG, "onResponse: not success --- ");
                            Log.i(TAG, "onResponse: ---------------- "+ response.errorBody());

                            getErrorBody(response);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
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
        Toast.makeText(LoginActivity.this, loginResponse.getErrorMessage() + "", Toast.LENGTH_LONG).show();

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