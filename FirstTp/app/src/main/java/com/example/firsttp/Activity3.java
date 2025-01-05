package com.example.firsttp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    Button back;
    ListView lf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        lf= findViewById(R.id.listeFruits);
        back = findViewById(R.id.back3);

        List<String> fruits= new ArrayList<>();
        for(int i=0; i<25;i++){
            fruits.add("Orange");
        }
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                getApplicationContext() ,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                fruits
        );
        lf.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
            }
        });

    }
}