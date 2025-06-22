package com.example.proyecto1.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto1.R;
import com.example.proyecto1.clases.series;

import java.util.ArrayList;

public class serieadaptador extends RecyclerView.Adapter<serieadaptador.ViewHolder>{

    private Context context;
    private ArrayList<series> listaserie;

    public serieadaptador(Context context, ArrayList<series> listaserie) {
        this.context = context;
        this.listaserie = listaserie;
    }

    @NonNull
    @Override
    public serieadaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.series_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serieadaptador.ViewHolder holder, int position) {
        Glide.with(context)
                .load(listaserie.get(position).getFoto())
                .into(holder.imgfoto);
        holder.txtuser.setText(listaserie.get(position).getUser());
        holder.txtcontador.setText(String.valueOf(listaserie.get(position).getContador()));
    }

    @Override
    public int getItemCount() {
        return listaserie.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        ImageView imgfoto, imguser, imgheart, imgshare;
        TextView txttitulo, txtuser, txtcontador;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgfoto= itemView.findViewById(R.id.imgfoto);
            imguser=itemView.findViewById(R.id.imguser);
            imgheart=itemView.findViewById(R.id.imgheart);
            imgshare=itemView.findViewById(R.id.imgshare);
            txttitulo=itemView.findViewById(R.id.txttitulo);
            txtuser=itemView.findViewById(R.id.txtuser);
            txtcontador=itemView.findViewById(R.id.txtcontador);



        }
    }
}
