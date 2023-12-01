package com.example.foodordering2.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView name, description, discount;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        imageView = itemView.findViewById(R.id.textView9);
        imageView = itemView.findViewById(R.id.textView10);
        discount = itemView.findViewById(R.id.discount);
    }
}
