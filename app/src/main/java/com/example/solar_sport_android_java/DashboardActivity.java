package com.example.solar_sport_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.CarouselSnapHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView carouselRecyclerView;
    private List<Integer> images = new ArrayList<>();

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        carouselRecyclerView = findViewById(R.id.carousel_recycler_view);
        setupCarousel();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);


    }

    private void setupCarousel() {
        images.add(R.drawable.imagen1);
        images.add(R.drawable.imagen2);
        images.add(R.drawable.imagen3);
        images.add(R.drawable.imagen4);
        images.add(R.drawable.imagen5);

        carouselRecyclerView.setLayoutManager(new CarouselLayoutManager());
        CarouselAdapter adapter = new CarouselAdapter(this, images);
        carouselRecyclerView.setAdapter(adapter);

        CarouselSnapHelper snapHelper = new CarouselSnapHelper();
        snapHelper.attachToRecyclerView(carouselRecyclerView);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.nav_home) {
                startActivity(new Intent(DashboardActivity.this, DashboardActivity.class));
            } else if (itemId == R.id.nav_profile) {
                // Handle profile action
            } else if (itemId == R.id.nav_settings) {
                // Handle settings action
            } else if (itemId == R.id.nav_logout) {
                // Handle logout action
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }
}
