package com.example.foodordering2.activities;

import java.util.ArrayList;
import java.util.List;

public class CartManager<T> {
    private static CartManager instance;
    private List<T> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<T> getCartItems() {
        return cartItems;
    }

    public void addToCart(T item) {
        cartItems.add(item);
    }
}