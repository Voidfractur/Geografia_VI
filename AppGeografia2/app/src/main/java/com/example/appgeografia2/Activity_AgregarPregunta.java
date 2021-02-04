package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Activity_AgregarPregunta extends AppCompatActivity {
    private EditText etPregunta, etRes1, etRes2, etRes3, etRes4;
    private Switch sRes1, sRes2, sRes3, sRes4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__agregar_pregunta);

        etPregunta = findViewById(R.id.EditTxtPregunta);
        etRes1 = findViewById(R.id.editTxtRes1);
        etRes2 = findViewById(R.id.editTxtRes2);
        etRes3 = findViewById(R.id.editTxtRes3);
        etRes4 = findViewById(R.id.editTxtRes4);

        sRes1 = findViewById(R.id.switchres1);
        sRes2 = findViewById(R.id.switchres2);
        sRes3 = findViewById(R.id.switchres3);
        sRes4 = findViewById(R.id.switchres4);

    }

    public void guardar(View view) {
        BaseEstados admin = new BaseEstados(this, "Estados", null, 1);
        SQLiteDatabase baseDeDatosEscribir = admin.getWritableDatabase();

        String pregunta = etPregunta.getText().toString();
        String res1 = etRes1.getText().toString();
        String res2 = etPregunta.getText().toString();
        String res3 = etPregunta.getText().toString();
        String res4 = etPregunta.getText().toString();

        if (!pregunta.isEmpty() && !res1.isEmpty() && !res2.isEmpty() && !res3.isEmpty() && !res4.isEmpty()) {

            Cursor fila0 = baseDeDatosEscribir.rawQuery("select max(num_pre) from pregunta", null);
            int numeros = fila0.getColumnIndex("max(num_pre)");
            String num = "0";
            try {
                num = fila0.getString(numeros);
            } catch (RuntimeException e) {

                num = "0";
            }

            ContentValues registro2 = new ContentValues();
            registro2.put("num_pre", num);
            registro2.put("pregunta_pre", pregunta);
            baseDeDatosEscribir.insert("pregunta", null, registro2);
            Cursor fila = baseDeDatosEscribir.rawQuery("select max(num_pre) from pregunta", null);

            fila0 = baseDeDatosEscribir.rawQuery("select max(num_renres) from renglonrespuesta", null);
            ContentValues registro3 = new ContentValues();
            int a = 0;
            String numeroPregunta="0";
            try {
                numeroPregunta = fila.getString(0);
            }catch (RuntimeException e){
                numeroPregunta = "0";
            }
            try {
                a = fila0.getString(0).isEmpty() ? 0 : fila0.getInt(0) + 1;
            } catch (RuntimeException e) {
                a = 0;
            }
            registro3.put("num_renres",a);
            registro3.put("respuesta_res", res1);
            registro3.put("tipo_res", sRes1.isChecked() ? 1 : 0);
            registro3.put("num_pre", numeroPregunta);
            baseDeDatosEscribir.insert("renglonrespuesta", null, registro3);

            fila0 = baseDeDatosEscribir.rawQuery("select max(num_renres) from renglonrespuesta", null);
            try {
                a = fila0.getString(0).isEmpty() ? 0 : fila0.getInt(0) + 1;
            }catch (RuntimeException e){
                a++;
            }
            ContentValues registro4 = new ContentValues();
            registro4.put("num_renres", a);
            registro4.put("respuesta_res", res2);
            registro4.put("tipo_res", sRes2.isChecked() ? 1 : 0);
            registro4.put("num_pre", numeroPregunta);
            baseDeDatosEscribir.insert("renglonrespuesta", null, registro4);

            fila0 = baseDeDatosEscribir.rawQuery("select max(num_renres) from renglonrespuesta", null);
            try {
                a = fila0.getString(0).isEmpty() ? 0 : fila0.getInt(0) + 1;
            }catch (RuntimeException e){
                a++;
            }
            ContentValues registro5 = new ContentValues();
            registro5.put("num_renres", a);
            registro5.put("respuesta_res", res3);
            registro5.put("tipo_res", sRes3.isChecked() ? 1 : 0);
            registro5.put("num_pre", numeroPregunta);
            baseDeDatosEscribir.insert("renglonrespuesta", null, registro5);

            fila0 = baseDeDatosEscribir.rawQuery("select max(num_renres) from renglonrespuesta", null);
            try {
                a = fila0.getString(0).isEmpty() ? 0 : fila0.getInt(0) + 1;
            }catch (RuntimeException e){
                a++;
            }
            ContentValues registro6 = new ContentValues();
            registro6.put("num_renres", a);
            registro6.put("respuesta_res", res4);
            registro6.put("tipo_res", sRes4.isChecked() ? 1 : 0);
            registro6.put("num_pre", numeroPregunta);
            baseDeDatosEscribir.insert("renglonrespuesta", null, registro6);


            baseDeDatosEscribir.close();
            baseDeDatosEscribir.close();
            etPregunta.setText("");
            etRes1.setText("");
            etRes2.setText("");
            etRes3.setText("");
            etRes4.setText("");
            sRes4.setChecked(false);
            sRes3.setChecked(false);
            sRes2.setChecked(false);
            sRes1.setChecked(false);
        } else {
            Toast.makeText(this, "LLENE TODOS LOS CAMPOS!", Toast.LENGTH_LONG);
        }
    }
}