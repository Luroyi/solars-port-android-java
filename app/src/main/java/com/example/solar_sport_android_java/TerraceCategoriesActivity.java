package com.example.solar_sport_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;

public class TerraceCategoriesActivity extends AppCompatActivity {
    private Button stadiumsButton;
    private Button gymButton;
    private Button sportsCourtsButton;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.terrace_categories);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);
        topAppBar.setOnMenuItemClickListener(this::onOptionsItemSelected);

        drawerLayout = findViewById(R.id.drawer_layout);
        stadiumsButton = findViewById(R.id.stadiums_button);
        gymButton = findViewById(R.id.gym_button);
        sportsCourtsButton = findViewById(R.id.sports_courts_button);

        // Configure onClickListeners for buttons
        stadiumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TerraceCategoriesActivity.this, "Botón de Estadios presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TerraceCategoriesActivity.this, Registerterrace.class);
                startActivity(intent);
            }
        });

        gymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TerraceCategoriesActivity.this, "Botón de Gimnasios presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TerraceCategoriesActivity.this, Registerterrace.class);
                startActivity(intent);
            }
        });

        sportsCourtsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TerraceCategoriesActivity.this, "Botón de Pistas deportivas presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TerraceCategoriesActivity.this, Registerterrace.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {
            // Handle profile action
            Toast.makeText(this, "Perfil seleccionado", Toast.LENGTH_SHORT).show();
            // Aquí puedes añadir el intent para navegar a la actividad de perfil si existe
            return true;
        } else if (id == R.id.logout) {
            // Handle logout action
            Toast.makeText(this, "Cerrar sesión seleccionado", Toast.LENGTH_SHORT).show();
            // Aquí puedes añadir el intent para navegar a la actividad de logout si existe
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
