package com.creativehub.petspot.feature.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.creativehub.petspot.R;
import com.creativehub.petspot.databinding.ItemAdsBinding;
import com.creativehub.petspot.model.Category;
import com.creativehub.petspot.model.CategoryAds;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdsViewHolder> {
    public List<CategoryAds> categoryAds;

    public void addAll(List<CategoryAds>categoryAdsList) {
        categoryAds.clear();
        categoryAds.addAll(categoryAdsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ads,parent,false);
        return new AdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder holder, int position) {
        holder.bind(categoryAds.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryAds.size();
    }

    static class AdsViewHolder extends RecyclerView.ViewHolder {
        public ItemAdsBinding binding;

        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemAdsBinding.bind(itemView);
        }

        public void bind(CategoryAds ads) {
            binding.name.setText(ads.name);
            binding.phoneNumber.setText(ads.phoneNumber);
            binding.city.setText(ads.city);
            binding.description.setText(ads.description);
        }
    }

}
