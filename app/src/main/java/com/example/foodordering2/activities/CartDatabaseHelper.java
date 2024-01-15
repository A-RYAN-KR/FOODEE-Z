package com.example.foodordering2.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.foodordering2.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CartDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cart_database";
    private static final int DATABASE_VERSION = 1;

    public CartDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table to store cart items
        String createTableQuery = "CREATE TABLE cart_items ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT, "
                + "price TEXT, "
                + "rating TEXT, "
                + "image INTEGER)";
        db.execSQL(createTableQuery);
    }

    public List<CartModel> getAllCartItems() {
        List<CartModel> cartItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("cart_items", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                int image = cursor.getInt(cursor.getColumnIndex("image"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String rating = cursor.getString(cursor.getColumnIndex("rating"));

                cartItems.add(new CartModel(image, name, price, rating, id));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return cartItems;
    }

    public boolean removeItem(int itemId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete("cart_items", "id=?", new String[]{String.valueOf(itemId)});
        db.close();
        return affectedRows > 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades if needed
    }
}
