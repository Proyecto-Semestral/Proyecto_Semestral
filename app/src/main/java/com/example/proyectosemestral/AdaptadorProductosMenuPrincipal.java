package com.example.proyectosemestral;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectosemestral.Productos;
import com.example.proyectosemestral.R;

import java.util.ArrayList;

public class AdaptadorProductosMenuPrincipal extends RecyclerView.Adapter<AdaptadorProductosMenuPrincipal.ViewHolderProductos>
implements View.OnClickListener{

    ArrayList<Productos>ListaProductos;
    ArrayList<Productos>CarroCompras;
    private View.OnClickListener listener;

    public AdaptadorProductosMenuPrincipal(ArrayList<Productos> listaProductos, ArrayList<Productos> carroCompras) {
        ListaProductos = listaProductos;
        CarroCompras = carroCompras;
    }


    public AdaptadorProductosMenuPrincipal(ArrayList<Productos> listaProductos) {
        ListaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arreglolayoutprincipal,null,false);
        view.setOnClickListener(this);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.mTitulo.setText(ListaProductos.get(position).getTitulo());
        holder.mDescripcion.setText(ListaProductos.get(position).getDescripcion());
        holder.mFoto.setImageResource(ListaProductos.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return ListaProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {

        TextView mTitulo,mDescripcion;
        ImageView mFoto;


        public ViewHolderProductos(@NonNull View itemView) {
            super(itemView);
            mTitulo= (TextView) itemView.findViewById(R.id.tituloproducto);
            mDescripcion= (TextView) itemView.findViewById(R.id.descripcionproducto);
            mFoto= (ImageView) itemView.findViewById(R.id.logoproducto);


        }
    }
}
