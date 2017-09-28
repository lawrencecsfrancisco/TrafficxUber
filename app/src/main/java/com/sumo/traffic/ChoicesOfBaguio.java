package com.sumo.traffic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import java.util.ArrayList;

/**
 * Created by Amos on 9/25/2017.
 */
public class ChoicesOfBaguio  extends AppCompatActivity {
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
                Intent i = new Intent (ChoicesOfBaguio.this, ReviewChoiceOfPlace.class);
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
        final MyAdapter adapter = new MyAdapter(this, getPlayers());
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
        p.setName("Good Shepherd Place");
        p.setPos("Gibraltar Rd, Baguio, 2600 Benguet"); //changeIMage - done
        p.setImg(R.drawable.img_goodshepherd);
        movies.add(p);
        p=new Places();
        p.setName("Arca's Yard");
        p.setPos("Ambuklao Rd, Baguio, Benguet"); //changeImage -done
        p.setImg(R.drawable.img_arcas);
        movies.add(p);
        p=new Places();
        p.setName("Wright Park");
        p.setPos("Gibraltar Rd, Baguio, Benguet"); //changeImage -done
        p.setImg(R.drawable.img_wrightpark);
        movies.add(p);
        p=new Places();
        p.setName("Mines View Park");
        p.setPos("Europa Mines View Condominium Building 2, 2600, Gibraltar Rd, Baguio, Benguet"); //changeImage -done
        p.setImg(R.drawable.img_minesviewpark);
        movies.add(p);
        p=new Places();
        p.setName("The Mansion");
        p.setPos("The Mansion, Romulo Dr, Baguio, Benguet"); //changeImage -done
        p.setImg(R.drawable.img_themansion);
        movies.add(p);
        p=new Places();
        p.setName("Diplomat Hotel");
        p.setPos("Dominican Hill, Diplomat Road, Baguio, 2600 Benguet"); //changeImage  -done
        p.setImg(R.drawable.img_diplomat);
        movies.add(p);
        p=new Places();
        p.setName("Camp John Hay");
        p.setPos("Camp John Hay, Ordonio Dr, Baguio, 2600 Benguet"); //changeImage  -done
        p.setImg(R.drawable.img_campjohn);
        movies.add(p);
        p=new Places();
        p.setName("Good Taste Restaurant");
        p.setPos("Rajah Matanda St, Baguio, Benguet"); //changeImage  --done
        p.setImg(R.drawable.img_goodtaste);
        movies.add(p);
        p=new Places();
        p.setName("Pink Sister's Convent");
        p.setPos("Brent Rd, Baguio, Benguet"); //changeImage  --done
        p.setImg(R.drawable.img_pinksisters);
        movies.add(p);
        p=new Places();
        p.setName("Farmer's Daughter Restaurant"); //changeImage -done
        p.setPos("Long Long Benguet Rd, Awan Village Baguio, Baguio, 2601 Benguet");
        p.setImg(R.drawable.img_farmersdaughter);
        movies.add(p);
        p=new Places();
        p.setName("Night Market");
        p.setPos("Harrison Rd, Baguio, Benguet"); //changeImage
        p.setImg(R.drawable.img_nightmarket);
        movies.add(p);
        p=new Places();
        p.setName("STOBOSA Mural Arts");
        p.setPos("Baguio - La Trinidad - Bontoc Rd, Baguio, 2601 Benguet"); //changeImage
        p.setImg(R.drawable.img_stobosa);
        movies.add(p);


        return movies;

    }
}

