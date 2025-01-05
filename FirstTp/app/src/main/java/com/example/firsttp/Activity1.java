package com.example.firsttp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnSub, btnMult, btnDiv, back;
    EditText number1, number2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        // Initialize buttons and other UI elements
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        number1 = findViewById(R.id.Number1);
        number2 = findViewById(R.id.Number2);
        result = findViewById(R.id.result);
        back = findViewById(R.id.back1);

        // Set click listeners for buttons
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private int getIntFromEditText(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir un nombre", Toast.LENGTH_SHORT).show();
            return -1;
        }
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrée invalide", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back1) {
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        int num1 = getIntFromEditText(number1);
        int num2 = getIntFromEditText(number2);


        if (num1 == -1 || num2 == -1) {
            return;
        }


        if (view.getId() == R.id.btnAdd) {
            result.setText("Réponse = " + (num1 + num2));
        } else if (view.getId() == R.id.btnSub) {
            result.setText("Réponse = " + (num1 - num2));
        } else if (view.getId() == R.id.btnMult) {
            result.setText("Réponse = " + (num1 * num2));
        } else if (view.getId() == R.id.btnDiv) {
            if (num2 != 0) {
                result.setText("Réponse = " + (num1 / num2));
            } else {
                result.setText("Pas de division par zéro");
            }
        }

    }
}
