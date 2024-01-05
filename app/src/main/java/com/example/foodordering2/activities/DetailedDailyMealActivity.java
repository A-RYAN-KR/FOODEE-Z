package com.example.foodordering2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.foodordering2.R;
import com.example.foodordering2.adapters.DetailedDailyAdapter;
import com.example.foodordering2.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;

    // Initialize the cartItems list
    List<DetailedDailyModel> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();

        // Modify the adapter instantiation to pass both lists
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList, cartItems);
        recyclerView.setAdapter(dailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_burger3, "Poha", "", "4.4", "25", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_burger7, "Idli", "", "4.4", "35", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_burger8, "Dhokla", "", "4.4", "35", "10am to 6pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if (type != null && type.equalsIgnoreCase("sweets")) {
            imageView.setImageResource(R.drawable.copy_of_sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fries8, "Butter Scotch Shake", "", "4.4", "40", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fries15, "Chocolate Shake", "", "4.4", "50", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fries29, "Mix Rabdi", "", "4.4", "60", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fries21, "Pista Shake", "", "4.4", "60", "10am to 6pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("lunch")) {
            imageView.setImageResource(R.drawable.copy_of_lunch);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_burger9, "Pulav", "", "4.4", "60", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_pizza1, "Aloo Paratha", "", "4.4", "50", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_sandwitch1, "Veg Grilled Sandwich", "", "4.4", "55", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_pizza2, "Paneer Paratha", "", "4.4", "70", "10am to 6pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if (type != null && type.equalsIgnoreCase("coffee")) {
            imageView.setImageResource(R.drawable.copy_of_coffe);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_image1, "Tea", "", "4.4", "15", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_image2, "Coffee", "", "4.4", "20", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fries12, "Cold Coffee", "", "4.4", "40", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_image3, "Hot Coffee", "", "4.4", "15", "10am to 6pm"));
            dailyAdapter.notifyDataSetChanged();
        }
    }
}
