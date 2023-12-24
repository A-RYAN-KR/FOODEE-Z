package com.example.foodordering2.ui.MyCart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.adapters.CartAdapter;
import com.example.foodordering2.adapters.HomeVerAdapter;
import com.example.foodordering2.models.CartModel;
import com.example.foodordering2.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;

    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CartModel> cartItems = new ArrayList<>();
        for (HomeVerModel homeItem : HomeVerAdapter.cartItems) {
            cartItems.add(new CartModel(homeItem.getImage(), homeItem.getName(), homeItem.getPrice(), homeItem.getRating()));
        }

        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(cartAdapter);

        return view;
    }
}
