package com.example.foodordering2.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.adapters.DailyMealAdapter;
import com.example.foodordering2.models.DailyMealModel;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {

RecyclerView recyclerView;
List<DailyMealModel> dailyMealModels;
DailyMealAdapter dailyMealAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.daily_meal_fragment,container,false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.copy_of_breakfast,"Breakfast","30 % OFF","Type","Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.copy_of_lunch,"Lunch","20 % OFF","Type","Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.copy_of_dinner,"Dinner","30 % OFF","Type","Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.copy_of_sweets,"Sweets","40 % OFF","Type","Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffe,"Coffee","50 % OFF","Type","Description Description"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();

        return root;
    }

}