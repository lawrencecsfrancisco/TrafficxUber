package com.sumo.traffic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import java.util.ArrayList;

/**
 * Created by kixkikx on 12/20/2016.
 */
public class ChoicesOfPlace_Manila  extends AppCompatActivity {
    //  SearchView sv;
    RatingBar rb;
    public static int open = 0;
    Button fab;
    static int hidethis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofactivity);
        // rb= (RatingBar)findViewById(R.id.ratingBar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (Button) findViewById(R.id.fab);

        if (hidethis == 1)
        {
            fab.setVisibility(View.GONE);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent (ChoicesOfPlace_Manila.this, ReviewChoiceOfPlace.class);
                startActivity(i);
                finishAffinity();





            }
        });
        //    sv = (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv = (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        final MyAdapter2 adapter = new MyAdapter2(this, getPlayers());
        rv.setAdapter(adapter);
        //SEARCH
/*        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });*/

/*
        if (open == 1) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            int width = dm.widthPixels;
            int height = dm.heightPixels;

            getWindow().setLayout((int)(width*.8),(int)(height*.8));
        }*/

    }

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<Places> getPlayers() {
        ArrayList<Places> movies = new ArrayList<>();
        Places p = new Places();
        p.setName("National Museum");
        p.setPos("Padre Burgos Ave, Ermita, Manila, Metro Manila");
        p.setImg(R.drawable.img_national);
        movies.add(p);
        p=new Places();
        p.setName("Filipino - Chinese Friendship Arch");
        p.setPos("Quintin Paredes Rd, Binondo, Manila, 1006 Metro Manila");
        p.setImg(R.drawable.img_chinatown);
        movies.add(p);
        p=new Places();
        p.setName("Nayong Pilipino");
        p.setPos("1000 Rizal Ave, Ermita, Manila, 1000 Metro Manila");
        p.setImg(R.drawable.img_goodwill);
        movies.add(p);
        p=new Places();
        p.setName("Bahay Tsinoy");
        p.setPos("32 Anda St, Intramuros, Manila, Metro Manila");
        p.setImg(R.drawable.img_dominical);
        movies.add(p);
        p=new Places();
        p.setName("San Agustin Church");
        p.setPos("General Luna St, Manila, Metro Manila");
        p.setImg(R.drawable.img_cathedral);
        movies.add(p);
        p=new Places();
        p.setName("Manila Cathedral");
        p.setPos("Sto. Tomas, Intramuros, Manila, 1002 Metro Manila");
        p.setImg(R.drawable.img_bgcathedral);
        movies.add(p);
        p=new Places();
        p.setName("Casa Manila Intramuros");
        p.setPos("Intramuros, Manila, Metro Manila");
        p.setImg(R.drawable.img_intramuros);
        movies.add(p);
        p=new Places();
        p.setName("Luneta/Rizal Park");
        p.setPos("Roxas Blvd Ermita, Barangay 666 Zone 72, Manila, 1000 Metro Manila");
        p.setImg(R.drawable.img_luneta);
        movies.add(p);
        p=new Places();
        p.setName("Cultural Center of the Philippines");
        p.setPos("CCP Complex, Roxas Boulevard, Magdalena Jalandoni");
        p.setImg(R.drawable.img_cultural);
        movies.add(p);
        p=new Places();
        p.setName("Paco Park and Cemetery");
        p.setPos("Belen, Paco, Manila, Metro Manila");
        p.setImg(R.drawable.img_paco);
        movies.add(p);
        p=new Places();
        p.setName("Star City");
        p.setPos("Vicente Sotto Street, CCP Complex, Pasay, Metro Manila");
        p.setImg(R.drawable.img_star);
        movies.add(p);
        p=new Places();
        p.setName("Coconut Palace");
        p.setPos("Cultural Center of the Philippines Complex, Roxas Boulevard, Manila");
        p.setImg(R.drawable.img_coconut);
        movies.add(p);



        return movies;

    }
}
