package com.tibrow.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tibrow.notes.databinding.ActivityCategoryWiseBinding;

public class CategoryWise extends AppCompatActivity {

    ActivityCategoryWiseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCategoryWiseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}