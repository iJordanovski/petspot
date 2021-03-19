package com.creativehub.petspot.feature.user.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.creativehub.petspot.databinding.FragmentWorkWithUsBinding;

public class WorkWithUsFragment extends Fragment {

    private FragmentWorkWithUsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWorkWithUsBinding.inflate(inflater);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }
    private void setupUi() {
        binding.toolbar.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getView());
                navController.navigateUp();
            }
        });
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections directions = WorkWithUsFragmentDirections.actionWorkWithUsFragmentToRegisterFragment();
                Navigation.findNavController(getView()).navigate(directions);
            }
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = binding.email.getEditText().getText().toString();
                String password = binding.password.getEditText().getText().toString();
                if(!user.isEmpty() && !password.isEmpty()) {
                    NavDirections directions = WorkWithUsFragmentDirections.actionWorkWithUsFragmentToUserProfileFragment();
                    Navigation.findNavController(getView()).navigate(directions);
                } else  {
                    Toast.makeText(getContext(),"Потребно е да ги пополните сите полиња за да се најавите. ",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}