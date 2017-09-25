package com.sumo.traffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sumo.traffic.InfoOfPlaces.InfoOfArt;
import com.sumo.traffic.InfoOfPlaces.InfoOfAteneo;
import com.sumo.traffic.InfoOfPlaces.InfoOfBayani;
import com.sumo.traffic.InfoOfPlaces.InfoOfCOF;
import com.sumo.traffic.InfoOfPlaces.InfoOfDam;
import com.sumo.traffic.InfoOfPlaces.InfoOfEast;
import com.sumo.traffic.InfoOfPlaces.InfoOfEdsa;
import com.sumo.traffic.InfoOfPlaces.InfoOfMaginhawa;
import com.sumo.traffic.InfoOfPlaces.InfoOfNinoy;
import com.sumo.traffic.InfoOfPlaces.InfoOfParish;
import com.sumo.traffic.InfoOfPlaces.InfoOfPeople;
import com.sumo.traffic.InfoOfPlaces.InfoOfQmc;
import com.sumo.traffic.InfoOfPlaces.InfoOfUp;
import com.sumo.traffic.InfoOfPlaces.InfoOfVargas;
import com.sumo.traffic.InfoOfPlaces.InfoOfWatershed;
import com.sumo.traffic.InfoOfPlaces_Manila.BahayTsinoy;
import com.sumo.traffic.InfoOfPlaces_Manila.CCP;
import com.sumo.traffic.InfoOfPlaces_Manila.CasaManila;
import com.sumo.traffic.InfoOfPlaces_Manila.FilipinoChinese;
import com.sumo.traffic.InfoOfPlaces_Manila.Luneta;
import com.sumo.traffic.InfoOfPlaces_Manila.ManilaCathedral;
import com.sumo.traffic.InfoOfPlaces_Manila.NationalMuseum;
import com.sumo.traffic.InfoOfPlaces_Manila.NayongFilipino;
import com.sumo.traffic.InfoOfPlaces_Manila.PacoPark;
import com.sumo.traffic.InfoOfPlaces_Manila.SanAgustinChurch;
import com.sumo.traffic.InfoOfPlaces_Manila.coconutpalace;
import com.sumo.traffic.InfoOfPlaces_Manila.starcity;

import java.util.ArrayList;
import java.util.List;

public class ReviewChoiceOfPlace_Manila extends AppCompatActivity {

    static RecyclerView recyclerViewStaff;
    static RecyclerView.Adapter adapterStaff;
    static List<placeitem> InitialListStaffs;

