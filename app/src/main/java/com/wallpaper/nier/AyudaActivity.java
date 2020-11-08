package com.wallpaper.nier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AyudaActivity extends Activity {

    Button boton1;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        textView = findViewById(R.id.boton_atras);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AyudaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        boton1 = findViewById(R.id.preguntas);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AyudaActivity.this, SugerenciasActivity.class);
                startActivity(intent);
            }
        });

    }
}