package com.example.proyectosemestral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class IniciarSesion_login extends AppCompatActivity {

    private Button mButtonLogin;
    private EditText mTextEmail;
    private EditText mTextPassword;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion_login);
        firebaseAuth = FirebaseAuth.getInstance();

        mButtonLogin = (Button) findViewById(R.id.buttonLogin);
        mTextEmail = (EditText) findViewById(R.id.editTextCorreo);
        mTextPassword = (EditText) findViewById(R.id.editTextContraseña);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    loginUsuario();

            }
        });
    }

    private void loginUsuario(){
        String email = mTextEmail.getText().toString().trim();
        String password = mTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"se debe ingresar un email",Toast.LENGTH_LONG.show());
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"se debe ingresar un password",Toast.LENGTH_LONG.show());
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(this,"se debe ingresar un password",Toast.LENGTH_LONG.show());
                        }
                    }
                })
    }
}
