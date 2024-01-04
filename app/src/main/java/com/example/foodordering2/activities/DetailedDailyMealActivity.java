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
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fav1, "Breakfast", "description", "4.4", "40", "10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fav2, "Breakfast", "description", "4.4", "40", "10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_fav3, "Breakfast", "description", "4.4", "40", "10 to 9"));
            dailyAdapter.notifyDataSetChanged();
        }

        if (type != null && type.equalsIgnoreCase("sweets")) {
            imageView.setImageResource(R.drawable.copy_of_sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s1, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s2, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s4, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_sweets, "Sweet", "description", "4.4", "40", "10am to 9am"));
            dailyAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("lunch")) {
            imageView.setImageResource(R.drawable.copy_of_sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s1, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s2, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s4, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_sweets, "Sweet", "description", "4.4", "40", "10am to 9am"));
            dailyAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("dinner")) {
            imageView.setImageResource(R.drawable.copy_of_sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s1, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s2, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s4, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_sweets, "Sweet", "description", "4.4", "40", "10am to 9am"));
            dailyAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("coffee")) {
            imageView.setImageResource(R.drawable.copy_of_sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s1, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s2, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_s4, "Sweet", "description", "4.4", "40", "10am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.copy_of_sweets, "Sweet", "description", "4.4", "40", "10am to 9am"));
            dailyAdapter.notifyDataSetChanged();
        }
    }
}
