package com.amirmohammed.fit.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.FragmentProfileDialogBinding;

public class ProfileDialogFragment extends DialogFragment {

    FragmentProfileDialogBinding binding;

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


    }
}