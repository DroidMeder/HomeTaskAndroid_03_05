package com.example.hometaskandroid_03_05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static boolean isCountriesFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.container,
                new MainFragment()).commit();
    }
    @Override
    public void onBackPressed() {
        if (isCountriesFragment) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
            isCountriesFragment = true;
        }
    }
}