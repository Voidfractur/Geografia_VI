package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MapaMexico extends AppCompatActivity {

    TTSManager ttsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_mexico);
        ttsManager = new TTSManager();
        ttsManager.init(this);
    }

    public void btnChiuahua(View view) {
        ttsManager.initQueue("La Capital de chihuahua es chihuahua");
    }

    public void btnMorelia(View view) {
        ttsManager.initQueue("La Capital de Michoacan es Morelia");
    }
    public void btnAguascalientes(View view) {
        ttsManager.initQueue("La Capital de Aguascalientes es Aguascalientes");
    }
    public void btnBajaCalifornia(View view) {
        ttsManager.initQueue("La Capital de Baja California es Mexicali");
    }
    public void btnBajaCaliforniaSur(View view) {
        ttsManager.initQueue("La Capital de Baja California Sur es La Paz");
    }
    public void btnCampeche(View view) {
        ttsManager.initQueue("La Capital de Campeche es San Francisco de Campeche");
    }
    public void btnChiapas(View view) {
        ttsManager.initQueue("La Capital de Chiapas es Tuxtla Gutiérrez");
    }
    public void btnCoahuila(View view) {
        ttsManager.initQueue("La Capital de Coahuila de Zaragoza es Saltillo");
    }
    public void btnColima(View view) {
        ttsManager.initQueue("La Capital de Colima es Colima");
    }
    public void btnDurango(View view) {
        ttsManager.initQueue("La Capital de Durango es Victoria de Durango");
    }
    public void btnGuanajuato(View view) {
        ttsManager.initQueue("La Capital de Guanajuato es Guanajuato");
    }
    public void btnGuerrero(View view) {
        ttsManager.initQueue("La Capital de Guerrero es Chilpancingo de los Bravo");
    }
    public void btnHidalgo(View view) {
        ttsManager.initQueue("La Capital de Hidalgo es Pachuca de Soto");
    }
    public void btnJalisco(View view) {
        ttsManager.initQueue("La Capital de Jalisco es Guadalajara");
    }
    public void btnMexico(View view) {
        ttsManager.initQueue("La Capital de México es Toluca de Lerdo");
    }
    public void btnMorelos(View view) {
        ttsManager.initQueue("La Capital de Michoacan es Cuernavaca");
    }
    public void btnNayarit(View view) {
        ttsManager.initQueue("La Capital de Nayarit es Tepic");
    }
    public void btnNuevoLeon(View view) {
        ttsManager.initQueue("La Capital de Nuevo León es Monterrey");
    }
    public void btnOaxaca(View view) {
        ttsManager.initQueue("La Capital de Oaxaca es Oaxaca de Juárez");
    }
    public void btnPuebla(View view) {
        ttsManager.initQueue("La Capital de Puebla es Puebla de Zaragoza");
    }
    public void btnQueretaro(View view) {
        ttsManager.initQueue("La Capital de Querétaro es Santiago de Querétaro");
    }
    public void btnQuintanaRoo(View view) {
        ttsManager.initQueue("La Capital de Quintana Roo es Chetumal");
    }
    public void SanLuis(View view) {
        ttsManager.initQueue("La Capital de San Luis Potosí es San Luis Potosí");
    }
    public void btnSinaloa(View view) {
        ttsManager.initQueue("La Capital de Sinaloa es Culiacán Rosales");
    }
    public void btnSonora(View view) {
        ttsManager.initQueue("La Capital de Sonora es Hermosillo");
    }
    public void btnTabasco(View view) {
        ttsManager.initQueue("La Capital de Tabasco es Villahermosa");
    }
    public void btnTamaulipas(View view) {
        ttsManager.initQueue("La Capital de Tamaulipas es Ciudad Victoria");
    }
    public void btnTlaxcala(View view) {
        ttsManager.initQueue("La Capital de Tlaxcala es Tlaxcala de Xicohténcatl");
    }
    public void btnVeracruz(View view) {
        ttsManager.initQueue("La Capital de Veracruz es Xalapa-Enríquez");
    }
    public void btnYucatan(View view) {
        ttsManager.initQueue("La Capital de Yucatán es Mérida");
    }
    public void btnZacatecas(View view) {
        ttsManager.initQueue("La Capital de Zacatecas es Zacatecas");
    }
    public void btncdmx(View view) {
        ttsManager.initQueue("La Capital de Mexico es Cidad de mexioc");
    }

}