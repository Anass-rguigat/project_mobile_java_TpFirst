package com.example.firsttp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    Spinner sp;
    boolean invalid = false;
    String Colector = "";
    TextView txtUserInfo;
    EditText UserName, UserPassword, UserContact, UserComment;
    Button SubmitSave, back;
    RadioButton Malebtn, Femalbtn;
    CheckBox html, css, php;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        sp = findViewById(R.id.SpCountry);
        UserName = findViewById(R.id.userName);
        UserPassword = findViewById(R.id.userPassword);
        UserContact = findViewById(R.id.userContact);
        UserComment = findViewById(R.id.usercomment);
        txtUserInfo = findViewById(R.id.txtUserInfo);

        Malebtn = findViewById(R.id.Male);
        Femalbtn = findViewById(R.id.Female);
        html = findViewById(R.id.HTML);
        css = findViewById(R.id.CSS);
        php = findViewById(R.id.PHP);
        SubmitSave = findViewById(R.id.btnSubmit);
        back = findViewById(R.id.back2);

        // Back button click listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
            }
        });



        String[] countries = getResources().getStringArray(R.array.listePays);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);




        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String Pascode = UserPassword.getText().toString();
                String contact = UserContact.getText().toString();
                String comment = UserComment.getText().toString();

                // Validation checks
                if (name.isEmpty()) {
                    Toast.makeText(Activity2.this, "Please fill the name field", Toast.LENGTH_SHORT).show();
                } else if (Pascode.isEmpty()) {
                    Toast.makeText(Activity2.this, "Please fill the password field", Toast.LENGTH_SHORT).show();
                } else if (contact.isEmpty()) {
                    Toast.makeText(Activity2.this, "Please fill the Contact field", Toast.LENGTH_SHORT).show();
                } else if (comment.isEmpty()) {
                    Toast.makeText(Activity2.this, "Please fill the Comment field", Toast.LENGTH_SHORT).show();
                } else {
                    // Clear the Colector string first to avoid appending previous data
                    Colector = "";
                    Colector += name + "\n";
                    Colector += Pascode + "\n";
                    Colector += contact + "\n";

                    // Collect gender information
                    if (Malebtn.isChecked()) {
                        Colector += "Gender: Male\n";
                    } else if (Femalbtn.isChecked()) {
                        Colector += "Gender: Female\n";
                    }

                    // Collect skills
                    if (html.isChecked()) {
                        Colector += "HTML" + "\n";
                        if (css.isChecked()) {
                            Colector += "CSS" + "\n";
                        }
                        if (php.isChecked()) {
                            Colector += "PHP" + "\n";
                        }
                    }

                    // Collect country from the spinner (added only when submitting)
                    String selectedCountry = sp.getSelectedItem().toString();
                    Colector += "Country: " + selectedCountry + "\n";

                    Colector += comment + "\n";

                    // Displaying the collected data in the TextView
                    txtUserInfo.setText("User Info:\n" + Colector);
                }
            }
        });




    }
}
