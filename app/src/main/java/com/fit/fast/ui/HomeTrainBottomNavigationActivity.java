package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.adapters.FoodPlanAdapter;
import com.fit.fast.databinding.ActivityHomeTrainBottomNavigationBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Food;
import com.fit.fast.responses.RegisterResponse;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeTrainBottomNavigationActivity extends AppCompatActivity {
    private static final String TAG = "HomeTrainBottomNavigati";
    private ActivityHomeTrainBottomNavigationBinding binding;

    private List<Food> getFoodData() {
        String fileName = "food_data.xls";
        return ExcelFileReader.readerClient(fileName, this)
                .getFoodDataFromExcel(fileName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeTrainBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentContainerView.getId(), new HomeTrainFiveFragment())
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
            case 0:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new HomeTrainFiveFragment())
                        .commit();
                break;
            case 1:
                List<Food> foods = getFoodData();
                for (Food food : foods) {
                    Log.i(TAG, "openFragment: " + food.toString());
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new HomeTrainSixFragment(foods))
                        .commit();
                break;
            case 2:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(binding.fragmentContainerView.getId(), new PopularWorkoutFragment())
//                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(new ProfileDialogFragment(), "profile")
                        .commit();
                break;
            default:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.fragmentContainerView.getId(), new HomeTrainFiveFragment())
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