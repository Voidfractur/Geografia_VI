package com.example.appgeografia2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Frapregunta2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "puntaje";

    // TODO: Rename and change types of parameters
    private int puntaje;
    private Blank_pregunta3 pregunta3;

    public Frapregunta2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pregunta3 = new Blank_pregunta3();
        if (getArguments() != null) {
            puntaje = getArguments().getInt(ARG_PARAM1);
        }
    }

    //private TextView puntaje2;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView lblestado;
    private LinearLayout cont;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta2, container, false);
        btn1 = view.findViewById(R.id.btn1pre2);
        btn2 = view.findViewById(R.id.btn2pre2);
        btn3 = view.findViewById(R.id.btn3pre2);
        btn4 = view.findViewById(R.id.btn4pre2);
        cont= view.findViewById(R.id.contenedorpre2);
        lblestado = view.findViewById(R.id.lblestadopre2);
        //puntaje2 = view.findViewById(R.id.lblpuntaje);
        btn1.setOnClickListener(this::respuestaIncorrecta);
        btn2.setOnClickListener(this::respuestaIncorrecta);
        btn3.setOnClickListener(this::respuestaIncorrecta);
        btn4.setOnClickListener(this::respuestaCorrecta);
        return view;
    }
    public void respuestaCorrecta(View view) {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        cont.setBackgroundColor(Color.parseColor("#277da1"));
        lblestado.setText("Correcto");
       // puntaje2.setText(String.valueOf(Integer.valueOf(puntaje2.getText().toString())+1));
        //puntaje2.setTextColor(Color.parseColor("#277da1"));
    }

    public void respuestaIncorrecta(View view) {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        cont.setBackgroundColor(Color.parseColor("#f94144"));
        lblestado.setText("Incorrecto");
       // puntaje2.setTextColor(Color.parseColor("#f94144"));
    }
}