package com.example.solar_sport_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreatePasswordActivity extends AppCompatActivity {
    private EditText contraseñaEditText;
    private EditText contraseñareEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.create_a_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        contraseñaEditText = findViewById(R.id.contraseña_edittext);
        contraseñareEditText = findViewById(R.id.repetir_contraseña_edittext);

        Button loginSubmitButton = findViewById(R.id.crear_contraseña_button);
        loginSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();

            }
        });
    }
    private void validateInputs() {
        String password = contraseñaEditText.getText().toString().trim();
        String password_re = contraseñaEditText.getText().toString().trim();


        if (password.isEmpty()) {
            contraseñaEditText.setError("Contraseña requerida");
            contraseñaEditText.requestFocus();
            return;
        }

        if (password_re.isEmpty()) {
            contraseñareEditText.setError("Confirmar contraseña requerida");
            contraseñareEditText.requestFocus();
            return;
        }

        Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(CreatePasswordActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}