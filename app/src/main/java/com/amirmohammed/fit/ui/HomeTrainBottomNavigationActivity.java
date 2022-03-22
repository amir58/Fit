package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityHomeTrainBottomNavigationBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.Stack;

public class HomeTrainBottomNavigationActivity extends AppCompatActivity {

    private ActivityHomeTrainBottomNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeTrainBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentContainerView.getId(), new FollowUpFragment())
                .commit();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabId = tab.getPosition();

                switch (tabId) {
                    case 1:
                        Toast.makeText(HomeTrainBottomNavigationActivity.this, "workOutTab", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(HomeTrainBottomNavigationActivity.this, "dietPlanTab", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(HomeTrainBottomNavigationActivity.this, "profileTab", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(binding.fragmentContainerView.getId(), new FollowUpFragment())
                                .commit();
                        Toast.makeText(HomeTrainBottomNavigationActivity.this, "followUpTab", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void back(View view) {
       this.onBackPressed();
    }
}