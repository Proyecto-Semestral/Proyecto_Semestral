package com.example.proyectosemestral;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_cerrar_sesion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_cerrar_sesion extends Fragment {
    Fragment_cerrar_sesion fragment_cerrar_sesion;
    private static int SPLASH_TIME_OUT = 1000;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_cerrar_sesion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_cerrar_sesion.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_cerrar_sesion newInstance(String param1, String param2) {
        Fragment_cerrar_sesion fragment = new Fragment_cerrar_sesion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_cerrar_sesion, container, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent fragment_cerrar_sesion = new Intent(getActivity(), MainActivity.class);
                startActivity(fragment_cerrar_sesion);
            }
        },SPLASH_TIME_OUT);

        return view;
    }

}
