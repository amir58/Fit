package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.ui.WelcomeActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginBtn(View view) {
    }

    public void signupBtn(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, WelcomeActivity.class));
    }
}