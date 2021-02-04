package com.example.appgeografia2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseEstados extends SQLiteOpenHelper {


    public BaseEstados(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pregunta(num_pre int primary key ,pregunta_pre text)");
        db.execSQL("create table renglonrespuesta(num_renres int primary key ,respuesta_res text , tipo_res int NOT NULL, num_pre int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
