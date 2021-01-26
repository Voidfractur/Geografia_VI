package com.example.appgeografia2;

        import androidx.appcompat.app.AppCompatActivity;
        import android.app.Activity;
        import android.content.pm.ActivityInfo;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.os.Bundle;
        import android.speech.tts.TextToSpeech;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;
        import java.util.Locale;

public class Activity_Acelerometro extends AppCompatActivity implements SensorEventListener {

    private long last_update = 0, last_movement = 0;
    private float prevX = 0, prevY = 0, prevZ=0;
    private float curX=0,curY=0,curZ=0;
    private Fragment1 fragment1;
    private Fragmento2 fragmento2;
    private Fragmento3 fragmento3;
    private int cont;

    private TextToSpeech tts;
    private TextToSpeech.OnInitListener ttsListener = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status==TextToSpeech.SUCCESS){
                tts.setLanguage(Locale.getDefault());
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__acelerometro);
        fragment1 = new Fragment1();
        fragmento2 = new Fragmento2();
        fragmento3 = new Fragmento3();
        cont = 1;
        tts = new TextToSpeech(this,ttsListener);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragment1).commit();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        synchronized (this){
            long current_time = event.timestamp;
            String salida="";
            curX=event.values[0];
            curY=event.values[1];
            curZ=event.values[2];
            if (prevX==0 && prevY==0 && prevZ==0){
                last_update=current_time;
                last_movement=current_time;
                prevX=curX;
                prevY=curY;
                prevZ=curZ;
            }
            long time_difference = current_time - last_update;
            if (time_difference>0){
                float movement = Math.abs((curX+curY+curZ)-(prevX-prevY-prevZ))/time_difference;
                int limit = 1500;
                float min_movement = 1E-6f;
                if (movement>min_movement){
                    if (current_time - last_movement >= limit){
                        if (prevX<curX) salida="Derecha";
                        if (curX<prevX) salida = "Izquierda";
                        tts.speak(salida,TextToSpeech.QUEUE_FLUSH,null);
                        //TextView orientacion = findViewById(R.id.tvOrientacion);
                        //orientacion.setText(salida);
                        //Toast.makeText(getApplicationContext(),"Hay movimiento de "+movement,Toast.LENGTH_SHORT).show();
                    }
                    last_movement=current_time;
                }
                prevX=curX;
                prevY=curY;
                prevZ=curZ;
                last_update=current_time;
            }
            //((TextView) findViewById(R.id.tvX)).setText("Acelerometro X: "+curX);
           // ((TextView) findViewById(R.id.tvY)).setText("Acelerometro Y: "+curY);
           //((TextView) findViewById(R.id.tvZ)).setText("Acelerometro Z: "+curZ);
if (cont==1){
    if (salida.equals("Derecha")){
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmento2).commit();
        cont++;
    }
}else{
    if (cont==2){
        if (salida.equals("Derecha")){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmento3).commit();
            cont++;
        }else{
            if (salida.equals("Izquierda")){
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment1).commit();
                cont--;
            }
        }
    }else{
        if (cont==3){
            if (salida.equals("Izquierda")){
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmento2).commit();
                cont--;
            }
        }
    }
}
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size()>0){
            sm.registerListener(this,sensors.get(0),SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.unregisterListener(this);
        super.onStop();
    }
}