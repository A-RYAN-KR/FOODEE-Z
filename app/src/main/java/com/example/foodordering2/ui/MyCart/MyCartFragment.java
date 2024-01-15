package com.example.foodordering2.ui.MyCart;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.activities.CartDatabaseHelper;
import com.example.foodordering2.adapters.CartAdapter;
import com.example.foodordering2.models.CartModel;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

import java.util.List;
import java.util.Locale;

public class MyCartFragment extends Fragment implements CartAdapter.CartAdapterListener {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    List<CartModel> cartModels;
    Button orderBtn;
    TextView totalPriceTextView;

    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Retrieve cart items from the database
        CartDatabaseHelper databaseHelper = new CartDatabaseHelper(getContext());
        cartModels = databaseHelper.getAllCartItems();

        // Set up the CartAdapter
        cartAdapter = new CartAdapter(getContext(), cartModels, calculateTotalPrice());
        cartAdapter.setListener(this);
        recyclerView.setAdapter(cartAdapter);

        totalPriceTextView = view.findViewById(R.id.total_price);

        orderBtn = view.findViewById(R.id.order_btn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.baseline_add_alert_24)
                        .setTitle("Order Confirmation")
                        .setMessage("Are you sure you want to confirm the order ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(getContext(), "Order Confirmed", Toast.LENGTH_SHORT).show();
                                PopupDialog.getInstance(getContext())
                                        .setStyle(Styles.SUCCESS)
                                        .setHeading("Well Done")
                                        .setDescription("Order Confirmed")
                                        .setCancelable(false)
                                        .showDialog(new OnDialogButtonClickListener() {
                                            @Override
                                            public void onDismissClicked(Dialog dialog) {
                                                super.onDismissClicked(dialog);
                                            }
                                        });
                            }
                        })
                        .setNegativeButton("No", (dialog, which) -> Toast.makeText(getContext(), "Order Not Confirmed", Toast.LENGTH_SHORT).show()).show();
            }
        });

        updateTotalPrice(); // Call this method to update the total price initially

        return view;
    }
    // Add this method to update the total price
    public void updateTotalPrice() {
        double totalPrice = calculateTotalPrice();
        String formattedTotalPrice = String.format(Locale.getDefault(), "Total: %.2f", totalPrice);
        totalPriceTextView.setText(formattedTotalPrice);
    }


    // Add this method to calculate the total price
    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (CartModel cartItem : cartModels) {
            // Assuming price is stored as a string, convert it to double
            double itemPrice = Double.parseDouble(cartItem.getPrice());
            totalPrice += itemPrice;
        }
        return totalPrice;
    }
}