package com.creativehub.petspot.feature.category;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.creativehub.petspot.R;
import com.creativehub.petspot.databinding.FragmentAdsBinding;
import com.creativehub.petspot.databinding.FragmentCategoriesBinding;
import com.creativehub.petspot.databinding.ItemCategoryBinding;
import com.creativehub.petspot.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categories;

    public void addAll(List<Category> categoryList) {
        categories = new ArrayList<>();
        categories.clear();
        categories.addAll(categoryList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding binding;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCategoryBinding.bind(itemView);
        }

        public void bind(Category category) {
            binding.category.setImageDrawable(getImage(category.imageUrl));
//            binding.category.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //TODO:Go to ads fragment
//                }
//            });
        }

        private Drawable getImage(String imageName) {
            Context context = binding.category.getContext();
            Resources resources = context.getResources();
            final int resourceId = resources.getIdentifier(imageName, "drawable",
                    context.getPackageName());
            return ContextCompat.getDrawable(context,resourceId);
        }
    }
}
