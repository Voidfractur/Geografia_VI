package com.example.appgeografia2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.Arrays;
        import java.util.List;
import java.util.Locale;

public class Activity_Capitales extends AppCompatActivity  implements TextToSpeech.OnInitListener{
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    private ListView lista;
    private List<String> datos;
    private List<String> capitales;
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__capitales);
        textToSpeech = new TextToSpeech(this, this);
        lista = findViewById(R.id.listNoneChoice);
        datos = Arrays.asList(getResources().getStringArray(R.array.entidades_federativas));
        capitales = Arrays.asList(getResources().getStringArray(R.array.capitales));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),parent.getAdapter().getItem(position).toString(),Toast.LENGTH_LONG).show();
                speak("La capital de ".concat(parent.getAdapter().getItem(position).toString()).concat("es ").concat(capitales.get(getPosicion(parent.getAdapter().getItem(position).toString()))));
            }
        });
    }

    public int getPosicion(String text){
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(text)){
                return i;
            }
        }
        return 0;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && data != null) {
                    List<String> coincidencias = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String cadena = coincidencias.get(0);
                    textToSpeech.setLanguage(new Locale("es", "MX"));
                    speak(cadena);
                }
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(this, "Error por falta de datos o el lenguaje no es soportado", Toast.LENGTH_LONG).show();
        }
    }

    private void speak(String cadena) {
        textToSpeech.speak(cadena, textToSpeech.QUEUE_FLUSH, null);
        textToSpeech.setSpeechRate(0.0f);
        textToSpeech.setPitch(0.0f);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

}