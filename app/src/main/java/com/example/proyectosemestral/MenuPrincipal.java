package com.example.proyectosemestral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private FragmentGuantes fragmentGuantes;
    private FragmentMascarillas fragmentMascarillas;
    private FragmentJabon fragmentJabon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fragmentGuantes = new FragmentGuantes();
        fragmentMascarillas = new FragmentMascarillas();
        fragmentJabon = new FragmentJabon();
        bottomNavigationView = findViewById(R.id.botonNavigationView);
        frameLayout = findViewById(R.id.framelayout);

        setFragment(fragmentGuantes);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.opcionGuantes:
                        bottomNavigationView.setItemBackgroundResource(R.color.celesteMedio);
                        setFragment(fragmentGuantes);
                        return true;
                    case R.id.opcionMascarilla:
                        bottomNavigationView.setItemBackgroundResource(R.color.celesteMedio);
                        setFragment(fragmentMascarillas);
                        return true;
                    case R.id.opcionJabon:
                        bottomNavigationView.setItemBackgroundResource(R.color.celesteMedio);
                        setFragment(fragmentJabon);
                        return true;

                }
                return false;
            }
        });

    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }


}
