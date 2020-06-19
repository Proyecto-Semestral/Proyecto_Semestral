package com.example.proyectosemestral;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectosemestral.AdaptadorProductosMenuPrincipal;
import com.example.proyectosemestral.Productos;
import com.example.proyectosemestral.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Proteccion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Proteccion extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    View v;
    private RecyclerView myrecyclerview;
    private List<Productos>listaProductos;

    public Fragment_Proteccion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Proteccion.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Proteccion newInstance(String param1, String param2) {
        Fragment_Proteccion fragment = new Fragment_Proteccion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    listaProductos = new ArrayList<>();
    listaProductos.add(new Productos("cubre calzado","Precio$100","",R.drawable.proteccionuno,R.drawable.proteccionuno));
    listaProductos.add(new Productos("alcohol 70°","Precio$2.990","",R.drawable.protecciondos,R.drawable.protecciondos));
    listaProductos.add(new Productos("guantes latex","Precio$3.990","",R.drawable.protecciontres,R.drawable.protecciontres));
    listaProductos.add(new Productos("guantes nitrilo","Precio$5.990","",R.drawable.proteccioncuatro,R.drawable.proteccioncuatro));
    listaProductos.add(new Productos("guantes esteril","Precio$550","",R.drawable.proteccioncinco,R.drawable.proteccioncinco));
    listaProductos.add(new Productos("guantes nitrilo negro","Precio$5.990","",R.drawable.proteccionseis,R.drawable.proteccionseis));
    listaProductos.add(new Productos("mascara protectora","Precio$3.990","",R.drawable.proteccionsiete,R.drawable.proteccionsiete));
    listaProductos.add(new Productos("mascarilla n95","Precio$5.990","",R.drawable.proteccionocho,R.drawable.proteccionocho));
    listaProductos.add(new Productos("repuesto mascara","Precio$5.990","",R.drawable.proteccionnueve,R.drawable.proteccionnueve));
    listaProductos.add(new Productos("toallita esteril","Precio$300","",R.drawable.protecciondies,R.drawable.protecciondies));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment__proteccion, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.recyclerviewproducto);
        AdaptadorProductosMenuPrincipal adaptadorProductosMenuPrincipal = new AdaptadorProductosMenuPrincipal(getContext(),listaProductos);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(adaptadorProductosMenuPrincipal);
        return v;
    }




}
