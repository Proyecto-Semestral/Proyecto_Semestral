package com.example.proyectosemestral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Confirmacion_registro_usuario extends AppCompatActivity {
    private Button boton_continuar_confirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_registro_usuario);
        boton_continuar_confirmacion = findViewById(R.id.button_continuar_cru);

        boton_continuar_confirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent boton_continuar_confirmacion = new Intent(Confirmacion_registro_usuario.this, MenuPrincipal.class);
                startActivity(boton_continuar_confirmacion);

            }
        });
    }
}
