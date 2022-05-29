package com.fit.fast.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.fit.fast.databinding.FragmentHomeTrainSixBinding;
import com.fit.fast.models.ExcelFileReader;
import com.fit.fast.models.Food;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeTrainSixFragment extends Fragment {

    FragmentHomeTrainSixBinding binding;

    double calories = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeTrainSixBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

//        extractFoodDataFromExcelFile();

//        FoodData foodData = (food) -> {
//
////            calories += foodCalories;
//
//            binding.caloriesLayout.setText(calories + " cal");
//        };
//
//        binding.foodRV.setAdapter(new FoodAdapter(getContext(), getFoodData(), foodData));

        binding.nutritionPlanBtn.setStrokeWidth(1);

        setClicks(binding.nutritionPlanBtn, binding.meal1Btn, binding.meal2Btn, binding.meal3Btn, 0);

        setClicks(binding.meal1Btn, binding.nutritionPlanBtn, binding.meal2Btn, binding.meal3Btn, 0);

        setClicks(binding.meal2Btn, binding.nutritionPlanBtn, binding.meal1Btn, binding.meal3Btn, 1);

        setClicks(binding.meal3Btn, binding.nutritionPlanBtn, binding.meal1Btn, binding.meal2Btn, 2);

//        binding.mealRv.setAdapter(new MealAdapter(new ShowItemDataI() {
//            @Override
//            public void showItemData(String txt) {
//                /*
//                 * Here where we receive the item data from the adapter through {ShowItemDataI}
//                 * to show it in the ui;
//                 */
//                binding.mealDetailsLayout.setVisibility(View.VISIBLE);
//                binding.logo2Image.setVisibility(View.VISIBLE);
//                binding.searchLayout.setVisibility(View.VISIBLE);
//
//                binding.logoImage.setVisibility(View.INVISIBLE);
//                binding.caloriesCalculatorTv.setVisibility(View.INVISIBLE);
//                binding.caloriesLayout.setVisibility(View.INVISIBLE);
//                binding.foodRV.setVisibility(View.INVISIBLE);
//
//                Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show();
//            }
//        }, getFoodData()));

        JSONArray json = new JSONArray(getFoodData());

        Gson gson = new Gson();

        String array = gson.toJson(getFoodData());

        ArrayList<ArrayList<String>> food = gson.fromJson(array, ArrayList.class);

        Log.i("oooo", "onViewCreated: "+ food);

        binding.createMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(requireContext(), CreateMyMealActivity.class);
                startActivity(intent);

//                binding.playImage.setVisibility(View.INVISIBLE);
//                binding.searchLayout.setVisibility(View.INVISIBLE);
//                binding.logo2Image.setVisibility(View.INVISIBLE);
//                binding.mealDetailsLayout.setVisibility(View.INVISIBLE);
//
//                binding.foodRV.setVisibility(View.VISIBLE);
//                binding.caloriesCalculatorTv.setVisibility(View.VISIBLE);
//                binding.caloriesLayout.setVisibility(View.VISIBLE);
//                binding.logoImage.setVisibility(View.VISIBLE);
            }
        });
    }

    private List<Food> getFoodData() {
        String fileName = "food_data.xls";
        return ExcelFileReader.readerClient(fileName, requireContext()).getFoodDataFromExcel();
    }

    private void setClicks(MaterialButton pressedBtn, MaterialButton unpressedBtn1,
                           MaterialButton unpressedBtn2, MaterialButton unpressedBtn3, int position) {

//        binding.mealRv.smoothScrollToPosition(position);

//        ((LinearLayoutManager) binding.mealRv.getLayoutManager()).scrollToPositionWithOffset(position, 0);

        binding.mealRv.getLayoutManager().smoothScrollToPosition(binding.mealRv, new RecyclerView.State(), position);

        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(requireContext()) {
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };

        smoothScroller.setTargetPosition(position);
        Objects.requireNonNull(binding.mealRv.getLayoutManager()).startSmoothScroll(smoothScroller);

//        binding.mealRv.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(context));
//        recyclerView.smoothScrollToPosition(position);

        pressedBtn.setOnClickListener(view -> {
            pressedBtn.setStrokeWidth(1);
            unpressedBtn1.setStrokeWidth(0);
            unpressedBtn2.setStrokeWidth(0);
            unpressedBtn3.setStrokeWidth(0);
        });
    }
}