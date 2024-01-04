package com.example.foodordering2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.models.CartModel;
import com.example.foodordering2.ui.MyCart.MyCartFragment;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    List<CartModel> list;
    private Context context; // Add this variable
    private double totalCartPrice; // Add this variable

    public CartAdapter(Context context, List<CartModel> list, double totalCartPrice) {
        this.context = context;
        this.list = list;
        this.totalCartPrice = totalCartPrice;
    }

    public void updateTotalPrice(double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartModel currentItem = list.get(position);

        holder.imageView.setImageResource(currentItem.getImage());
        holder.name.setText(currentItem.getname());
        holder.rating.setText(currentItem.getRating());
        holder.price.setText(currentItem.getPrice());

        // Implement remove button click listener
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int removedPosition = holder.getAdapterPosition();
                list.remove(removedPosition); // Remove item from the list
                notifyItemRemoved(removedPosition); // Notify adapter about the removal
                notifyItemRangeChanged(removedPosition, list.size()); // Refresh the items

                double newTotalPrice = calculateTotalPrice();
                updateTotalPrice(newTotalPrice); // Update the total price
                // Notify the fragment to update the total price display
                if (listener != null) {
                    listener.updateTotalPrice();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(CartModel model) {
        list.add(model);
        notifyItemInserted(list.size() - 1); // Notify adapter about the addition
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, rating, price;
        Button removeButton; // Add Button reference

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            rating = itemView.findViewById(R.id.detailed_rating);
            price = itemView.findViewById(R.id.textView12);
            removeButton = itemView.findViewById(R.id.remove_item_btn); // Initialize the Button reference
        }
    }
    public void updateTotalPrice() {
        this.totalCartPrice = calculateTotalPrice();
    }
    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (CartModel cartItem : list) {
            // Assuming price is stored as a string, convert it to double
            double itemPrice = Double.parseDouble(cartItem.getPrice());
            totalPrice += itemPrice;
        }
        return totalPrice;
    }
    public interface CartAdapterListener {
        void updateTotalPrice();
    }
    private CartAdapterListener listener;

    public void setListener(CartAdapterListener listener) {
        this.listener = listener;
    }

}

