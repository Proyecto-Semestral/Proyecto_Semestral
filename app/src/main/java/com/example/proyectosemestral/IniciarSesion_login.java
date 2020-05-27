package com.example.proyectosemestral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class IniciarSesion_login extends AppCompatActivity {
    private EditText mEditTextCorreo;
    private EditText mEditTextContraseña;
    private Button mBotonLogin;
    private FirebaseAuth mAuth;

    private String correo = "";
    private String contraseña = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion_login);

        mEditTextCorreo = (EditText) findViewById(R.id.editText_Contraseña_login);
        mEditTextContraseña = (EditText) findViewById(R.id.editText_Contraseña_login);

        mAuth = FirebaseAuth.getInstance();

        mBotonLogin = (Button) findViewById(R.id.buttonLogin);
        mBotonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                correo = mEditTextCorreo.getText().toString();
                contraseña = mEditTextContraseña.getText().toString();

                if (!correo.isEmpty() && !contraseña.isEmpty()) {

                    loginUser();

                }
                else {
                    Toast.makeText(IniciarSesion_login.this,"complete los datos requeridos",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void loginUser() {

        mAuth.signInWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(IniciarSesion_login.this, MenuPrincipal.class));
                    finish();
                }
                else {
                    Toast.makeText(IniciarSesion_login.this,"su correo o contraseña son incorrectos",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
