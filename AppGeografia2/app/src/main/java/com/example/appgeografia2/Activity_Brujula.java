package com.example.appgeografia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Brujula extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mCompass;
    private TextView mTextView;

    private TextView lbl1;
    private TextView lbl2;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__brujula);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mCompass = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mTextView = (TextView) findViewById(R.id.tvSensor);
        lbl1 = findViewById(R.id.lblApuntador);
        lbl2 = findViewById(R.id.lblDireccion);
        image = findViewById(R.id.imageViewDireccion);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        float azimuth = Math.round(event.values[0]);
// The other values provided are:
//  float pitch = event.values[1];
//  float roll = event.values[2];
        mTextView.setText("Grados: " + Float.toString(azimuth));
        cambirDireccion(azimuth);
    }

    @Override
    protected void onPause() {
// Unregister the listener on the onPause() event to preserve battery life;
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mCompass, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void cambirDireccion(Float grado) {
        if (grado >= 0 && grado <= 22 || grado >= 338 && grado <= 360) {
            lbl1.setText("Estas apuntando al Norte");
            lbl2.setText("Norte");
            image.setImageResource(R.drawable.norte);
        } else {
            if (grado >= 293 && grado <= 337) {
                lbl1.setText("Estas apuntando al Noroeste");
                lbl2.setText("Noroeste");
                image.setImageResource(R.drawable.noroeste);
            } else {
                if (grado >= 248 && grado <= 292) {
                    lbl1.setText("Estas apuntando al Oeste");
                    lbl2.setText("Oeste");
                    image.setImageResource(R.drawable.oeste);
                } else {
                    if (grado>=203 && grado<=247) {
                        lbl1.setText("Estas apuntando al Suroeste");
                        lbl2.setText("Suroeste");
                        image.setImageResource(R.drawable.suroeste);
                    }else{
                        if (grado>=158 && grado<=202){
                            lbl1.setText("Estas apuntando al Sur");
                            lbl2.setText("Sur");
                            image.setImageResource(R.drawable.sur);
                        }else{
                           if (grado>=113 && grado<=157){
                               lbl1.setText("Estas apuntando al Sureste");
                               lbl2.setText("Sureste");
                               image.setImageResource(R.drawable.sureste);
                           }else{
                               if (grado>=76 && grado<=112){
                                   lbl1.setText("Estas apuntando al Este");
                                   lbl2.setText("Este");
                                   image.setImageResource(R.drawable.este);
                               }else{
                                   if (grado>=23 && grado<=75){
                                       lbl1.setText("Estas apuntando al Noreste");
                                       lbl2.setText("Noreste");
                                       image.setImageResource(R.drawable.noreste);
                                   }
                               }
                           }
                        }
                    }
                }
            }
        }
    }
}