package com.example.proyecto1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto1.adaptadores.serieadaptador;
import com.example.proyecto1.clases.series;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvseries;
    serieadaptador serieadaptador;
    ArrayList<series> seriesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcvseries = findViewById(R.id.rcvseries);

        // Tus series con sus tráilers
        seriesArrayList.add(new series(
                "https://estrenosanime.net/uploads/images/nana/Nana.jpg",
                "Exposerie 2025",
                "User",
                0,
                "https://www.youtube.com/watch?v=Tad-n4Xh3nI"
        ));

        seriesArrayList.add(new series(
                "https://th.bing.com/th/id/OIP.hzY-nKoxXaBfnd6yeBnwHgHaKr?rs=1&pid=ImgDetMain",
                "Exposerie 2025",
                "User",
                0,
                "https://www.youtube.com/watch?v=V9NLRnpaxeo"
        ));

        seriesArrayList.add(new series(
                "https://th.bing.com/th/id/OIP.D_N3xHWMlczDboO5YvRweQHaKu?w=690&h=1000&rs=1&pid=ImgDetMain",
                "Exposerie 2025",
                "User",
                0,
                "https://www.youtube.com/watch?v=kVDqRG0qbBs"
        ));

        seriesArrayList.add(new series(
                "https://m.media-amazon.com/images/M/MV5BY2ZhMDEwZTMtNzM0Yi00M2ZjLTg1OGEtZDE3YjU0OWI4MTdiXkEyXkFqcGc@._V1_.jpg",
                "Exposerie 2025",
                "User",
                0,
                "https://www.youtube.com/watch?v=YITf1X6hNls&t=5s"
        ));

        seriesArrayList.add(new series(
                "https://mx.web.img2.acsta.net/c_310_420/img/dc/b4/dcb4133ac963afb6d3b6e577e8616d78.jpg",
                "Exposerie 2025",
                "User",
                0,
                "https://www.youtube.com/watch?v=nZ2ZB2fVxaM"
        )) ;
        seriesArrayList.add(new series(
                "https://m.media-amazon.com/images/M/MV5BZWEwOTUxOWEtYzE3Ni00NTIzLTljZTgtOGY1YmU3ZGQ1ODY1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
                "Exposerie 2025",
                "User",
                0,
                "https://www.youtube.com/watch?v=1dldWAM7aD8"
               ));

        // Configuración del RecyclerView con adaptador
        serieadaptador = new serieadaptador(this, seriesArrayList);
        rcvseries.setLayoutManager(new LinearLayoutManager(this));
        rcvseries.setAdapter(serieadaptador);
    }
}
