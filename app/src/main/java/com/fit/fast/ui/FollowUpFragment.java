package com.fit.fast.ui;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.R;
import com.fit.fast.databinding.FragmentFollowUpBinding;
import com.fit.fast.network.RetrofitSingleton;
import com.fit.fast.requests.WeightModel;
import com.fit.fast.responses.RegisterResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FollowUpFragment extends Fragment {
    private static final String TAG = "FollowUpFragment";
    private FragmentFollowUpBinding binding;
    //    NavController navController;
    private boolean isFragmentVisible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentFollowUpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        this.view = view;
//        navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        if (!isFragmentVisible) {
//            navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
        }

        binding.newWeightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String weight = binding.newWeightEt.getText().toString();
                if (weight.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please insert your new WEIGHT !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences registerPreferences = requireContext().getSharedPreferences(
                        "registerResponse", MODE_PRIVATE);
                Gson gson = new Gson();
                RegisterResponse response =
                        gson.fromJson(registerPreferences.getString("userData", ""), RegisterResponse.class);

                SharedPreferences loginPreferences = requireContext().getSharedPreferences(
                        "login", MODE_PRIVATE);
                String id = loginPreferences.getString("id", "");

                Log.i(TAG, "onClick: " + id);
                Log.i(TAG, "onClick: " + weight);
                RetrofitSingleton.getClient().setNewWeight(id, weight)
                        .enqueue(new Callback<WeightModel>() {
                            @Override
                            public void onResponse(Call<WeightModel> call, Response<WeightModel> response) {
                                if (response.isSuccessful()) {
                                    getUserData(Integer.parseInt(id));
                                    Toast.makeText(requireActivity(), "Weight set successfully", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(requireActivity(), response.message(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<WeightModel> call, Throwable t) {
                                Toast.makeText(requireActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
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
                            SharedPreferences preferences = requireActivity().getSharedPreferences("registerResponse", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            Gson gson = new Gson();
                            String json = gson.toJson(response.body());
                            Log.i(TAG, "onResponse: " + json);
                            editor.putString("userData", json);
                            editor.apply();

                        } else {
                            Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
                        Toast.makeText(requireContext(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onStart() {
        super.onStart();
//        navController = Navigation.findNavController(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        isFragmentVisible = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isFragmentVisible = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        isFragmentVisible = false;
    }
}