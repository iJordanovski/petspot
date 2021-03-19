package com.creativehub.petspot.feature.user.register;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.creativehub.petspot.databinding.FragmentRegisterBinding;

import java.util.ArrayList;
import java.util.List;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        binding.toolbar.toolbarTitle.setText("Регистрирај се");
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
                validateAllFields();
            }
        });
    }

    private boolean validateName() {
        String name = binding.firstNameField.getEditText().getText().toString();

        if (!name.isEmpty() ) {
            binding.name.setError(null);
            return true;
    }    else {
            binding.name.setError("Задолжително поле");
            return false;
        }

    }

    private boolean validateUserName() {
        String userName = binding.userNameField.getEditText().getText().toString();

        if (!userName.isEmpty()) {
            binding.userName.setError(null);
            return true;
        } else {
            binding.userName.setError("Задолжително поле");
            return false;
        }
    }

    private boolean validateEmail() {
        String email = binding.emailField.getEditText().getText().toString();
        if (email.isEmpty()) {
            binding.email.setError("Ова поле е задолжително");
            return false;
        }
       else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.setError("Внесете валидна емаил адреса");
            return false;
        }
       else {
           return true;
        }
    }

    private boolean validatePassword() {
        String password = binding.passwordField.getEditText().getText().toString();
        if (password.length() >= 6) {
            binding.password.setError(null);
            return true;
        } else {
            binding.password.setError("Лозинката мора да содржи минимум шест карактери");
            return false;
        }
    }

    private boolean validateRepeatPassword() {
        String repeatPassword = binding.repeatPasswordField.getEditText().getText().toString();
        String password = binding.passwordField.getEditText().getText().toString();
        if (repeatPassword.contains(password)) {
            binding.repeatPassword.setError(null);
            return true;
        } else {
            binding.repeatPassword.setError("Лозинката мора да се совпаѓа");
            return false;
        }
    }

    private boolean validatePhoneNumber() {
        String phoneNumber = binding.phoneNumberField.getEditText().getText().toString();

        if (phoneNumber.isEmpty()) {
            binding.phoneNumber.setError("Задолжително поле");
            return false;
        } else if(phoneNumber.length() != 9) {
            binding.phoneNumber.setError("Внесете валиден телефонски број");
            return false;
        }
        else {
            binding.phoneNumber.setError(null);
            return true;
        }
    }

    private void validateAllFields() {
        if (validateName() && validateUserName() && validateEmail() && validatePassword() && validateRepeatPassword() && validatePhoneNumber()) {
            Toast.makeText(getContext(),"Успешно се регистриравте",Toast.LENGTH_SHORT).show();
            NavController navController = Navigation.findNavController(getView());
            navController.navigateUp();
        }else {
            Toast.makeText(getContext(),"Сите полиња се задолжителни",Toast.LENGTH_SHORT).show();
        }
    }
}