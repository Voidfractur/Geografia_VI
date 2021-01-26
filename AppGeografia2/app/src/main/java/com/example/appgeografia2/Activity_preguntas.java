package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Activity_preguntas extends AppCompatActivity {
private Frapregunta2 frapregunta2;
private Fragmento_Pregunta1 fragmento_pregunta1;
private Blank_pregunta3 pregunta3;
private Fragment_pregunta4 fragment_pregunta4;
private int contador;
private Fragment_PreguntaFinal fragment_preguntaFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        contador = 0;
        frapregunta2 = new Frapregunta2();
        fragmento_pregunta1 = new Fragmento_Pregunta1();
        pregunta3 = new Blank_pregunta3();
        fragment_pregunta4 = new Fragment_pregunta4();
        fragment_preguntaFinal = new Fragment_PreguntaFinal();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmento_pregunta1).commit();
        contador++;
    }
public void cambiarFragment(View view){
    switch (contador){
        case 1:
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, frapregunta2).commit();
            contador++;
            break;
        case 2:
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, pregunta3).commit();
            contador++;
            break;
        case 3:
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment_pregunta4).commit();
            contador++;
            break;
        case 4:
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment_preguntaFinal).commit();
            contador =0;
            break;

    }
}

}