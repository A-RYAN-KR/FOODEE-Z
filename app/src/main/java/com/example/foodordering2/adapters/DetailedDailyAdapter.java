package com.example.foodordering2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.models.DetailedDailyModel;

import java.util.List;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {

    private List<DetailedDailyModel> list;
    private List<DetailedDailyModel> cartItems; // To store items added to cart

    public DetailedDailyAdapter(List<DetailedDailyModel> list, List<DetailedDailyModel> cartItems) {
        this.list = list;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailedDailyModel currentItem = list.get(position);

        holder.imageView.setImageResource(currentItem.getImage());
        holder.price.setText(currentItem.getPrice());
        holder.name.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
        holder.timing.setText(currentItem.getTiming());
        holder.rating.setText(currentItem.getRating());

        // Add to Cart button click listener
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.add(currentItem); // Add item to cart
                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
                cartItems.add(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price, description, rating, timing;
        Button addToCartButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            price = itemView.findViewById(R.id.detailed_price);
            description = itemView.findViewById(R.id.detailed_des);
            rating = itemView.findViewById(R.id.detailed_rating);
            timing = itemView.findViewById(R.id.detailed_timing);
            addToCartButton = itemView.findViewById(R.id.button2);
        }
    }
}
