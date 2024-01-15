package com.example.foodordering2.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.foodordering2.activities.CartDatabaseHelper;
import com.example.foodordering2.models.DetailedDailyModel;

import java.util.ArrayList;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {

    Context context;
    ArrayList<DetailedDailyModel> list;
    private CartDatabaseHelper databaseHelper;

    public DetailedDailyAdapter(Context context, ArrayList<DetailedDailyModel> list) {
        this.context = context;
        this.list = list;
        databaseHelper = new CartDatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

        // Add to Cart button click listener
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void addToCart(DetailedDailyModel item) {
        // Add the item to the SQLite database
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", item.getName());
        values.put("price", item.getPrice());
        values.put("rating", item.getRating());
        values.put("image", item.getImage());

        db.insert("cart_items", null, values);
        db.close();

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