    int tsinoy = 0;
    int casa = 0;
    int ccp = 0;
    int coconut = 0;
    int filipino = 0;
    int luneta = 0;
    int manilacathedral = 0;
    int national = 0;
    int nayongfilipino = 0;
    int pacopark = 0;
    int sanagustin = 0;
    int star = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_choice_of_place);

        recyclerViewStaff = (RecyclerView) findViewById(R.id.recyclerViewStaff);


        recyclerViewStaff.setHasFixedSize(true);
        recyclerViewStaff.setLayoutManager(new LinearLayoutManager(this));
        InitialListStaffs = new ArrayList<>();

        placeitem infoart = new placeitem();
        placeitem infoateneo = new placeitem();
        placeitem infobayani = new placeitem();
        placeitem infocof = new placeitem();
        placeitem infodam = new placeitem();
        placeitem infoeast = new placeitem();


        placeitem infoedsa = new placeitem();
        placeitem infomaginhawa = new placeitem();
        placeitem infoninoy = new placeitem();
        placeitem infoparish = new placeitem();
        placeitem infopeople = new placeitem();
        placeitem infoqmc = new placeitem();
        placeitem infoup = new placeitem();
        placeitem infovargas = new placeitem();
        placeitem infowatershed = new placeitem();

        if (BahayTsinoy.select == 1) {
            if (tsinoy == 0) {

                infoup.setname("Bahay Tsinoy");
                infoup.settype("Museum");
                InitialListStaffs.add(infoup);
                tsinoy= 1;
            } else if (tsinoy== 1) {

            }
        } else if (BahayTsinoy.select == 0) {
            InitialListStaffs.remove(infoup);

        }


        if (CasaManila.select == 1) {
            if (casa == 0) {

                infoart.setname("Casa Manila");
                infoart.settype("Museum");
                InitialListStaffs.add(infoart);
                casa = 1;

            } else if (casa == 1) {

            }
        } else if (CasaManila.select == 0) {
            InitialListStaffs.remove(infoart);

        }


        if (CCP.select == 1) {
            if (ccp == 0) {

                infoparish.setname("Cultural Center of the Philippines");
                infoparish.settype("Culture Center");
                InitialListStaffs.add(infoparish);
                ccp = 1;

            } else if (ccp == 1) {

            }
        } else if (CCP.select == 0) {
            InitialListStaffs.remove(infoparish);

        }


        if (coconutpalace.select == 1) {

            if (coconut == 0) {

                infoateneo.setname("Coconut Palace");
                infoateneo.settype("Museum");
                InitialListStaffs.add(infoateneo);
                coconut = 1;
            } else if (coconut == 1) {

            }

        } else if (coconutpalace.select == 0) {
            InitialListStaffs.remove(infoateneo);

        }

        if (FilipinoChinese.select == 1) {
            if (filipino == 0) {

                infobayani.setname("Filipino - Chinese Friendship Arch");
                infobayani.settype("Monument");
                InitialListStaffs.add(infobayani);
                filipino = 1;
            } else if (filipino == 1) {

            }

        } else if (FilipinoChinese.select == 0) {
            InitialListStaffs.remove(infobayani);

        }

        if (Luneta.select == 1) {

            if (luneta == 0) {

                infocof.setname("Luneta Park");
                infocof.settype("Monument");
                InitialListStaffs.add(infocof);
                luneta = 1;
            } else if (luneta == 1) {

            }
        } else if (Luneta.select == 0) {
            InitialListStaffs.remove(infocof);

        }

        if (ManilaCathedral.select == 1) {

            if (manilacathedral == 0) {


                infodam.setname("Manila Cathedral");
                infodam.settype("Church");
                InitialListStaffs.add(infodam);
                manilacathedral = 1;
            } else if (manilacathedral == 1) {

            }
        } else if (ManilaCathedral.select == 0) {
            InitialListStaffs.remove(infodam);

        }


        if (NationalMuseum.select == 1) {

            if (national == 0) {

                infoeast.setname("National Museum");
                infoeast.settype("Museum");
                InitialListStaffs.add(infoeast);
                national = 1;
            } else if (national == 1) {

            }
        } else if (NationalMuseum.select == 0) {
            InitialListStaffs.remove(infoeast);

        }


        if (NayongFilipino.select == 1) {

            if (nayongfilipino == 0) {

                infoedsa.setname("Nayong Filipino");
                infoedsa.settype("Museum");
                InitialListStaffs.add(infoedsa);
                nayongfilipino = 1;
            } else if (nayongfilipino == 1) {

            }

        } else if (NayongFilipino.select == 0) {
            InitialListStaffs.remove(infoedsa);

        }


        if (PacoPark.select == 1) {


            if (pacopark == 0) {

                infomaginhawa.setname("Paco Park");
                infomaginhawa.settype("Cemetery");
                InitialListStaffs.add(infomaginhawa);
                pacopark = 1;
            } else if (pacopark == 1) {

            }
        } else if (PacoPark.select == 0) {
            InitialListStaffs.remove(infomaginhawa);

        }


        if (SanAgustinChurch.select == 1) {


            if (sanagustin == 0) {

                infoninoy.setname("San Agustin Church");
                infoninoy.settype("Church");
                InitialListStaffs.add(infoninoy);
                sanagustin = 1;
            } else if (sanagustin == 1) {

            } else if (SanAgustinChurch.select == 0) {
                InitialListStaffs.remove(infoninoy);

            }


        }

        if (starcity.select == 1) {


            if (star == 0) {

                infopeople.setname("People Power Monument");
                infopeople.settype("Monument");
                InitialListStaffs.add(infopeople);
                star = 1;
            } else if (star == 1) {

            }

        } else if (starcity.select == 0) {
            InitialListStaffs.remove(infopeople);

        }




        //Toast.makeText(this, "" + InitialListStaffs.size(), Toast.LENGTH_SHORT).show();
        adapterStaff = new ReviewChoiceOfPlaceAdapter(InitialListStaffs, getApplicationContext());

        recyclerViewStaff.setAdapter(adapterStaff);
    }


    public void gonow(View view) {
        if (InitialListStaffs.size() > 7)
        {
            Toast.makeText(this, "Too many destination, Please delete a destination", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(this, traffic.class);
            startActivity(i);
            finish();
        }


    }

    public void addmore(View view) {
        Intent i = new Intent(this, ChoicesOfPlace_Manila.class);
        startActivity(i);
        //  finish();


    }

    @Override
    public void onBackPressed() {

        // finish();
        Intent i = new Intent(this, ChoicesOfPlace_Manila.class);
        startActivity(i);
    }



}
