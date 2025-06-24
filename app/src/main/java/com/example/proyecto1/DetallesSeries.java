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
    Button btnregresar;
    Toolbar toolbar;

    private String foto;
    private String titulo;
    private String infoPrincipal;
    private String reparto;
    private String sinopsis;

    private static final int REQUEST_CALL_PERMISSION = 1;
    private static final String PHONE_NUMBER = "+50766042709";
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

        // Recibir datos
        Intent intent = getIntent();
        foto = intent.getStringExtra("foto");
        titulo = intent.getStringExtra("titulo");
        infoPrincipal = intent.getStringExtra("infoprincipal");
        reparto = intent.getStringExtra("reparto");
        sinopsis = intent.getStringExtra("sipnosis");

        mostrarDatos();
        configurarBotonRegresar();
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

    // Menú del Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_call) {
            hacerLlamada();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hacerLlamada() {
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
    }
}
