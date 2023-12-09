package com.example.foodordering2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodordering2.databinding.ActivityNavigationBinding;
import com.example.foodordering2.ui.MyCartFragment;
import com.example.foodordering2.ui.dailymeal.DailyMealFragment;
import com.example.foodordering2.ui.favourite.FavouriteFragment;
import com.example.foodordering2.ui.home.HomeFragment;

public class NavigationActivity extends AppCompatActivity {

    ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.dailyMeal) {
                replaceFragment(new DailyMealFragment());
            } else if (item.getItemId() == R.id.favourite) {
                replaceFragment(new FavouriteFragment());
            } else if (item.getItemId() == R.id.myCart) {
                replaceFragment(new MyCartFragment());
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}