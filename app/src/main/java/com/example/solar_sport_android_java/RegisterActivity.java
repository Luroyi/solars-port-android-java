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

public class RegisterActivity extends AppCompatActivity {

    private EditText usuario_edittext;
    private EditText nombre_edittext;
    private EditText contraseña_edittext;

    private EditText contraseñare_edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre_edittext = findViewById(R.id.nombre_edittext);
        usuario_edittext = findViewById(R.id.usuario_edittext);
        contraseña_edittext = findViewById(R.id.contraseña_edittext);
        contraseñare_edittext = findViewById(R.id.contraseñare_edittext);

        Button registerSubmitButton = findViewById(R.id.registrarse_button);
        registerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();
            }
        });
    }

    private void validateInputs() {
        String name = nombre_edittext.getText().toString().trim();
        String email = usuario_edittext.getText().toString().trim();
        String password = contraseña_edittext.getText().toString().trim();
        String password_re = contraseñare_edittext.getText().toString().trim();

        if (name.isEmpty()) {
            nombre_edittext.setError("Nombre requerido");
            nombre_edittext.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            usuario_edittext.setError("Correo electrónico requerido");
            usuario_edittext.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            contraseña_edittext.setError("Contraseña requerida");
            contraseña_edittext.requestFocus();
            return;
        }

        if (password_re.isEmpty()) {
            contraseñare_edittext.setError("Repetir contraseña requerida");
            contraseñare_edittext.requestFocus();
            return;
        }

        Toast.makeText(this, "Registrando...", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
}