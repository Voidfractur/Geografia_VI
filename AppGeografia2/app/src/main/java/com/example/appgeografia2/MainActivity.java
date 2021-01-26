package com.example.appgeografia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private final int REQUEST_ACCESS_FINE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new  String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_ACCESS_FINE);
    }

    //Ubicacion
    public void acrivityUbicacion(View view){
        Intent ubicacion = new Intent(getApplicationContext(),Activity_Ubicacion.class);
        startActivity(ubicacion);
    }
    public void acrivityBrujula(View view){
        Intent brujula = new Intent(getApplicationContext(),Activity_Brujula.class);
        startActivity(brujula);
    }
    public void acrivityGaleria(View view){
        Intent galeria = new Intent(getApplicationContext(),Activity_Galeria.class);
        startActivity(galeria);
    }
    public void activityLecciones(View view){
        Intent lecciones = new Intent(getApplicationContext(),Activity_Lecciones.class);
        startActivity(lecciones);
    }
    public void acrivityRompecabezas(View view){
        Intent rompecabezas = new Intent(getApplicationContext(), Activity_Rompecabezas.class);
        startActivity(rompecabezas);
    }
    public void acrivityPreguntas(View view){
        Intent preguntas = new Intent(getApplicationContext(), Activity_preguntas.class);
        startActivity(preguntas);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_ACCESS_FINE){
            if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permiso concedido",Toast.LENGTH_LONG);
            }else{
                Toast.makeText(this,"Permission denied ",Toast.LENGTH_SHORT).show();
            }
        }
    }
}