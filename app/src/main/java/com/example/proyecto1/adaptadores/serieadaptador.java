package com.example.proyecto1.adaptadores;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto1.DetallesSeries;
import com.example.proyecto1.R;
import com.example.proyecto1.clases.series;

import java.util.ArrayList;

public class serieadaptador extends RecyclerView.Adapter<serieadaptador.ViewHolder> {

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        series serie = listaserie.get(position);

        Glide.with(context).load(serie.getFoto()).into(holder.imgfoto);
        holder.txttitulo.setText(serie.getTitulo());
        holder.txtuser.setText(serie.getUser());
        holder.txtcontador.setText(String.valueOf(serie.getContador()));

        // Acción para el botón "me gusta" (corazón)

        holder.imgheart.setOnClickListener(v -> {
            if (!serie.isLiked()) {
                serie.incrementar();
                holder.imgheart.setImageResource(R.drawable.heartrojo);
                holder.imgheart.setColorFilter(Color.RED); // Cambiar color
            } else {
                serie.decrementar();
                holder.imgheart.clearColorFilter();// Ícono vacío
            }
            holder.txtcontador.setText(String.valueOf(serie.getContador()));
        });

       /* holder.imgheart.setOnClickListener(v -> {
            serie.incrementar();
            holder.txtcontador.setText(String.valueOf(serie.getContador()));
        });*/

        // Acción para el botón share
        holder.imgshare.setOnClickListener(v -> {
            String mensaje = "¡Mira esta serie recomendada!\n\n" +
                    "📺 Título: " + serie.getTitulo() + "\n" +
                    "🎬 " + serie.getInfoPrincipal() + "\n\n" +
                    "¡No te la pierdas!";

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Serie recomendada: " + serie.getTitulo());

            try {
                // Crear el selector de apps
                Intent chooser = Intent.createChooser(shareIntent, "Compartir serie con:");
                context.startActivity(chooser);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(context, "No hay aplicaciones disponibles para compartir", Toast.LENGTH_SHORT).show();
            }
        });

       /* holder.imgshare.setOnClickListener(v -> {
            String mensaje = "¡Mira esta serie recomendada!\n" +
                    "Título: " + serie.getTitulo() + "\n" +
                    "Imagen: " + serie.getFoto();

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, mensaje);
            intent.setPackage("com.whatsapp");

            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(context, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show();
            }
        });*/

        /* Botón tráiler
        holder.btnTrailer.setOnClickListener(v -> {
            String trailerUrl = serie.getTrailerUrl();
            if(trailerUrl != null && !trailerUrl.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl));
                intent.setPackage("com.google.android.youtube");

                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                } else {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl));
                    context.startActivity(webIntent);
                }
            } else {
                Toast.makeText(context, "No hay tráiler disponible", Toast.LENGTH_SHORT).show();
            }
        }); */

        // Click en el item completo para ir a la actividad de detalles

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetallesSeries.class);
                intent.putExtra("foto", listaserie.get(position).getFoto());
                intent.putExtra("titulo", listaserie.get(position).getTitulo());
                intent.putExtra("infoprincipal", listaserie.get(position).getInfoPrincipal());
                intent.putExtra("reparto", listaserie.get(position).getReparto());
                intent.putExtra("sipnosis", listaserie.get(position).getSinopsis());
                intent.putExtra("trailer", listaserie.get(position).getTrailerUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaserie.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgfoto, imguser, imgheart, imgshare;
        TextView txttitulo, txtuser, txtcontador;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgfoto = itemView.findViewById(R.id.imgfoto);
            imguser = itemView.findViewById(R.id.imguser);
            imgheart = itemView.findViewById(R.id.imgheart);
            imgshare = itemView.findViewById(R.id.imgshare);
            txttitulo = itemView.findViewById(R.id.txttitulo);
            txtuser = itemView.findViewById(R.id.txtuser);
            txtcontador = itemView.findViewById(R.id.txtcontador);
        }
    }
}