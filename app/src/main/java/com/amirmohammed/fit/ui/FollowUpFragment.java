package com.amirmohammed.fit.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.FragmentFollowUpBinding;


public class FollowUpFragment extends Fragment {

    private FragmentFollowUpBinding binding;
    NavController navController;
    View view;
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
        navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        if (!isFragmentVisible) {
            navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
        }

        binding.photoForBodyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_followUpFragment_to_bodyPhotoActivityOne);
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