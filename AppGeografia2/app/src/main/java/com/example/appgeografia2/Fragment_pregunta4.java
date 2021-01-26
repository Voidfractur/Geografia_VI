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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_pregunta4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_pregunta4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_pregunta4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_pregunta4.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_pregunta4 newInstance(String param1, String param2) {
        Fragment_pregunta4 fragment = new Fragment_pregunta4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

   // private TextView puntaje;
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
        View view = inflater.inflate(R.layout.fragment_pregunta4, container, false);
        btn1 = view.findViewById(R.id.btn1pre4);
        btn2 = view.findViewById(R.id.btn2pre4);
        btn3 = view.findViewById(R.id.btn3pre4);
        btn4 = view.findViewById(R.id.btn4pre4);
        lblestado = view.findViewById(R.id.lblEstadopre4);
        cont = view.findViewById(R.id.contenedorpre4);
        btn1.setOnClickListener(this::respuestaCorrecta);
        btn2.setOnClickListener(this::respuestaIncorrecta);
        btn3.setOnClickListener(this::respuestaIncorrecta);
        btn4.setOnClickListener(this::respuestaIncorrecta);
        return view;
    }
    public void respuestaCorrecta(View view) {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        cont.setBackgroundColor(Color.parseColor("#277da1"));
        lblestado.setText("Correcto!");
        //puntaje.setText(String.valueOf(Integer.valueOf(puntaje.getText().toString())+1));
        //puntaje.setTextColor(Color.parseColor("#277da1"));
    }

    public void respuestaIncorrecta(View view) {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        cont.setBackgroundColor(Color.parseColor("#f94144"));
        lblestado.setText("Incorrecto!");
        //puntaje.setTextColor(Color.parseColor("#f94144"));
    }
}