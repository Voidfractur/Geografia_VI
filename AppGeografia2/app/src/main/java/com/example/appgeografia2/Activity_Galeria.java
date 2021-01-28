package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Activity_Galeria extends AppCompatActivity {
    ImageView imagenSeleccionada;
    Gallery gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__galeria);
      
    }
}