package com.example.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class DetallesSeries extends AppCompatActivity {

   ImageView imgSeriePoster;
   TextView txtTituloSerie;
   TextView txtInfoPrincipal;
   TextView txtReparto;
   TextView txtSinopsis;
   Button btnregresar;


    private String foto;
    private String titulo;
    private String infoPrincipal;
    private String reparto;
    private String sinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalles_series);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgSeriePoster = findViewById(R.id.imgSeriePoster);
        txtTituloSerie = findViewById(R.id.txtTituloSerie);
        txtInfoPrincipal = findViewById(R.id.txtInfoPrincipal);
        txtReparto = findViewById(R.id.txtReparto);
        txtSinopsis = findViewById(R.id.txtSinopsis);
        btnregresar = findViewById(R.id.btnRegresar);
        Intent intent = getIntent();


        foto = intent.getStringExtra("foto");
        titulo = intent.getStringExtra("titulo");
        infoPrincipal = intent.getStringExtra("infoprincipal");
        reparto = intent.getStringExtra("reparto");
        sinopsis = intent.getStringExtra("sipnosis");

        mostrarDatos();

        configurarBotonRegresar()
    }

    private void mostrarDatos() {
        // Mostrar el título
        if (titulo != null && !titulo.isEmpty()) {
            txtTituloSerie.setText(titulo);
        }

        // Mostrar la información principal
        if (infoPrincipal != null && !infoPrincipal.isEmpty()) {
            txtInfoPrincipal.setText(infoPrincipal);
        }

        // Mostrar el reparto
        if (reparto != null && !reparto.isEmpty()) {
            txtReparto.setText(reparto);
        }

        // Mostrar la sinopsis
        if (sinopsis != null && !sinopsis.isEmpty()) {
            txtSinopsis.setText(sinopsis);
        }


        if (foto != null && !foto.isEmpty()) {

            Glide.with(this)
                    .load(foto)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgSeriePoster);


        }
    }

    private void configurarBotonRegresar() {
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}