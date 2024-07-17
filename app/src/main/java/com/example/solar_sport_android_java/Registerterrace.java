package com.example.solar_sport_android_java;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registerterrace extends AppCompatActivity {

    private Spinner categorySpinner, monthSpinner;
    private EditText terraceCodeEditText, energyProducedEditText, savedValueEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_terrace);

        categorySpinner = findViewById(R.id.select_Category_spinner);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);

        monthSpinner = findViewById(R.id.Select_month_spinner);
        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        terraceCodeEditText = findViewById(R.id.terrace_code_edittext);
        energyProducedEditText = findViewById(R.id.amount_of_energy_produced_edittext);
        savedValueEditText = findViewById(R.id.Enter_the_saved_value_edittext);

        registerButton = findViewById(R.id.Register_terrace_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String selectedCategory = categorySpinner.getSelectedItem().toString();
                    String selectedMonth = monthSpinner.getSelectedItem().toString();
                    String terraceCode = terraceCodeEditText.getText().toString().trim();
                    String energyProduced = energyProducedEditText.getText().toString().trim();
                    String savedValue = savedValueEditText.getText().toString().trim();

                if (validateInputs()) {

                    int terraceCodeInt = Integer.parseInt(terraceCode);
                    double energyProducedDouble = Double.parseDouble(energyProduced);
                    double savedValueDouble = Double.parseDouble(savedValue);



                    String message = "Registrando Terraza... ";

                    Toast.makeText(Registerterrace.this, message, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Registerterrace.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean validateInputs() {
        String terraceCode = terraceCodeEditText.getText().toString().trim();
        String energyProduced = energyProducedEditText.getText().toString().trim();
        String savedValue = savedValueEditText.getText().toString().trim();

        return !terraceCode.isEmpty() && !energyProduced.isEmpty() && !savedValue.isEmpty();
    }
}

