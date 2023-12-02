package com.example.foodordering2.models;

public class DailyMealModel {

    int image;
    String name;
    String discount;
    String description;
    String type;

    public DailyMealModel(int image, String name, String discount, String description, String type) {
        this.image = image;
        this.name = name;
        this.discount = discount;
        this.description = description;
        this.type = type;
    }

    public DailyMealModel(int copyOfLunch, String lunch, String s, String descriptionDescription) {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
