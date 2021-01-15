package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Lecciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lecciones);
    }

    public void acrivityRompecabezas(View view){
        Intent rompecabezas = new Intent(getApplicationContext(), Activity_Rompecabezas.class);
        startActivity(rompecabezas);
    }
    public void acrivityCiudades(View view){
        Intent ciudades = new Intent(getApplicationContext(), Activity_Ciudades.class);
        startActivity(ciudades);
    }
}