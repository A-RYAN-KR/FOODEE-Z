package com.example.foodordering2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodordering2.NavigationActivity;
import com.example.foodordering2.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void register(View view){
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));

    }

    public void mainActivity(View view){
        startActivity(new Intent(LoginActivity.this, NavigationActivity.class));

    }

}