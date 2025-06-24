package com.example.proyecto1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
    Button btnregresar, btntrailer;
    Toolbar toolbar;

    private String foto;
    private String titulo;
    private String infoPrincipal;
    private String reparto;
    private String sinopsis;
    private String trailerUrl;

    private static final String PHONE_NUMBER = "+50766042709";
    private static final String LOCATION_ADDRESS = "Panama Convention Center, Amador.";
    private static final double LATITUDE = 8.94160439684848; // Latitud
    private static final double LONGITUDE = -79.54904748405922; // Longitud

    private static final int REQUEST_CALL_PERMISSION = 1;

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

        // Toolbar
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        // Vistas
        imgSeriePoster = findViewById(R.id.imgSeriePoster);
        txtTituloSerie = findViewById(R.id.txtTituloSerie);
        txtInfoPrincipal = findViewById(R.id.txtInfoPrincipal);
        txtReparto = findViewById(R.id.txtReparto);
        txtSinopsis = findViewById(R.id.txtSinopsis);
        btnregresar = findViewById(R.id.btnRegresar);
        btntrailer = findViewById(R.id.btntrailer);

        // Recibir datos
        Intent intent = getIntent();
        foto = intent.getStringExtra("foto");
        titulo = intent.getStringExtra("titulo");
        infoPrincipal = intent.getStringExtra("infoprincipal");
        reparto = intent.getStringExtra("reparto");
        sinopsis = intent.getStringExtra("sipnosis");
        trailerUrl = intent.getStringExtra("trailer");

        mostrarDatos();
        configurarBotonRegresar();
        configurarBotonTrailer();
    }

    private void mostrarDatos() {
        if (titulo != null) txtTituloSerie.setText(titulo);
        if (infoPrincipal != null) txtInfoPrincipal.setText(infoPrincipal);
        if (reparto != null) txtReparto.setText(reparto);
        if (sinopsis != null) txtSinopsis.setText(sinopsis);

        if (foto != null && !foto.isEmpty()) {
            Glide.with(this)
                    .load(foto)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgSeriePoster);
        }
    }

    private void configurarBotonRegresar() {
        btnregresar.setOnClickListener(v -> finish());
    }

    private void configurarBotonTrailer() {
        btntrailer.setOnClickListener(v -> abrirTrailer());
    }

    // Menú del Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_call) {
            abrirMarcador();
            return true;
        } else if (item.getItemId() == R.id.action_location) {
            abrirUbicacion();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Función para abrir el marcador telefónico (no hace la llamada automáticamente)
    private void abrirMarcador() {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + PHONE_NUMBER));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No se pudo abrir el marcador telefónico", Toast.LENGTH_SHORT).show();
        }
    }

    // Nueva función para abrir la ubicación
    private void abrirUbicacion() {
        // AlertDialog para que el usuario elija cómo abrir la ubicación
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Abrir ubicación")
                .setMessage("¿Cómo deseas ver la ubicación?")
                .setPositiveButton("Google Maps", (dialog, which) -> abrirEnGoogleMaps())
                .setNegativeButton("Otras apps", (dialog, which) -> abrirEnOtrasApps())
                .setNeutralButton("Cancelar", null)
                .show();
    }

    private void abrirEnGoogleMaps() {
        try {
            // Intent específico para Google Maps con coordenadas
            Uri gmmIntentUri = Uri.parse("geo:" + LATITUDE + "," + LONGITUDE + "?q=" +
                    Uri.encode(LOCATION_ADDRESS));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                // Si Google Maps no está instalado, usar el navegador
                abrirEnNavegador();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir Google Maps", Toast.LENGTH_SHORT).show();
            abrirEnOtrasApps();
        }
    }

    private void abrirEnOtrasApps() {
        try {
            // Intent genérico que permite al usuario elegir la aplicación
            Uri gmmIntentUri = Uri.parse("geo:" + LATITUDE + "," + LONGITUDE + "?q=" +
                    Uri.encode(LOCATION_ADDRESS));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(mapIntent, "Abrir ubicación con:"));
            } else {
                abrirEnNavegador();
            }
        } catch (Exception e) {
            Toast.makeText(this, "No se encontraron aplicaciones de mapas", Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirEnNavegador() {
        try {
            // Abrir en el navegador web como alternativa
            String url = "https://www.google.com/maps/search/?api=1&query=" +
                    LATITUDE + "," + LONGITUDE;
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "No se pudo abrir la ubicación", Toast.LENGTH_SHORT).show();
        }
    }

    // Nueva función para abrir el trailer
    private void abrirTrailer() {
        if(trailerUrl != null && !trailerUrl.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl));
            intent.setPackage("com.google.android.youtube");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Si YouTube no está instalado, abrir en navegador
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl));
                startActivity(webIntent);
            }
        } else {
            Toast.makeText(this, "No hay tráiler disponible", Toast.LENGTH_SHORT).show();
        }
    }

    /* private void hacerLlamada() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + PHONE_NUMBER));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            startActivity(intent);
        }
    }

    // Para manejar la respuesta del usuario al permiso
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                hacerLlamada();
            } else {
                Toast.makeText(this, "Permiso para llamar denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }*/
}
