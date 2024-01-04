package com.example.foodordering2.adapters;

import android.content.Context;
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
import com.example.foodordering2.activities.CartManager;
import com.example.foodordering2.models.DetailedDailyModel;
import com.example.foodordering2.models.HomeVerModel;

import java.util.List;

public class DetailedDailyAdapter<T> extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {

    private List<T> list;
    private List<T> cartItems; // To store items added to cart

    public DetailedDailyAdapter(List<T> list, List<T> cartItems) {
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
        T currentItem = list.get(position);

        holder.imageView.setImageResource(((DetailedDailyModel) currentItem).getImage());
        holder.price.setText(((DetailedDailyModel) currentItem).getPrice());
        holder.name.setText(((DetailedDailyModel) currentItem).getName());
        holder.description.setText(((DetailedDailyModel) currentItem).getDescription());
        holder.timing.setText(((DetailedDailyModel) currentItem).getTiming());
        holder.rating.setText(((DetailedDailyModel) currentItem).getRating());

        // Add to Cart button click listener
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.add(currentItem); // Add item to cart
                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
                CartManager.getInstance().addToCart(currentItem);

                // Notify the adapter about the change in data
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void addToCart(T item, Context context) {
        CartManager.getInstance().addToCart(item);
        Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
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
