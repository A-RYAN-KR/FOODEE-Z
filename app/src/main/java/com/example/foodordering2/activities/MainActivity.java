package com.example.foodordering2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodordering2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view){
        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));

    }

    public void login(View view){
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}