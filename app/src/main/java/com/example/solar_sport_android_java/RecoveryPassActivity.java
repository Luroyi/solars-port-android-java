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

public class RecoveryPassActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button sendCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recovery_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailEditText = findViewById(R.id.email_EditText);
        sendCodeButton = findViewById(R.id.send_code_button);

        sendCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRecoveryCode();
            }
        });
    }

    private void sendRecoveryCode() {
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailEditText.setError("Correo electrónico requerido");
            emailEditText.requestFocus();
            return;
        } else if (!isValidEmail(email)) {
            emailEditText.setError("Correo electrónico no válido");
            emailEditText.requestFocus();
            return;
        }

        Toast.makeText(this, "Código enviado a " + email, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(RecoveryPassActivity.this, ValidateCodeActivity.class);
        startActivity(intent);
    }

    private boolean isValidEmail(String target) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}

