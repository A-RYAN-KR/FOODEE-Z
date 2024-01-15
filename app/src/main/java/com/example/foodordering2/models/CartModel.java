package com.example.foodordering2.models;

public class CartModel {
    int image;
    String name;
    String price;
    String rating;
    private int id;

    public CartModel(int image, String name, String price, String rating , int id) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.id = id ;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
