package com.example.proyecto1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.proyecto1.adaptadores.serieadaptador;
import com.example.proyecto1.clases.series;

import java.util.ArrayList;
import java.util.StringTokenizer;

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

        seriesArrayList.add(new series("https://estrenosanime.net/uploads/images/nana/Nana.jpg", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://th.bing.com/th/id/OIP.hzY-nKoxXaBfnd6yeBnwHgHaKr?rs=1&pid=ImgDetMain", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://th.bing.com/th/id/OIP.D_N3xHWMlczDboO5YvRweQHaKu?w=690&h=1000&rs=1&pid=ImgDetMain", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://m.media-amazon.com/images/M/MV5BY2ZhMDEwZTMtNzM0Yi00M2ZjLTg1OGEtZDE3YjU0OWI4MTdiXkEyXkFqcGc@._V1_.jpg", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://mx.web.img2.acsta.net/c_310_420/img/dc/b4/dcb4133ac963afb6d3b6e577e8616d78.jpg", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://m.media-amazon.com/images/M/MV5BZWEwOTUxOWEtYzE3Ni00NTIzLTljZTgtOGY1YmU3ZGQ1ODY1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://elrincondelespectador.com/wp-content/uploads/Portadas-prison-break.jpg", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://static.wikia.nocookie.net/netflix/images/2/2c/Vincenzo.jpg/revision/latest/thumbnail/width/360/height/450?cb=20210220154602", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://asianwiki.com/images/3/33/All_of_Us_Are_Dead-cp1.jpeg", "Exposerie 2025","User" , 0  ));
        seriesArrayList.add(new series("https://m.media-amazon.com/images/M/MV5BMTQ5MDU5MTktMDZkMy00NDU1LWIxM2UtODg5OGFiNmRhNDBjXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg", "Exposerie 2025","User" , 0  ));

        serieadaptador = new serieadaptador(this, seriesArrayList);
        rcvseries.setLayoutManager(new LinearLayoutManager(this));
        // rcvseries.setLayoutManager(new GridLayoutManager(this, 3));
        // rcvseries.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rcvseries.setAdapter(serieadaptador);

    }

}