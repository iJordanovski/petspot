package com.creativehub.petspot.feature.servicetype;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativehub.petspot.databinding.FragmentServicesBinding;

public class ServiceTypeFragment extends Fragment {

    private FragmentServicesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        binding.lookingServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections directions = ServiceTypeFragmentDirections.actionCategoriesFragment();
                Navigation.findNavController(getView()).navigate(directions);
            }
        });
        binding.workWithUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections directions = ServiceTypeFragmentDirections.actionWorkWithUsFragment();
                Navigation.findNavController(getView()).navigate(directions);
            }
        });
    }

}