package com.example.foodordering2.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodordering2.R;
import com.example.foodordering2.databinding.ActivityNavigationBinding;
import com.example.foodordering2.ui.MyCart.MyCartFragment;
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
        Bundle args = new Bundle();
        args.putString("username", getIntent().getStringExtra("username"));
        args.putString("name", getIntent().getStringExtra("name"));
        args.putString("email", getIntent().getStringExtra("email"));
        fragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    public void onBackPressed() {
        showExitConfirmationDialog();
    }
    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // If the user clicks "Yes", exit the app
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // If the user clicks "No", close the dialog
                        dialog.cancel();
                    }
                });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}