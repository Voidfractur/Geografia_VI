package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class Activity_Ubicacion extends AppCompatActivity {
    private TextView lblLatitud;
    private TextView lblLongitud;
    private TextView lblAltitud;
    private TextView lblMar;
    private TextView lblEstacion;
    private TextView lblCDMX;
    private TextView lblNucleo;
    private double altitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ubicacion);
        lblLatitud = findViewById(R.id.lblLatitud);
        lblLongitud = findViewById(R.id.lblLongitud);
        lblAltitud = findViewById(R.id.lblAltitud);
        lblMar = findViewById(R.id.lblNivelDelMar);
        lblEstacion = findViewById(R.id.lblEstacion);
        lblCDMX = findViewById(R.id.lblCDMX);
        lblNucleo = findViewById(R.id.lblNucleo);
        getDatosGeologicos();
        String[] a = lblAltitud.getText().toString().replace(" ","").split(":");
         altitude = Double.valueOf(a[1]);
        actualizarNivelDelMar();
        actualizarDistanciaEstacion();
        actualizarDistanciaCDMX();
        actualizarDistanciaNucleo();
    }

    public void getDatosGeologicos() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "No se tiene acceso al gps", Toast.LENGTH_LONG).show();
            return;
        }
        //Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);


        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        double altitude = location.getAltitude();

        actualizarCoordenadas(altitude, longitude, latitude);
    }

    public void actualizarCoordenadas(double altitude, double longitude, double latitude) {
        lblAltitud.setText("Tu altitud es: ".concat(String.valueOf(altitude)));
        lblLongitud.setText("Tu longitud es: ".concat(String.valueOf(longitude)));
        lblLatitud.setText("Tu latitud es: ".concat(String.valueOf(latitude)));
        this.altitude = altitude;
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarCoordenadas(location.getAltitude(),location.getLongitude(),location.getLatitude());
        }
    };

    public void actualizarNivelDelMar(){
        if (altitude<1){
            lblMar.setText("Estás al nivel del mar");
        }else{
            lblMar.setText("Estás a".concat(String.valueOf(altitude)).concat(" metros sobre el nivel del mar"));
        }
    }
    public void actualizarDistanciaEstacion(){
        double Estacion = 340000;
            lblEstacion.setText("Estás a ".concat(String.valueOf(Estacion-altitude)).concat(" metros debajo de la Estación Espacial Internacional"));
    }
    public void actualizarDistanciaCDMX(){
        double cDMX = 2250;
        if (altitude<cDMX)
            lblCDMX.setText("Estás a ".concat(String.valueOf(cDMX-altitude)).concat(" metros debajo de la Ciudad de México"));
        else
            lblCDMX.setText("Estás a ".concat(String.valueOf(altitude-cDMX)).concat(" metros sobre la Ciudad de México"));
    }
    public void actualizarDistanciaNucleo(){
        double nucleo = 3000;
        lblNucleo.setText("Estás a ".concat(String.valueOf(nucleo+altitude)).concat(" metros sobre el nucleo de la tierra"));
    }
}