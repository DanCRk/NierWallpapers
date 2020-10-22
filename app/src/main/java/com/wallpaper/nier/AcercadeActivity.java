package com.wallpaper.nier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AcercadeActivity extends Activity {

    TextView textView, textView1, textView2;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        // Agregar animaciones

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba2);

        // Crear clases y Referencias id´s

        textView1 = findViewById(R.id.version);
        textView2 = findViewById(R.id.nombre);
        textView = findViewById(R.id.compartir_acercade);
        TextView PorTextView =findViewById(R.id.PorTextView);
        TextView FutureFixTextView =findViewById(R.id.FutureFixTextView);
        imageView = findViewById(R.id.imagen_logo);

        // Asignar animaciones

        textView2.setAnimation(animation3);
        textView1.setAnimation(animation3);
        textView.setAnimation(animation2);
        PorTextView.setAnimation(animation2);
        FutureFixTextView.setAnimation(animation2);
        imageView.setAnimation(animation1);

        // Asignar la accion para compartir la app

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compartir = new Intent(Intent.ACTION_SEND);
                compartir.setType("text/plain");
                String mensaje = "Comparte la app con tus amigos: https://play.google.com/store/apps/details?id=com.Automat.proyect_dinero";
                compartir.putExtra(Intent.EXTRA_SUBJECT,"App prrona");
                compartir.putExtra(Intent.EXTRA_TEXT, mensaje);
                startActivity(Intent.createChooser(compartir,"Compartir via"));
            }
        });
    }

    public void pulsar(View view) {
    }
}