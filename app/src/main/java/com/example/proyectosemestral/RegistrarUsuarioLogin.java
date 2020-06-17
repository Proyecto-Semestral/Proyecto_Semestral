package com.example.proyectosemestral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectosemestral.Confirmacion_registro_usuario;
import com.example.proyectosemestral.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrarUsuarioLogin extends AppCompatActivity {
    private EditText mEditTextNombre;
    private EditText mEditTextApellido;
    private EditText mEditTextCorreo;
    private EditText mEditTextContraseña;
    private Button mButtonRegistrar;


    private String nombre = "";
    private String apellido = "";
    private String correo = "";
    private String contraseña = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_login);


        mEditTextNombre = (EditText) findViewById(R.id.registrar_nombre);
        mEditTextApellido = (EditText) findViewById(R.id.registrar_apellido);
        mEditTextCorreo = (EditText) findViewById(R.id.registrar_correo);
        mEditTextContraseña = (EditText) findViewById(R.id.registrar_contraseña);
        mButtonRegistrar = (Button) findViewById(R.id.registrar_boton);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = mEditTextNombre.getText().toString();
                apellido = mEditTextApellido.getText().toString();
                correo = mEditTextCorreo.getText().toString();
                contraseña = mEditTextContraseña.getText().toString();

                if (!nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){

                    if(contraseña.length()>=6){

                    }
                    else{
                        Toast.makeText(RegistrarUsuarioLogin.this,"la contraseña debe contener minimo 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                    registrarUsuario();
                }
                else {
                    Toast.makeText(RegistrarUsuarioLogin.this,"debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void registrarUsuario() {
        mAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put( "Nombre", nombre);
                    map.put( "Apellido", apellido);
                    map.put( "Correo", correo);
                    map.put( "Contraseña", contraseña);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task1) {
                            if (task1.isSuccessful()){
                                startActivity(new Intent(RegistrarUsuarioLogin.this, Confirmacion_registro_usuario.class));
                                finish();
                            }
                            else
                            {
                                Toast.makeText(RegistrarUsuarioLogin.this,"Hubo un error al crear su cuenta", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(RegistrarUsuarioLogin.this,"error al registrar este usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
