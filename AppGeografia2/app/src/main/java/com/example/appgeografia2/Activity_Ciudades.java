package com.example.appgeografia2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Activity_Ciudades extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    private TextView tvMensaje;
    private TextToSpeech textToSpeech;
    private TextView tvMensaje2;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ciudades);
        tvMensaje = findViewById(R.id.tvMensaje);
        textToSpeech = new TextToSpeech(this, this);
        tvMensaje2 = findViewById(R.id.tvMensaje2);
        imageView = findViewById(R.id.ImageCiudad);
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
    public void goToUrl (View view) {
        Uri uriUrl = Uri.parse("https://www.google.com/search?q=".concat(tvMensaje2.getText().toString()));
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
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
                String[] paises2 = {"https://media.istockphoto.com/photos/kabul-afghanistan-skyline-cityscape-picture-id1053174372?k=6&m=1053174372&s=170667a&w=0&h=eYxsPO0JGOUWM-xRXrwbZCKRcUbf24NXuct95qJaNnc=",
                        "https://ep01.epimg.net/elviajero/imagenes/2018/11/01/actualidad/1541084447_838298_1542213438_noticia_normal.jpg",
                        "https://assets.entrepreneur.com/content/3x2/2000/20180420152441-frankfurt.jpeg?width=700&crop=2:1",
                        "https://c.files.bbci.co.uk/9927/production/_110470293_andorra1.jpg",
                        "https://www.kayak.com.co/rimg/dimg/ec/9d/01dfcc84-city-9951-172c0bb1d2b.jpg?width=400&height=300&xhint=1953&yhint=905&crop=true",
                        "https://upload.wikimedia.org/wikipedia/commons/4/43/Anguilla-aerial_view_western_portion.jpg",
                        "https://elordenmundial.com/wp-content/uploads/2013/08/Antartida-marina-Brasil-portada.jpg",
                        "https://i2.wp.com/noticieros.televisa.com/wp-content/uploads/2017/12/arabia-saudita-intercepta-un-misil-balistico-en-riad-lanzado-por-los-rebeldes-huties-del-yemen-cuyo-objetivo-era-el-palacio-real-de-al-yamama-reuters.jpg?resize=1045%2C602&quality=95&ssl=1"};
                int a = r.nextInt(paises.length);
                Picasso.get()
                        .load(paises2[a])
                        .into(imageView);
                return paises[a];

            case "b":
                String[] paisesb2 = {"https://www.sun-sentinel.com/resizer/O1iap8JiRPuv6eeEKVROmKsMHHE=/1200x0/top/cloudfront-us-east-1.images.arcpublishing.com/tronc/4H6DFFP7GZFPVMEQRBSQAIKGZE.jpg",
                        "https://i0.wp.com/www.hisour.com/wp-content/uploads/2018/05/Architecture-of-Bahrain.jpg?fit=960%2C640&ssl=1",
                        "https://cdn.mapamundial.co/paisajes/bangladesh/Templo-de-Shiva-del-complejo-de-Puthia-el-mas-grande-de-bangladesh-2.jpg",
                        "https://hablemosdeislas.com/wp-content/uploads/2018/06/Barbados-38.jpg",
                        "https://www.hola.com/imagenes/viajes/20190314138965/lugares-bonitos-belgica/0-658-681/lugares-mas-bonitos-belgica-t.jpg",
                        "https://lh3.googleusercontent.com/proxy/guAEzMjcrdG9GhlAd_YQxdGtruPn5Tx1PLNdr3nm-rMHGGYOa4jPkXnN-MiZFEKAazbN-6Jjv8fXddD3d7cbp5gToiyN6wTIUmRVUhodcPQem9Fp0U7MXVCLtOCwZpU4DZl9CszO1YzYwDX7h0DQ3lU7zli88IX926hNoeNvIw",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvgnulJVrd7w6viwmp3J2Sv7GPMP-OlIRH8A&usqp=CAU",
                        "https://cdn.pixabay.com/photo/2017/06/18/23/03/bermuda-2417536_960_720.jpg"};
                String[] paisesb = {"Bahamas",
                        "Bahrein",
                        "Bangladés",
                        "Barbados",
                        "Bélgica",
                        "Belice",
                        "Benín",
                        "Bermudas"};
                int b = r.nextInt(paisesb.length);
                Picasso.get()
                        .load(paisesb2[b])
                        .into(imageView);
                return paisesb[b];
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

                String[] paisesc2 = {
                        "https://diariodeavisos.elespanol.com/wp-content/uploads/2017/12/Cultivos-en-terrazas-web.jpg",
                        "https://content.skyscnr.com/m/0d04713c0776acbd/original/GettyImages-154291114_doc.jpg",
                        "https://static1.evcdn.net/images/reduction/164221_w-850_h-400_q-100_m-crop.jpg",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR31AKpckLhDF8ZWW83RFJk8Yj1d3fyS4u8Gg&usqp=CAU",
                        "https://www.bautrip.com/images/what-to-visit/pearl-qatar.jpg",
                        "https://static3lonelyplanetes.cdnstatics.com/sites/default/files/styles/max_1300x1300/public/fotos/Chad_Sahara_shutterstock_115589677_sunsinger_Shutterstock.JPG?itok=RU-l_qT3",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_VHDAf0LVhKlYzQN9E8eISGpAFQFcgIuHUA&usqp=CAU",
                        "https://i.pinimg.com/originals/96/b9/42/96b942aaf73a03cefbe08635a968754f.jpg"

                };
                int c = r.nextInt(paisesc.length);
                Picasso.get()
                        .load(paisesc2[c])
                        .into(imageView);
                return paisesc[c];

            case "d":
                String[] paisesd = {
                        "Dinamarca",
                        "Danmark",
                        " Djibouti",
                        "Dominica",
                        "Detroid",
                        "Dublin"
                };
                String[] paisesd2 = {
                        "https://viajes.nationalgeographic.com.es/medio/2015/04/08/castillo_de_kronborg_dinamarca_1000x640.jpg",
                        "https://i.pinimg.com/originals/43/cc/f4/43ccf423ca0c25a8b848b01f17bcd9e1.jpg",
                        "https://elviajero.elpais.com/elviajero/imagenes/2018/01/30/actualidad/1517331998_659720_1517409568_sumario_grande.jpg",
                        "https://www.laregion.es/asset/zoomcrop,1366,800,center,center//media/laregion/images/2016/12/01/2016120112523831455.jpg",
                        "https://static9.depositphotos.com/1685868/1189/i/950/depositphotos_11899132-stock-photo-detroit-michigan.jpg",
                        "https://images4.bovpg.net/r/back/es/sale/58da3e400b9f0o.jpg"
                };
                int d = r.nextInt(paisesd.length);
                Picasso.get()
                        .load(paisesd2[d])
                        .into(imageView);
                return paisesd[d];

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

                String[] paisese2 = {
                        "https://aws.traveler.es/prod/designs/v1/assets/1200x628/127962.jpg.",
                        "https://blogs.uned.es/sindistancia/wp-content/uploads/sites/83/2018/06/AvilaEgipto.jpg",
                        "https://i.pinimg.com/originals/6b/e3/ab/6be3ab32a2721fee90159f61830caa49.jpg",
                        "https://cloudfront-us-east-1.images.arcpublishing.com/semana/UDW7DX3NCJH6XNJPLQYMRP23EI.jpg",
                        "https://img.ev.mu/images/regions/65/960x640/65.jpg",
                        "https://diariodeunturista.com/wp-content/uploads/2016/09/Paisaje-en-Eslovaquia.jpg",
                        "https://img.ev.mu/images/articles/960x/817869.jpg",
                        "https://d1ez3020z2uu9b.cloudfront.net/imagecache/blog-photos/17607_Fill_800_800.jpg"

                };
                int e = r.nextInt(paisese.length);
                Picasso.get()
                        .load(paisese2[e])
                        .into(imageView);
                return paisese[e];

            case "f":
                String[] paisesf = {

                        "Fiji.",
                        "Filipinas.",
                        "Finlandia.",
                        " Francia.",
                };
                String[] paisesf2 = {

                        "https://sfo2.digitaloceanspaces.com/elpaiscr/2019/05/Paisaje-de-Islas-Fiji.-Redes.jpg",
                        "https://www.absolutviajes.com/wp-content/uploads/2011/05/filipinas2.jpg",
                        "https://viajes.nationalgeographic.com.es/medio/2018/10/04/igloos-view-from-air-kakslauttanen-jpg_48cab796_1600x1064.jpg",
                        "https://img.ev.mu/images/articles/960x/813620.jpg",
                };
                int f = r.nextInt(paisesf.length);
                Picasso.get()
                        .load(paisesf2[f])
                        .into(imageView);
                return paisesf[f];

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
                String[] paisesg2 = {
                        "https://static1lonelyplanetes.cdnstatics.com/sites/default/files/styles/max_1300x1300/public/fotos/gabon_portada_shutterstock_471054356_oleg_puchkov_shutterstock.jpg?itok=QUtCQbiv.",
                        "https://i.pinimg.com/originals/77/72/84/77728470f2cc797f3f9c8a514764ed53.jpg",
                        "https://img1.viajar.elperiodico.com/8d/29/05/tiblisi-650x407.jpg",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Volta_River_X-Landscape.jpg/790px-Volta_River_X-Landscape.jpg",
                        "https://cdn0.matrimonios.cl/img_g/articulos-a-fotos/luna-de-miel/grecia/r10_2x_atenas.jpg",
                        "https://ustraveler.com.mx/wp-content/uploads/2015/09/shutterstock_264081536.jpg",
                        "https://www.prensalibre.com/wp-content/uploads/2018/12/c866fb2c-b264-4bf6-8525-c2e0335e032d.jpg?quality=82",
                        "https://www.madrimasd.org/blogs/universo/wp-content/blogs.dir/42/files/818/o_Cataratas%20Kaieteur%20Guyana.jpg"

                };
                int g = r.nextInt(paisesg.length);
                Picasso.get()
                        .load(paisesg2[g])
                        .into(imageView);
                return paisesg[g];

            case "h":
                String[] paisesh = {
                        "Haití",
                        "Holanda",
                        "Honduras",
                        "Hong Kong.",
                        "Hungría."

                };

                String[] paisesh2 = {
                        "https://d1bvpoagx8hqbg.cloudfront.net/originals/paisajes-muy-coloridos-b7c4330ead756e3f73df49fc262d6566.jpg",
                        "https://lavozdelmuro.net/wp-content/uploads/2015/07/paisaje-holanda-11-1.png",
                        "https://i.pinimg.com/originals/83/6b/66/836b662d2af15efa2631e5bd83d7229d.jpg",
                        "https://sobrechina.com/wp-content/uploads/bahiavictoriahongkong274963.jpg",
                        "https://www.nuevatribuna.es/media/nuevatribuna/images/2017/03/04//2017030412194978630.jpg."

                };
                int h = r.nextInt(paisesh.length);
                Picasso.get()
                        .load(paisesh2[h])
                        .into(imageView);
                return paisesh[h];

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

                String[] paisesi2 = {
                        " https://astelus.com/wp-content/viajes/paisajes-de-la-india-taj-mahal-650x366.jpg",
                        "https://sonorastar.com/wp-content/uploads/2019/08/sebastian-pena-lambarri-U_i6h9Y50wQ-unsplash-e1572819732131-1.jpg",
                        "https://i.pinimg.com/originals/05/d3/9c/05d39c2895a7a71acd7c2aa6b16594fb.jpg",
                        "https://assets.arquitecturaviva.com/assets/uploads/articulos/61282/alvarez-diestro-iran-1.jpg?h=5b82f7ea",
                        "https://aws.traveler.es/prod/designs/v1/assets/1000x663/20433.jpg",
                        "https://www.nadiuviatges.com/wp-content/uploads/2018/02/mejores-paisajes-de-islandia-cascada-Godafoss.jpg",
                        "https://a.travel-assets.com/findyours-php/viewfinder/images/res40/74000/74916-Grand-Cayman.jpg",
                        "https://www.culturaviajera.org/wp-content/uploads/2017/09/9b2e13cf2fd29fc89086579f3b926057-1024x500.jpg"
                };
                int i = r.nextInt(paisesi.length);
                Picasso.get()
                        .load(paisesi2[i])
                        .into(imageView);
                return paisesi[i];

            case "j":
                String[] paisesj = {
                        " Jaca.",
                        " Jaén (Ciudad)",

                        "Jalisco.",
                        "Jamaica.",
                        " Japón.",
                        " Jávea-Xàbia."
                };
                String[] paisesj2 = {
                        "https://www.jaca.es/sites/default/files/imagecache/imagenAmpliada/imagenes/viaducto.jpg",
                        "https://www.elplural.com/uploads/s1/89/27/ja-c3-a9n-foto-junta-de-andaluc-c3-ada.jpeg",

                        "https://www.viajesmacaro.com/wp-content/uploads/2016/12/Tequila_Jalisco.jpg",
                        "https://hotels1.cdn.iberostar.com/uploads/image/37580/crops/16:9/720/image.jpeg",
                        "https://tipsparatuviaje.com/wp-content/uploads/2018/08/monte-fuji.jpg",
                        "https://images.squarespace-cdn.com/content/v1/5a86b05bcf81e0af04936cc7/1532443010072-AVXRHHNF9XSWNQU0YN7C/ke17ZwdGBToddI8pDm48kPqQfq0L3n3wpHIsRapTfg8UqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYxCRW4BPu10St3TBAUQYVKczo5Zn4xktlpMsMj-QlHXeMfNK6GwvtVkYEWiR8XAPyD3GfLCe_DXOSC_YcAacWL_/javeaweb.jpg?format=1500w"
                };
                int j = r.nextInt(paisesj.length);
                Picasso.get()
                        .load(paisesj2[j])
                        .into(imageView);
                return paisesj[j];

            case "k":
                String[] paisesk = {
                        "Kabul.",
                        " Katmandú",
                        "Kazajistán.",
                        " Kenia.",
                        "Ketama.",
                        "Kiev.",

                        "Kirguizistan."

                };
                String[] paisesk2 = {
                        "https://media.istockphoto.com/photos/kabul-afghanistan-skyline-cityscape-picture-id1053174372?k=6&m=1053174372&s=170667a&w=0&h=eYxsPO0JGOUWM-xRXrwbZCKRcUbf24NXuct95qJaNnc=",
                        "https://www.lasociedadgeografica.com/blog/uploads/2015/11/Valle-Kathmandu-cMike-Behnken.jpg",
                        "https://www.turismokazajistan.es/wp-content/uploads/2017/06/altai-kazajstan.jpg",
                        "https://1000sitiosquever.com/public/images/supima-525-parque-nacional-masai-mara-.WC8.png",
                        "https://pevgrow.com/blog/wp-content/uploads/2032/11/The-children-of-the-Rif-Sensi-Seeds-blog.jpg",
                        "https://www.aviatur.com/source/redes/panoramica-de-kiev.jpg",

                        "https://www.taranna.com/docs/kirguistan-002-1-642x370.jpg"

                };
                int k = r.nextInt(paisesk.length);
                Picasso.get()
                        .load(paisesk2[k])
                        .into(imageView);
                return paisesk[k];

            case "l":
                String[] paisesl = {
                        "Líbano.",
                        "Liberia.",
                        " Libia.",
                        "Liechtenstein.",
                        " Lituania."
                };
                String[] paisesl2 = {
                        "https://revistatravelmanager.com/wp-content/uploads/2018/08/L%C3%ADbano-Pa%C3%ADs-de-contrastes-1.jpg",
                        "https://blogapi.uber.com/wp-content/uploads/2019/08/Explora-estos-5-lugares-para-visitar-en-Liberia-Guanacaste-1024x512.png",
                        "https://i2.wp.com/evemuseografia.com/wp-content/uploads/2015/09/02-leptis-magna-ancient-city-670.jpg?fit=670%2C448&ssl=1",
                        "https://mundoxdescubrir.com/wp-content/uploads/2017/11/Liechtestein-Suiza-Alpes--1024x582.jpg",
                        "https://viajes.nationalgeographic.com.es/medio/2015/01/07/hemis_2008403_500x333.jpg"
                };
                int l = r.nextInt(paisesl.length);
                Picasso.get()
                        .load(paisesl2[l])
                        .into(imageView);
                return paisesl[l];
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

                String[] paisesm2 = {
                        "https://lh3.googleusercontent.com/proxy/hYFPpTc6pKqCovR6q6568ExTEzE3YSY48cm7gVkHP9_qwEpbmA7PIWy9GDxkPw9ANQNq5IrG83TJb0Hm6of7IWeRLORGYrvwaCv4TvhOvPP1f_4xL1CDjkQHDkG_entgvoLm",
                        "https://ep01.epimg.net/elviajero/imagenes/2020/01/27/actualidad/1580149342_514021_1580213378_noticia_normal.jpg",
                        "https://www.nuevatribuna.es/media/nuevatribuna/images/2018/07/30//2018073017145721980.jpg",
                        "https://media.tacdn.com/media/attractions-splice-spp-674x446/06/71/3b/f1.jpg",
                        "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2017/06/01/14963298122675.jpg",
                        "https://crucerosturisticos.com/files/2014/01/Islas-Maldivas.jpg",
                        "https://www.nuevatribuna.es/media//nuevatribuna/images/2012/11/02/2012110212323238492.jpg",
                        "https://aws.traveler.es/prod/designs/v1/assets/1000x513/40544.jpg"
                };
                int m = r.nextInt(paisesm.length);
                Picasso.get()
                        .load(paisesm2[m])
                        .into(imageView);
                return paisesm[m];

            case "n":
                String[] paisesn = {
                        "Nicaragua.",
                        "Níger.",
                        "Nigeria.",
                        "Noruega.",
                        " Nueva Zelanda."
                };
                String[] paisesn2 = {
                        "https://vuelosbaratosbaratos.com/wp-content/uploads/2014/02/isletas-de-granada-nicaragua.jpg",
                        "https://www.svenlucaworld.com/wp-content/uploads/2018/10/niamey3-1170x605.jpg",
                        "https://images.adsttc.com/media/images/5f35/9efe/b357/657e/fc00/0072/large_jpg/Lagos_Nigeria.jpg?1597349616",
                        "https://cadenaser00.epimg.net/ser/imagenes/2015/02/19/viajes/1424329220_569935_1476973928_noticia_normal.jpg",
                        "https://www.cuentafacto.es/wp-content/uploads/2018/09/pueblo-queenstown-paisajes.jpg"
                };
                int n = r.nextInt(paisesn.length);
                Picasso.get()
                        .load(paisesn2[n])
                        .into(imageView);
                return paisesn[n];

            case "ñ":
                String[] paisesnn = {
                        "Ñorquinco.",
                        "ñandubaysal."
                };
                String[] paisesnn2 = {
                        "https://i.pinimg.com/originals/79/d3/b4/79d3b41067cada57e0fa6ddda39f5674.jpg",
                        "https://i.pinimg.com/originals/15/0f/fd/150ffd1cdce254def97b45ced4c3f45c.jpg"
                };
                int nn = r.nextInt(paisesnn.length);
                Picasso.get()
                        .load(paisesnn2[nn])
                        .into(imageView);
                return paisesnn[nn];

            case "o":
                String[] paiseso = {
                        "Ohio.",
                        "Orlando.",
                        "Ottawa."

                };
                String[] paiseso2 = {
                        "https://learn.casasnuevasaqui.com/wp-content/uploads/2020/05/cleveland-ohio.jpg",
                        "https://lh3.googleusercontent.com/proxy/GXnz2GrjZTejd2Hm2MfnhfnuDgD70hDyIJy-No9rseRXOtOaGqD15oLXJtRuO2Gw3r2KtMBkrefvmbgdmWQWxQSgjQSKBTkMRUcivxDePa52kOltUMuUvom9IffkSxKeltmj6i76cA9IBfeQ_yOJYkM",
                        "https://i1.wp.com/padondenosvamos.com/wp-content/uploads/2018/08/ALMY_CP9E2D_OttawaParlimentHill.jpg?fit=1068%2C534&ssl=1"

                };
                int o = r.nextInt(paiseso.length);
                Picasso.get()
                        .load(paiseso2[o])
                        .into(imageView);
                return paiseso[o];

            case "p":
                String[] paisesp = {
                        "Palau.",
                        "Panamá.",
                        "Papúa Nueva Guinea.",
                };
                String[] paisesp2 = {
                        "https://www.fotonostra.com/albums/paraisos/fotos/islaspalau.jpg",
                        "https://la.network/wp-content/uploads/2020/03/PANAMA-PAISAJE.jpg",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPjBCoGG9AT-Y3id-I8v4srPyNmyeZzDfaZw&usqp=CAU",
                };
                int p = r.nextInt(paisesp.length);
                Picasso.get()
                        .load(paisesp2[p])
                        .into(imageView);
                return paisesp[p];

            case "q":
                String[] paisesq = {
                        "Qatar.",
                        "Quebec.",
                        "Quito."
                };
                String[] paisesq2 = {
                        "https://cdn.shortpixel.ai/spai/w_1003+q_lossy+ex_1+ret_img+to_webp/https://megaricos.com/wp-content/uploads/2029/07/Doha_Qatar.jpg",
                        "https://www.ngenespanol.com/wp-content/uploads/2018/08/Los-colores-de-otono-en-Quebec.jpg",
                        "https://www.clave.com.ec/wp-content/uploads/2019/10/MG_2293.jpg"
                };
                int q = r.nextInt(paisesq.length);
                Picasso.get()
                        .load(paisesq2[q])
                        .into(imageView);
                return paisesq[q];

            case "r":
                String[] paisesr = {
                        "Reino Unido.",
                        "República Democrática del Congo.",
                        "República Dominicana."

                };

                String[] paisesr2 = {
                        "https://sportslanguage.com/storage/uploads/mfMOM7xmgyqETrBraYe2B9FBPFiwhF4R9GJeTRjE.jpeg",
                        "https://s2.eestatic.com/2018/09/25/blog_del_suscriptor/Opinion-Blog_del_suscriptor-Blog_del_suscriptor_340727077_98612365_1024x576.jpg",
                        "https://i.pinimg.com/236x/74/b7/7a/74b77aca5dfc46d3594abed36d24f5fc--cap-cana-punta-cana.jpg"

                };
                int rr = r.nextInt(paisesr.length);
                Picasso.get()
                        .load(paisesr2[rr])
                        .into(imageView);
                return paisesr[rr];

            case "s":
                String[] paisess = {
                        "Samoa.",
                        "Samoa Americana.",
                        "San Bartolomé."

                };
                String[] paisess2 = {
                        "https://hablemosdeislas.com/wp-content/uploads/2018/07/Samoa-11.jpg",
                        "https://www.wallpaperup.com/uploads/wallpapers/2017/10/01/1100225/85480a070abd35e9bbcee8ce41a0ea56-700.jpg",
                        "https://dam.ngenespanol.com/wp-content/uploads/2019/06/St-Barthelemy-isla-de-san-bartolome-2.png"

                };
                int s = r.nextInt(paisess.length);
                Picasso.get()
                        .load(paisess2[s])
                        .into(imageView);
                return paisess[s];

            case "t":
                String[] paisest = {
                        "Tailandia.",
                        "Taiwán.",
                        "Tanzania."

                };
                String[] paisest2 = {
                        "https://cld-2.vpackage.net/4012/paisajes2.jpg",
                        "https://previews.123rf.com/images/nicholashan/nicholashan1412/nicholashan141200036/34567167-imagen-del-paisaje-hermoso-taiw%C3%A1n-para-el-uso-de-fines-adv-u-otros.jpg",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1lfWrS0TbsCMDByb61gNErEgBDLhyrH_iEg&usqp=CAU"

                };
                int t = r.nextInt(paisest.length);
                Picasso.get()
                        .load(paisest2[t])
                        .into(imageView);
                return paisest[t];

            case "u":
                String[] paisesu = {
                        " Ucrania.",
                        "Uganda.",
                        " Uruguay."
                };
                String[] paisesu2= {
                        "https://i.ytimg.com/vi/2ty1qM1f1Z0/sddefault.jpg",
                        "https://www.mundoexpedicion.es/wp-content/uploads/2014/09/Uganda-6-1030x733.jpg",
                        "https://i.pinimg.com/originals/91/17/08/91170829d297a272f8f6645ff121bdb7.jpg"
                };
                int u = r.nextInt(paisesu.length);
                Picasso.get()
                        .load(paisesu2[u])
                        .into(imageView);
                return paisesu[u];

            case "v":
                String[] paisesv = {
                        "Vaticano.",
                        " Venezuela.",
                        "Vietnam."
                };

                String[] paisesv2 = {
                        "https://besthqwallpapers.com/Uploads/2-11-2017/26800/thumb2-saint-peters-basilica-4k-vatican-nightscapes-italian-landmarks.jpg",
                        "https://miviaje.com/wp-content/uploads/2018/06/rio-de-janeiro-768x512.jpg",
                        "https://image.vovworld.vn/w500/Uploaded/vovworld/reyxqqskxq/2014_06_26/trangan.jpg"
                };
                int v = r.nextInt(paisesv.length);
                Picasso.get()
                        .load(paisesv2[v])
                        .into(imageView);
                return paisesv[v];

            case "x":
                String[] paisesx = {
                        "Xalapa.",
                        " Xianyang.",
                        "xining."
                };
                String[] paisesx2 = {
                        "https://pbs.twimg.com/media/DDca891VwAAyv9V.jpg",
                        "https://mediaim.expedia.com/destination/1/e18dafc31be2807d6c96be2183cdada5.jpg",
                        "https://lh3.googleusercontent.com/proxy/Prsc4G71X55TJUV2n93T3cD7NsKY0yDYwNJNpewHYYeIQ43hu87RxGZec_xbefvCI5TeZrfAyeMFNKKlC8aBZu9zQj2UGBlfnVuS35UnqRwELCVuWjvWPSPf9lrI4WtCYpGd"
                };
                int x = r.nextInt(paisesx.length);
                Picasso.get()
                        .load(paisesx2[x])
                        .into(imageView);
                return paisesx[x];

            case "y":
                String[] paisesy = {
                        "Yemen.",
                        "Yibuti."
                };
                String[] paisesy2 = {
                        "https://i.pinimg.com/originals/42/6f/d9/426fd9f15cfbd5af19c32162abffd84c.jpg",
                        "https://img2.rtve.es/imagenes/nomadas-yibuti-desierto-mil-formas-29-02-20/1582916684236.jpg"
                };
                int y = r.nextInt(paisesy.length);
                Picasso.get()
                        .load(paisesy2[y])
                        .into(imageView);
                return paisesy[y];

            case "z":
                String[] paisesz = {
                        "Zambia.",
                        "Zaire.",
                        "Zimbabue."
                };
                String[] paisesz2 = {
                        "https://cdn.rhinoafrica.com/tmp/image-thumbnails/media/_en/destinations/root/africa/southern-africa/zambia/_img/image-thumb__1226__og-image/lusaka-city-at-night-zambia.jpeg",
                        "https://i.pinimg.com/originals/45/81/af/4581af2cf024dcfd14d30f57884cc003.jpg",
                        "https://www.cooperatingvolunteers.com/wp-content/uploads/2017/04/vicotirafalls.jpg"
                };
                int z = r.nextInt(paisesz.length);
                Picasso.get()
                        .load(paisesz2[z])
                        .into(imageView);
                return paisesz[z];

        }
        return "";
    }

}