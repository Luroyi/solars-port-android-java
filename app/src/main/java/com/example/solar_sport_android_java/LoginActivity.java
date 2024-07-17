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

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private EditText usuarioEditText;
    private EditText contraseñaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuarioEditText = findViewById(R.id.usuario_edittext);
        contraseñaEditText = findViewById(R.id.contraseña_edittext);

        Button loginSubmitButton = findViewById(R.id.iniciar_sesion_button);
        Button registerGoButton = findViewById(R.id.registrarse_button);

        loginSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();

            }
        });

        registerGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

     }

    public void onForgetPasswordClicked(View view) {
        Intent intent = new Intent(this, RecoveryPassActivity.class);
        startActivity(intent);
    }

    private void validateInputs() {
        String email = usuarioEditText.getText().toString().trim();
        String password = contraseñaEditText.getText().toString().trim();

        if (email.isEmpty()) {
            usuarioEditText.setError("Correo electrónico requerido");
            usuarioEditText.requestFocus();
            return;
        } else if (!isValidEmail(email)) {
            usuarioEditText.setError("Correo electrónico no válido");
            usuarioEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            contraseñaEditText.setError("Contraseña requerida");
            contraseñaEditText.requestFocus();
            return;
        }
        else if (!isValidPassword(password)) {
        contraseñaEditText.setError("La contraseña debe tener al menos 6 caracteres");
        contraseñaEditText.requestFocus();
        return;

        }

        Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
    private boolean isValidEmail(String target) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }
    private boolean isValidPassword(String password){
        return password.length()>= 6;

    }
}

