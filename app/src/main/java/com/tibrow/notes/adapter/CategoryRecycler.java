package com.tibrow.notes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tibrow.notes.R;
import com.tibrow.notes.model.Category;

import java.util.ArrayList;

public class CategoryRecycler extends RecyclerView.Adapter<CategoryRecycler.ViewHolder> {

   ArrayList<Category> categories;
   Context context;

    public CategoryRecycler(ArrayList<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_res, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecycler.ViewHolder holder, int position) {

        Log.e(TAG, "--: " + position  + " --- " + (categories.size() - 1) );
        if (position == categories.size() - 1){
            holder.iv.setVisibility(View.VISIBLE);
            holder.tv.setVisibility(View.GONE);
        }else{
            holder.iv.setVisibility(View.GONE);
            holder.tv.setVisibility(View.VISIBLE);
        }

        holder.tv.setText(categories.get(position).getCategoryName());
        holder.iv.setOnClickListener(o->{

            showDialog(holder, position);
           // holder.tv.setText(categories.get(position).getCategoryName());
            //notifyDataSetChanged();
            Log.e(TAG, "onBindViewHolder: " + categories );
        });
    }

    private static final String TAG = "CategoryRecycler";
    private void showDialog(CategoryRecycler.ViewHolder holder, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.cat_edit, null);
        EditText editText = dialogView.findViewById(R.id.editText);
        Button btnSave = dialogView.findViewById(R.id.btnSave);

        // Initialize the dialog content or pre-fill the EditText if needed

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        btnSave.setOnClickListener(view -> {
            // Handle the Save button click, update your data and notify the adapter
            String newText = editText.getText().toString();
            // Update your data list at 'position' with the new text

            // Notify the adapter about the change
            Category category = new Category();
            category.setCategoryName(newText);
            categories.add(categories.size() - 1, category);
            holder.tv.setText(newText);
            notifyItemChanged(position);

            Log.e(TAG, "showDialog: "  + categories.size() );
            dialog.dismiss();
        });

        dialog.show();
    }
    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.addIv);
            tv = itemView.findViewById(R.id.cateTv);
        }
    }
}
