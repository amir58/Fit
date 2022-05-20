package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.databinding.ActivityHomeTrainBottomNavigationBinding;
import com.google.android.material.tabs.TabLayout;

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
                openFragment(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                openFragment(tab);
            }
        });
    }

    private void openFragment(TabLayout.Tab tab) {
        int tabId = tab.getPosition();

        switch (tabId) {
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new HomeTrainFiveFragment())
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new HomeTrainSixFragment())
                        .commit();
                break;
            case 3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new PopularWorkoutFragment())
                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(new ProfileDialogFragment(), "profile")
                        .commit();
                break;
            default:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new PopularWorkoutFragment())
                        .commit();

                Toast.makeText(HomeTrainBottomNavigationActivity.this, "followUpTab", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void back(View view) {
       startActivity(new Intent(this, LoginActivity.class));
       finish();
    }
}