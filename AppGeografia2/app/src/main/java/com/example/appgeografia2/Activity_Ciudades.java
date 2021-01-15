package com.example.appgeografia2;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.speech.RecognizerIntent;
        import android.speech.tts.TextToSpeech;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;
        import java.util.Locale;
        import java.util.Random;

public class Activity_Ciudades extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    private TextView tvMensaje;
    private TextToSpeech textToSpeech;
    private TextView tvMensaje2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ciudades);
        tvMensaje = findViewById(R.id.tvMensaje);
        textToSpeech = new TextToSpeech(this, this);
        tvMensaje2 = findViewById(R.id.tvMensaje2);
    }

    public void hablar(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        startActivityForResult(intent, RECOGNIZE_SPEECH_ACTIVITY);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && data != null) {
                    List<String> coincidencias = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String cadena = coincidencias.get(0);
                    tvMensaje.setText(cadena);

                    textToSpeech.setLanguage(new Locale("es", "MX"));
                    String text = getCiudadPais(cadena);
                    tvMensaje2.setText(text);
                    speak(text);
                }
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(this, "Error por falta de datos o el lenguaje no es soportado", Toast.LENGTH_LONG).show();
        }
    }

    private void speak(String cadena) {
        textToSpeech.speak(cadena, textToSpeech.QUEUE_FLUSH, null);
        textToSpeech.setSpeechRate(0.0f);
        textToSpeech.setPitch(0.0f);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    public String getCiudadPais(String texto) {
        Random r = new Random();
        texto = texto.toLowerCase();
        switch (String.valueOf(texto.charAt(0))) {
            case "a":
                String[] paises = {"Afganistán",
                        "Albania",
                        "Alemania",
                        "Andorra",
                        "Angola",
                        "Anguila",
                        "Antártida",
                        "Arabia Saudita"};
                return paises[r.nextInt(paises.length)];

            case "b":
                String[] paisesb = {"Bahamas",
                        "Bahrein",
                        "Bangladés",
                        "Barbados",
                        "Bélgica",
                        "Belice",
                        "Benín",
                        "Bermudas"};
                return paisesb[r.nextInt(paisesb.length)];
            case "c":
                String[] paisesc = {
                        "Cabo Verde.",
                        " Camboya.",
                        "Camerún.",
                        "Canadá",
                        "Catar.",
                        "Chad.",
                        "Chile.",
                        "China."

                };
                return paisesc[r.nextInt(paisesc.length)];

            case "d":
                String[] paisesd = {
                        "Denmark	Dinamarca", "Danmark",
                        " Djibouti", "Djibouti, Yibuti",
                        "Dominica", "Detroid", "Dublin",

                };
                return paisesd[r.nextInt(paisesd.length)];

            case "e":
                String[] paisese = {
                        "Ecuador.",
                        "Egipto.",
                        "El Salvador.",
                        "Emiratos Árabes Unidos.",
                        "Eritrea.",
                        "Eslovaquia.",
                        "Eslovenia.",
                        "España."

                };
                return paisese[r.nextInt(paisese.length)];

            case "f":
                String[] paisesf = {

                        "Fiji.",
                        "Filipinas.",
                        "Finlandia.",
                        " Francia.",
                };
                return paisesf[r.nextInt(paisesf.length)];

            case "g":
                String[] paisesg = {
                        "Gabón.",
                        " Gambia.",
                        "Georgia.",
                        "Ghana.",
                        "Grecia.",
                        "Guam.",
                        "Guatemala.",
                        " Guayana Francesa."

                };
                return paisesg[r.nextInt(paisesg.length)];

            case "h":
                String[] paisesh = {
                        "Haití",
                        "Holanda",
                        "Honduras",
                        "Hong Kong.",
                        "Hungría."

                };
                return paisesh[r.nextInt(paisesh.length)];

            case "i":
                String[] paisesi = {
                        " India.",
                        "Indonesia.",
                        " Irak.",
                        "Irán.",
                        "Irlanda.",
                        "Islandia.",
                        " Islas Caimán.",
                        " Islas Marshall."
                };
                return paisesi[r.nextInt(paisesi.length)];

            case "j":
                String[] paisesj = {
                        " Jaca.",
                        " Jaén (Ciudad)",
                        "Jaén (Provincia)",
                        "Jalisco.",
                        "Jamaica.",
                        " Japón.",
                        " Jávea-Xàbia."


                };
                return paisesj[r.nextInt(paisesj.length)];

            case "k":
                String[] paisesk = {
                        "Kabul.",
                        " Katmandú",
                        "Kazajistán.",
                        " Kenia.",
                        "Ketama.",
                        "Kiev.",
                        "Kinépolis.",
                        "Kirguizistan."

                };
                return paisesk[r.nextInt(paisesk.length)];

            case "l":
                String[] paisesl = {
                        "Laos.",
                        "Lesoto, ",
                        "Letonia.",
                        "Líbano.",
                        "Liberia.",
                        " Libia.",
                        "Liechtenstein.",
                        " Lituania."

                };
                return paisesl[r.nextInt(paisesl.length)];
            case "m":
                String[] paisesm = {
                        "Macao.",
                        "Macedonia.",
                        "Madagascar.",
                        " Malasia.",
                        "Malaui.",
                        "Maldivas.",
                        "Mali.",
                        "Malta."

                };
                return paisesm[r.nextInt(paisesm.length)];

            case "n":
                String[] paisesn = {
                        "Namibia.",
                        "Nauru.",
                        " Nepal.",
                        "Nicaragua.",
                        "Níger.",
                        "Nigeria.",
                        "Noruega.",
                        " Nueva Zelanda."

                };
                return paisesn[r.nextInt(paisesn.length)];

            case "ñ":
                String[] paisesnn = {
                        "Ñalemania.",
                        " Ño she.",
                        "Ñorquinco.",
                        " ñandubay.",
                        "ñandubaysal.",
                        "ñemby.",
                        " ñipas."

                };
                return paisesnn[r.nextInt(paisesnn.length)];

            case "o":
                String[] paiseso = {
                        "Oaxaca.",
                        "Ohio.",
                        "Oklahoma.",
                        "Ontario.",
                        "Oregon.",
                        "Orlando.",
                        " Oslo.",
                        "Ottawa."

                };
                return paiseso[r.nextInt(paiseso.length)];

            case "p":
                String[] paisesp = {
                        " Pakistán.",
                        " Palau.",
                        "Panamá.",
                        "Papúa Nueva Guinea.",
                        "Paraguay.",
                        "Perú.",
                        " Polinesia Francesa.",
                        "Polonia."

                };
                return paisesp[r.nextInt(paisesp.length)];

            case "q":
                String[] paisesq = {
                        "Qatar.",
                        "Quebec.",
                        "Quito."

                };
                return paisesq[r.nextInt(paisesq.length)];

            case "r":
                String[] paisesr = {
                        " Reino Unido.",
                        "República Centroafricana.",
                        "República Checa.",
                        "República de Sudán del Sur.",
                        " República del Congo.",
                        "República Democrática del Congo.",
                        "República Dominicana."

                };
                return paisesr[r.nextInt(paisesr.length)];

            case "s":
                String[] paisess = {
                        "   Samoa.",
                        "Samoa Americana.",
                        "San Bartolomé.",
                        "San Cristobal y Nevis.",
                        "San Marino.",
                        "San Martín.",
                        "San Pedro y Miquelón.",
                        "San Vicente y las Granadinas."

                };
                return paisess[r.nextInt(paisess.length)];

            case "t":
                String[] paisest = {
                        "Tailandia.",
                        " Taiwán.",
                        " Tanzania.",
                        " Tayikistán.",
                        " Timor Oriental.",
                        "Togo.",
                        "Tokelau.",
                        "Trinidad y Tobago."

                };
                return paisest[r.nextInt(paisest.length)];

            case "u":
                String[] paisesu = {
                        " Úbeda.",
                        " Ucrania.",
                        "Uganda.",
                        "URSS.",
                        " Uruguay.",
                        " Utah.",
                        "Utrera."

                };
                return paisesu[r.nextInt(paisesu.length)];

            case "v":
                String[] paisesv = {
                        "Vanuatu.",
                        "Vaticano.",
                        " Venezuela.",
                        "Vietnam."

                };
                return paisesv[r.nextInt(paisesv.length)];

            case "x":
                String[] paisesx = {
                        "Xalapa.",
                        "Xaimen.",
                        " Xianyang.",
                        "xining."

                };
                return paisesx[r.nextInt(paisesx.length)];

            case "y":
                String[] paisesy = {
                        "Yemen.",
                        "Yibuti."

                };
                return paisesy[r.nextInt(paisesy.length)];

            case "z":
                String[] paisesz = {
                        "Zambia.",
                        "Zaire.",
                        "Zimbabue."

                };
                return paisesz[r.nextInt(paisesz.length)];

        }
        return "";
    }

}