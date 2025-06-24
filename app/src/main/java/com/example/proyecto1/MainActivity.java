package com.example.proyecto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.proyecto1.adaptadores.serieadaptador;
import com.example.proyecto1.clases.series;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnGrid;
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
        btnGrid = findViewById(R.id.btnGrid);

        //NANA
        seriesArrayList.add(new series(
                "https://estrenosanime.net/uploads/images/nana/Nana.jpg",
                "NANA",
                "User",
                0,
                "https://www.youtube.com/watch?v=Tad-n4Xh3nI",
                "Anime de drama, música y romance que sigue las vidas de dos mujeres jóvenes llamadas Nana en Tokyo.",
                "Kana Hanazawa (Nana Komatsu), Romi Park (Nana Osaki), Mamiko Noto (Reira Serizawa), Yoshiki Nakajima (Ren Honjo), " +
                        "Takahiro Sakurai (Takumi Ichinose)",
                "Dos mujeres aparentemente opuestas, ambas llamadas Nana, se convierten en compañeras de cuarto en Tokyo y crecen inseparablemente. " +
                        "Sin embargo, su relación se ve amenazada cuando las duras realidades de la vida adulta toman forma, incluyendo amor, música y sueños por cumplir."
        ));
        // 25 21 (Twenty-Five Twenty-One - 2022)
        seriesArrayList.add(new series(
                "https://th.bing.com/th/id/OIP.hzY-nKoxXaBfnd6yeBnwHgHaKr?rs=1&pid=ImgDetMain",
                "25 21",
                "User",
                0,
                "https://www.youtube.com/watch?v=V9NLRnpaxeo",
                "Drama coreano de romance y coming-of-age ambientado durante la crisis financiera asiática de 1998.",
                "Kim Tae-ri (Na Hee-do), Nam Joo-hyuk (Baek Yi-jin), Kim Ji-yeon (Ko Yu-rim), Choi Hyun-wook (Moon Ji-woong), Lee Joo-myung (Ji Seung-wan)",
                "Durante la crisis financiera surcoreana, una adolescente esgrimista llamada Na Hee-do ve disuelto su equipo escolar, pero supera obstáculos para unirse al equipo nacional. Mientras tanto, la vida de Baek Yi-jin se ve trastornada cuando el negocio de su familia quiebra. Sus vidas se entrelazan en una historia de amor y crecimiento personal."
        ));
        //Orange
        seriesArrayList.add(new series(
                "https://th.bing.com/th/id/OIP.D_N3xHWMlczDboO5YvRweQHaKu?w=690&h=1000&rs=1&pid=ImgDetMain",
                "Orange",
                "User",
                0,
                "https://www.youtube.com/watch?v=kVDqRG0qbBs",
                "Anime de drama y romance sobre una estudiante que recibe cartas de su yo futuro para salvar a un amigo.",
                "Kana Hanazawa (Naho Takamiya), Seiichiro Yamashita (Kakeru Naruse), Makoto Furukawa (Hiroto Suwa), Rika Kinugawa (Takako Chino)",
                "La estudiante de preparatoria Naho Takamiya recibe una carta de su yo futuro que le advierte evitar errores que cometerá con un estudiante de intercambio, Kakeru Naruse, un chico problemático del cual se enamora y debe salvar de un destino trágico."
        ));
        //Palpito
        seriesArrayList.add(new series(
                "https://m.media-amazon.com/images/M/MV5BY2ZhMDEwZTMtNzM0Yi00M2ZjLTg1OGEtZDE3YjU0OWI4MTdiXkEyXkFqcGc@._V1_.jpg",
                "Pálpito",
                "User",
                0,
                "https://www.youtube.com/watch?v=YITf1X6hNls&t=5s",
                "Drama intenso sobre dos vidas unidas por un trasplante de corazón y los secretos oscuros que lo hicieron posible.",
                "Michel Brown (Simón Duque), Ana Lucía Domínguez (Camila Duarte), Sebastián Martínez (Zacarías Cienfuegos), Margarita Muñoz (Valeria Duque), Valeria Emiliani (Samantha), Julián Cerati (Tomás)",
                "Durante su boda, Camila sufre un paro cardíaco y necesita urgentemente un trasplante. Su esposo Zacarías recurre a una red de tráfico de órganos que asesina a Valeria para extraerle el corazón y salvar a Camila. El esposo de Valeria, Simón, investiga el crimen, se infiltra en la mafia y encuentra a Camila… quien lleva el corazón de su esposa y con quien desarrolla una relación inesperada."
        ));
        //Harta
        seriesArrayList.add(new series(
                "https://mx.web.img2.acsta.net/c_310_420/img/dc/b4/dcb4133ac963afb6d3b6e577e8616d78.jpg",
                "Harta",
                "User",
                0,
                "https://www.youtube.com/watch?v=nZ2ZB2fVxaM",
                "Drama intenso de Tyler Perry sobre una madre desesperada que enfrenta un sistema injusto para salvar a su hija enferma.",
                "Taraji P. Henson (Janiyah Wiltkinson), Sherri Shepherd (Nicole Parker), Teyana Taylor (Detective Kay Raymond), Sinbad (Benny), Rockmond Dunbar (Jefe de Wilson), Glynn Turman (jefe de Janiyah)",
                "Harta cuenta la historia de Janiyah Wiltkinson, una madre soltera que lucha contra dificultades económicas y un sistema de salud deficiente para cuidar a su hija enferma, Aria. Cuando una situación crítica la obliga a tomar medidas desesperadas, Janiyah debe enfrentar las consecuencias de sus actos para proteger a su hija."
        ));
        //El robo del siglo
        seriesArrayList.add(new series(
                "https://m.media-amazon.com/images/M/MV5BZWEwOTUxOWEtYzE3Ni00NTIzLTljZTgtOGY1YmU3ZGQ1ODY1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
                "El Robo del Siglo",
                "User",
                0,
                "https://www.youtube.com/watch?v=1dldWAM7aD8",
                "Miniserie colombiana basada en hechos reales sobre el robo más grande de la historia de Colombia.",
                "Andrés Parra (Roberto Lozano-Chayo), Christian Tappan (Jairo Molina-El abogado), Waldo Urrego (Gabriel Herrera-el dragón), Marcela Benjumea (Doña K), Juan Sebastián Calero (El sardino)",
                "Basada en el robo real al Banco de la República de Colombia en 1994, la serie narra cómo un grupo de ladrones ejecutó meticulosamente el atraco más audaz de la historia del país, sustrayendo más de 24 mil millones de pesos sin disparar un solo tiro."
        ));
        //Prison breack
        seriesArrayList.add(new series(
                "https://elrincondelespectador.com/wp-content/uploads/Portadas-prison-break.jpg",
                "Prison Break",
                "User",
                0,
                "https://www.youtube.com/watch?v=AL9zLctDJaU",
                "Thriller dramático sobre un ingeniero estructural que se hace encarcelar para ayudar a su hermano a escapar del corredor de la muerte.",
                "Wentworth Miller (Michael Scofield), Dominic Purcell (Lincoln Burrows), Amaury Nolasco (Fernando Sucre), Robert Knepper (Theodore Bagwell), Sarah Wayne Callies (Sara Tancredi)",
                "Un ingeniero estructural se instala deliberadamente en una prisión que él ayudó a diseñar para salvar a su hermano falsamente acusado de asesinato y condenado a muerte, planeando una elaborada fuga desde adentro mientras descubren una conspiración gubernamental."
        ));
        //Vincenzo
        seriesArrayList.add(new series(
                "https://static.wikia.nocookie.net/netflix/images/2/2c/Vincenzo.jpg/revision/latest/thumbnail/width/360/height/450?cb=20210220154602",
                "Vincenzo",
                "User",
                0,
                "https://www.youtube.com/watch?v=_J8tYxYB_YU",
                "Drama coreano de 2021 sobre un abogado consigliere de la mafia italiana que regresa a Corea del Sur.",
                "Song Joong-ki (Vincenzo Cassano), Jeon Yeo-been (Hong Cha-young), Ok Taec-yeon (Jang Jun-woo), Kim Yeo-jin (Choi Myung-hee)",
                "Vincenzo Cassano es un abogado coreano-italiano y consigliere de la mafia que regresa a Corea después de un conflicto dentro de su organización. Usa métodos poco convencionales para lidiar con villanos que no pueden ser castigados por la ley."
        ));
        // All of Us Are Dead (2022)
        seriesArrayList.add(new series(
                "https://asianwiki.com/images/3/33/All_of_Us_Are_Dead-cp1.jpeg",
                "All of Us Are Dead",
                "User",
                0,
                "https://www.youtube.com/watch?v=IN5TD4VRcSM&t=23s",
                "Serie coreana de zombies de Netflix ambientada en una escuela secundaria durante un brote viral.",
                "Park Ji-hu (Nam On-jo), Yoon Chan-young (Lee Cheong-san), Cho Yi-hyun (Choi Nam-ra), Park Solomon (Lee Su-hyeok), Im Jae-hyuk (Yang Dae-su)",
                "Una escuela secundaria se convierte en el epicentro de un brote de virus zombie. Los estudiantes atrapados deben luchar por sus vidas mientras buscan una forma de escapar del edificio infestado o convertirse en uno de los infectados."
        ));
        //The witcher
        seriesArrayList.add(new series(
                "https://m.media-amazon.com/images/M/MV5BMTQ5MDU5MTktMDZkMy00NDU1LWIxM2UtODg5OGFiNmRhNDBjXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
                "The Witcher",
                "User",
                0,
                "https://www.youtube.com/watch?v=ndl1W4ltcmg",
                "Serie de fantasía épica basada en los libros de Andrzej Sapkowski sobre un cazador de monstruos en un mundo medieval.",
                "Henry Cavill (Geralt de Rivia), Anya Chalotra (Yennefer de Vengerberg), Freya Allan (Ciri), Joey Batey (Jaskier), MyAnna Buring (Tissaia de Vries)",
                "Geralt de Rivia, un cazador de monstruos solitario, lucha por encontrar su lugar en un mundo donde las personas a menudo demuestran ser más malvadas que las bestias. Su destino se entrelaza con el de la poderosa hechicera Yennefer y la joven princesa Ciri, quien posee un poder peligroso."
        ));


        serieadaptador = new serieadaptador(this, seriesArrayList);
       rcvseries.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rcvseries.setAdapter(serieadaptador);

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (btnGrid instanceof FloatingActionButton) {
                    FloatingActionButton fab = (FloatingActionButton) btnGrid;

                    btnGrid.setActivated(!btnGrid.isActivated());

                    if (btnGrid.isActivated()) {
                        rcvseries.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                        fab.setImageResource(R.drawable.icon_list);
                    } else {
                        rcvseries.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        fab.setImageResource(R.drawable.icon_grid);
                    }
                }
            }
        });
    }
}
