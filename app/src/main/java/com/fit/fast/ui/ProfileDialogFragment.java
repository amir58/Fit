package com.fit.fast.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.databinding.FragmentProfileDialogBinding;
import com.fit.fast.network.RetrofitSingleton;
import com.fit.fast.requests.AddRequest;
import com.fit.fast.requests.ChangePasswordRequest;
import com.fit.fast.responses.AddResponse;
import com.fit.fast.responses.ChangePasswordResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileDialogFragment extends DialogFragment {

    FragmentProfileDialogBinding binding;

    private static final String TAG = "ProfileDialogFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        binding.backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        binding.profileAnalysisTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.profileAnalysisCv.setVisibility(View.VISIBLE);
                binding.adsCv.setVisibility(View.INVISIBLE);
                binding.securityCv.setVisibility(View.INVISIBLE);
                binding.changePasswordCv.setVisibility(View.INVISIBLE);
            }
        });

        binding.securityTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.securityCv.setVisibility(View.VISIBLE);
                binding.adsCv.setVisibility(View.INVISIBLE);
                binding.profileAnalysisCv.setVisibility(View.INVISIBLE);
                binding.changePasswordCv.setVisibility(View.INVISIBLE);
            }
        });

        binding.adsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.adsCv.setVisibility(View.VISIBLE);
                binding.profileAnalysisCv.setVisibility(View.INVISIBLE);
                binding.securityCv.setVisibility(View.INVISIBLE);
                binding.changePasswordCv.setVisibility(View.INVISIBLE);
            }
        });

        binding.changePasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.changePasswordCv.setVisibility(View.VISIBLE);
                binding.profileAnalysisCv.setVisibility(View.INVISIBLE);
                binding.securityCv.setVisibility(View.INVISIBLE);
                binding.adsCv.setVisibility(View.INVISIBLE);
            }
        });

        binding.okBtn.setOnClickListener(view1 -> {
            getNewPassword();
        });

        binding.publish.setOnClickListener(v->{
            add();
        });
    }

    private void add() {
        String add = binding.add.getText().toString();
        String target = binding.target.getText().toString();
        String duration = binding.duration.getText().toString();

        if (!add.isEmpty() && !target.isEmpty() && !duration.isEmpty()){
            addData(add, target, duration);
        }
    }

    private void addData(String add, String target, String duration) {

        RetrofitSingleton.getClient().add(new AddRequest(add, duration, getUserId(), target))
                .enqueue(new Callback<AddResponse>() {
                    @Override
                    public void onResponse(Call<AddResponse> call, Response<AddResponse> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Log.i(TAG, "onResponse: not success");
                        }
                    }

                    @Override
                    public void onFailure(Call<AddResponse> call, Throwable t) {
                        Toast.makeText(requireContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private String getUserId() {
        SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        return preferences.getString("id", "");
    }

    private void getNewPassword() {
        String oldPwd = binding.oldPassword.getText().toString();
        String newPwd = binding.newPassword.getText().toString();

        if (!oldPwd.isEmpty() && !newPwd.isEmpty()){
            changePwd(oldPwd, newPwd);
        }
    }

    private void changePwd(String oldPwd, String newPwd) {
        RetrofitSingleton.getClient()
                .changePassword(oldPwd, newPwd, getUserId())
                .enqueue(new Callback<ChangePasswordResponse>() {
                    @Override
                    public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(requireContext(), "Password changed successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Log.i(TAG, "onResponse: not success");
                        }
                    }

                    @Override
                    public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
                        Toast.makeText(requireContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}