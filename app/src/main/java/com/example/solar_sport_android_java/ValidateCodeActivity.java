package com.example.solar_sport_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ValidateCodeActivity extends AppCompatActivity {
    private Button sendCodeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.validate_code);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sendCodeButton = findViewById(R.id.send_code_button);

        sendCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ValidateCodeActivity.this, CreatePasswordActivity.class);
                startActivity(intent);
            }

        });
    }
    private void reSendRecoveryCode() {
        String email = "yi********97@gmail.com";
        Toast.makeText(this, "Reenviando código a " + email, Toast.LENGTH_LONG).show();
        return;

    }
}

