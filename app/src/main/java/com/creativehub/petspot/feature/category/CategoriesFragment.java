package com.creativehub.petspot.feature.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativehub.petspot.databinding.FragmentCategoriesBinding;
import com.creativehub.petspot.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    private FragmentCategoriesBinding binding;
    private CategoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        adapter = new CategoryAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter.addAll(getCategories());

        binding.toolbar.toolbarTitle.setText("Одбери категорија");
        binding.toolbar.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getView());
                navController.navigateUp();
            }
        });

//        binding.walk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections directions = CategoriesFragmentDirections.actionAdsFragment();
//                Navigation.findNavController(getView()).navigate(directions);
//            }
//        });
//        binding.groom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections directions = CategoriesFragmentDirections.actionAdsFragment();
//                Navigation.findNavController(getView()).navigate(directions);
//            }
//        });
//        binding.transport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections directions = CategoriesFragmentDirections.actionAdsFragment();
//                Navigation.findNavController(getView()).navigate(directions);
//            }
//        });
//        binding.train.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections directions = CategoriesFragmentDirections.actionAdsFragment();
//                Navigation.findNavController(getView()).navigate(directions);
//            }
//        });
    }
    public List<Category> getCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(0,"Walk","categories_walk"));
        categoryList.add(new Category(1,"Groom","categories_groom"));
        categoryList.add(new Category(2,"Train","categories_train"));
        categoryList.add(new Category(3,"Transport","categories_transport"));
        return categoryList;
    }
}