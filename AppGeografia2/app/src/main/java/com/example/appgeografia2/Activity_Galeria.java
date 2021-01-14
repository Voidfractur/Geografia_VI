package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Activity_Galeria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__galeria);
        String urlGif = "https://i.pinimg.com/originals/c2/28/48/c2284898b3a5d832d4d16084628bca49.gif";
        //Agregar implementacion Glide dentro de archivo build.gradle.
        ImageView im1 = (ImageView)findViewById(R.id.im1);
        Uri uri = Uri.parse(urlGif);
        Glide.with(getApplicationContext()).load(uri).into(im1);
    }
}