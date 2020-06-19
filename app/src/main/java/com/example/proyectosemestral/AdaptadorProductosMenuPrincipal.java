package com.example.proyectosemestral;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectosemestral.Productos;
import com.example.proyectosemestral.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorProductosMenuPrincipal extends RecyclerView.Adapter<AdaptadorProductosMenuPrincipal.ViewHolderProductos>
 {

    Context mContext;
    List<Productos>mproducto;
    Dialog mDialog;

    public AdaptadorProductosMenuPrincipal(Context mContext, List<Productos> mproducto) {
        this.mContext = mContext;
        this.mproducto = mproducto;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.arreglolayoutprincipal,parent,false);
        final ViewHolderProductos viewHolderProductos = new ViewHolderProductos(v);

        mDialog= new Dialog(mContext);
        mDialog.setContentView(R.layout.fragment_detalleproducto);


        viewHolderProductos.itemProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView TituloDetalle = (TextView) mDialog.findViewById(R.id.titulodetalle);
                TextView DescripcionDetalle = (TextView) mDialog.findViewById(R.id.descripcionproductto);
                ImageView FotoDetalle = (ImageView) mDialog.findViewById(R.id.imagendetalle);
                TituloDetalle.setText(mproducto.get(viewHolderProductos.getAdapterPosition()).getTitulo());
                DescripcionDetalle.setText(mproducto.get(viewHolderProductos.getAdapterPosition()).getDescripcion());
                FotoDetalle.setImageResource(mproducto.get(viewHolderProductos.getAdapterPosition()).getFoto());
                mDialog.show();
            }
        });

        return viewHolderProductos;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.mTitulo.setText(mproducto.get(position).getTitulo());
        holder.mDescripcion.setText(mproducto.get(position).getDescripcion());
        holder.mFoto.setImageResource(mproducto.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return mproducto.size();
    }

    public  static class ViewHolderProductos extends RecyclerView.ViewHolder{
        TextView mTitulo,mDescripcion;
        ImageView mFoto;
        private RelativeLayout itemProducto;

        public ViewHolderProductos(@NonNull View itemView) {
            super(itemView);
            mTitulo= (TextView) itemView.findViewById(R.id.tituloproducto);
            mDescripcion= (TextView) itemView.findViewById(R.id.descripcionproducto);
            mFoto= (ImageView) itemView.findViewById(R.id.logoproducto);
            itemProducto= (RelativeLayout) itemView.findViewById(R.id.arreglolayout);
        }
    }

}