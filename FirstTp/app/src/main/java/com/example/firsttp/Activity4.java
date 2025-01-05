package com.example.firsttp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    Button back;
    ListView lvs;

    List<HashMap<String, Object>> listeElts;
    ListEtdAdapter adapter;
    HashMap<String, Object> elts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        lvs= findViewById(R.id.listeStds);
        back = findViewById(R.id.back4);

        listeElts= new ArrayList<HashMap<String, Object>>();

        elts= new HashMap<String,Object>();
        elts.put("nom", "RGUIGAT");
        elts.put("prenom", "ANASS");
        elts.put("tel", "0624330555");
        listeElts.add(elts);

        elts= new HashMap<String,Object>();
        elts.put("nom", "RGUIGAT");
        elts.put("prenom", "FAYSSAL");
        elts.put("tel", "0624330555");
        listeElts.add(elts);

        elts= new HashMap<String,Object>();
        elts.put("nom", "RGUIGAT");
        elts.put("prenom", "YOUSSEF");
        elts.put("tel", "0624330555");
        listeElts.add(elts);

        elts= new HashMap<String,Object>();
        elts.put("nom", "RGUIGAT");
        elts.put("prenom", "RIYAD");
        elts.put("tel", "0624330555");
        listeElts.add(elts);

        elts= new HashMap<String,Object>();
        elts.put("nom", "RGUIGAT");
        elts.put("prenom", "HABIB");
        elts.put("tel", "0624330555");
        listeElts.add(elts);

        adapter= new ListEtdAdapter(listeElts, this);

        lvs.setAdapter(adapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
            }
        });

    }
}