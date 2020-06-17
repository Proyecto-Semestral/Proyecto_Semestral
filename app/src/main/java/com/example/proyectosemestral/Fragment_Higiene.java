package com.example.proyectosemestral;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectosemestral.AdaptadorProductosMenuPrincipal;
import com.example.proyectosemestral.Productos;
import com.example.proyectosemestral.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Higiene#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Higiene extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewProductos;
    ArrayList<Productos> ListaProductos;

    public Fragment_Higiene() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Higiene.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Higiene newInstance(String param1, String param2) {
        Fragment_Higiene fragment = new Fragment_Higiene();
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
        View vist= inflater.inflate(R.layout.fragment__proteccion, container, false);
        ListaProductos= new ArrayList<>();

        recyclerViewProductos= (RecyclerView) vist.findViewById(R.id.recyclerviewproducto);


        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        ElementosProducto();

        AdaptadorProductosMenuPrincipal adapter= new AdaptadorProductosMenuPrincipal((ListaProductos));

        recyclerViewProductos.setAdapter(adapter);

        return vist;
    }
    private void ElementosProducto() {
        ListaProductos.add(new Productos("titulo11","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo12","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo13","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo14","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo15","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo16","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo17","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo18","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo19","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
        ListaProductos.add(new Productos("titulo20","descripcion","",R.drawable.logousuario,R.drawable.logousuario));
    }
}
