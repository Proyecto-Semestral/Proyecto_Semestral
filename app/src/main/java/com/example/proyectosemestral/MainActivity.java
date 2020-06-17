package com.example.proyectosemestral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private Button boton_registrar;
   private Button boton_login;
   private Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_login = findViewById(R.id.boton_login);
        boton_registrar = findViewById(R.id.button_registar_am);
        siguiente = findViewById(R.id.button2);

        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent boton_registrar = new Intent(MainActivity.this, RegistrarUsuarioLogin.class);
                startActivity(boton_registrar);

            }
        });

        boton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent boton_login = new Intent(MainActivity.this, IniciarSesion_login.class);
                startActivity(boton_login);

            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(MainActivity.this, MenuPrincipal2.class);
                startActivity(siguiente);

            }
        });

    }
}
