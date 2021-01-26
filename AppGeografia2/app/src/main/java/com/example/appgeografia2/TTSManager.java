package com.example.appgeografia2;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TTSManager {
    private TextToSpeech aTts = null;
    private boolean isLoaded = false;

    public void init(Context context) {
        try {
            aTts = new TextToSpeech(context, onInitListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TextToSpeech.OnInitListener onInitListener = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            Locale spanish = new Locale("es","ES");
            if (status==TextToSpeech.SUCCESS){
                int result = aTts.setLanguage(spanish);
                isLoaded = true;

                if (result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                    Log.e("error","Este lenguaje no esta disponible");
                }
            }else{
                Log.e("Error","Fallo al iniciar");
            }
        }
    };

    public void shutdown(){
        aTts.shutdown();
    }
    public void addQueue(String text){
        if (isLoaded){
            aTts.speak(text,TextToSpeech.QUEUE_ADD,null);
        }else{
            Log.e("Error","Tts no inisializada");
        }
    }

    public void initQueue(String text){
        if (isLoaded){
            aTts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }else{
            Log.e("Error","Tts no inisializada");
        }
    }
}
