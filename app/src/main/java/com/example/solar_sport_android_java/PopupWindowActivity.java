package com.example.solar_sport_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Asegúrate de importar Log
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.popup_window);

        Button continuar_Button =findViewById(R.id.continuar_button);

        continuar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupWindowActivity.this, ProductionStatisticsActivity.class);

            }
        });


    }
}



