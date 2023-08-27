package com.tibrow.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.tibrow.notes.adapter.CategoryRecycler;
import com.tibrow.notes.databinding.ActivityMainBinding;
import com.tibrow.notes.model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category());

        CategoryRecycler recycler = new CategoryRecycler(categories, MainActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false);

        binding.category.setLayoutManager(gridLayoutManager);
        binding.category.setAdapter(recycler);
    }
}