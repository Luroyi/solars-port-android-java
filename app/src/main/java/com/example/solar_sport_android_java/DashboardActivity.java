package com.example.solar_sport_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Button categoriesButton, statisticsButton, benefitsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);
        topAppBar.setOnMenuItemClickListener(this::onOptionsItemSelected);

        drawerLayout = findViewById(R.id.drawer_layout);

        categoriesButton = findViewById(R.id.categorie_button);
        statisticsButton = findViewById(R.id.statistic_button);
        benefitsButton = findViewById(R.id.benefit_button);

        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCategories();
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatistics();
            }
        });

        benefitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBenefits();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {

            return true;
        } else if (id == R.id.logout) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void openCategories() {
        Toast.makeText(this, "Abriendo Categorias", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(DashboardActivity.this, TerraceCategoriesActivity.class);
        startActivity(intent);
    }

    private void openStatistics() {
        Toast.makeText(this, "Abriendo Estadisticas", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(DashboardActivity.this, ProductionStatisticsActivity.class);
        startActivity(intent);
    }

    private void openBenefits() {
        Toast.makeText(this, "Abriendo Beneficios ", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(DashboardActivity.this, SolarEnergyBenefitsActivity.class);
        startActivity(intent);
    }
}
