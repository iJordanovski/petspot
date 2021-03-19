package com.creativehub.petspot.feature.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativehub.petspot.databinding.FragmentAdsBinding;
import com.creativehub.petspot.databinding.ItemAdsBinding;
import com.creativehub.petspot.model.Category;
import com.creativehub.petspot.model.CategoryAds;

import java.util.ArrayList;
import java.util.List;

public class AdsFragment extends Fragment {

    private FragmentAdsBinding binding;
    private AdsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        adapter = new AdsAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        adapter.addAll(getAds());
        binding.toolbar.toolbarTitle.setText("Пребарај огласи");
        binding.toolbar.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getView());
                navController.navigateUp();
            }
        });
    }

    public List<CategoryAds> getAds() {
        List<CategoryAds> adsList = new ArrayList<>();
        adsList.add(new CategoryAds());
        return adsList;
    }
}