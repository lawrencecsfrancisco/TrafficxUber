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

import java.util.ArrayList;
import java.util.List;

public class ReviewChoiceOfPlace extends AppCompatActivity {

    static RecyclerView recyclerViewStaff;
    static RecyclerView.Adapter adapterStaff;
    static List<placeitem> InitialListStaffs;

    int bayani = 0;
    int cof = 0;
    int dam = 0;
    int east = 0;
    int edsa = 0;
    int maginhawa = 0;
    int ninoy = 0;
    int parish = 0;
    int people = 0;
    int qcx = 0;
    int qmc = 0;
    int up = 0;
    int vargas = 0;
    int watershed = 0;
    int wildlife = 0;
    int art = 0;
    int ayala = 0;
    int ateneo = 0;

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

        if (InfoOfUp.select == 1) {
            if (ayala == 0) {

                infoup.setname("UP Technohub");
                infoup.settype("Food park and Mall");
                InitialListStaffs.add(infoup);
                ayala = 1;
            } else if (ayala == 1) {

            }
        } else if (InfoOfUp.select == 0) {
            InitialListStaffs.remove(infoup);

        }


        if (InfoOfArt.select == 1) {
            if (art == 0) {

                infoart.setname("Art in Island");
                infoart.settype("Museum");
                InitialListStaffs.add(infoart);
                art = 1;

            } else if (art == 1) {

            }
        } else if (InfoOfArt.select == 0) {
            InitialListStaffs.remove(infoart);

        }


        if (InfoOfParish.select == 1) {
            if (parish == 0) {

                infoparish.setname("Parish of Holy Sacrifice");
                infoparish.settype("Church");
                InitialListStaffs.add(infoparish);
                parish = 1;

            } else if (parish == 1) {

            }
        } else if (InfoOfParish.select == 0) {
            InitialListStaffs.remove(infoparish);

        }


        if (InfoOfAteneo.select == 1) {

            if (ateneo == 0) {

                infoateneo.setname("Ateneo Art Gallery");
                infoateneo.settype("Museum");
                InitialListStaffs.add(infoateneo);
                ateneo = 1;
            } else if (ateneo == 1) {

            }

        } else if (InfoOfAteneo.select == 0) {
            InitialListStaffs.remove(infoateneo);

        }

        if (InfoOfBayani.select == 1) {
            if (bayani == 0) {

                infobayani.setname("Bantayog ng Bayani");
                infobayani.settype("Memorial Park ");
                InitialListStaffs.add(infobayani);
                bayani = 1;
            } else if (bayani == 1) {

            }

        } else if (InfoOfBayani.select == 0) {
            InitialListStaffs.remove(infobayani);

        }

        if (InfoOfCOF.select == 1) {

            if (cof == 0) {

                infocof.setname("Circle of Fun");
                infocof.settype("Amusement park");
                InitialListStaffs.add(infocof);
                cof = 1;
            } else if (cof == 1) {

            }
        } else if (InfoOfCOF.select == 0) {
            InitialListStaffs.remove(infocof);

        }

        if (InfoOfDam.select == 1) {

            if (dam == 0) {


                infodam.setname("La mesa Ecopark");
                infodam.settype("Eco Park ");
                InitialListStaffs.add(infodam);
                dam = 1;
            } else if (dam == 1) {

            }
        } else if (InfoOfDam.select == 0) {
            InitialListStaffs.remove(infodam);

        }


        if (InfoOfEast.select == 1) {

            if (east == 0) {

                infoeast.setname("Eastwood City");
                infoeast.settype("24/7 Shopping Mall");
                InitialListStaffs.add(infoeast);
                east = 1;
            } else if (east == 1) {

            }
        } else if (InfoOfEast.select == 0) {
            InitialListStaffs.remove(infoeast);

        }


        if (InfoOfEdsa.select == 1) {

            if (edsa == 0) {

                infoedsa.setname("Edsa Shrine");
                infoedsa.settype("Church");
                InitialListStaffs.add(infoedsa);
                edsa = 1;
            } else if (edsa == 1) {

            }

        } else if (InfoOfEdsa.select == 0) {
            InitialListStaffs.remove(infoedsa);

        }


        if (InfoOfMaginhawa.select == 1) {


            if (maginhawa == 0) {

                infomaginhawa.setname("Maginhawa Food Park");
                infomaginhawa.settype("Food park");
                InitialListStaffs.add(infomaginhawa);
                maginhawa = 1;
            } else if (maginhawa == 1) {

            }
        } else if (InfoOfMaginhawa.select == 0) {
            InitialListStaffs.remove(infomaginhawa);

        }


        if (InfoOfNinoy.select == 1) {


            if (ninoy == 0) {

                infoninoy.setname("Wildife Mini Zoo");
                infoninoy.settype("Rescue Center");
                InitialListStaffs.add(infoninoy);
                ninoy = 1;
            } else if (ninoy == 1) {

            } else if (InfoOfNinoy.select == 0) {
                InitialListStaffs.remove(infoninoy);

            }


        }

        if (InfoOfPeople.select == 1) {


            if (people == 0) {

                infopeople.setname("People Power Monument");
                infopeople.settype("Monument");
                InitialListStaffs.add(infopeople);
                people = 1;
            } else if (people == 1) {

            }

        } else if (InfoOfPeople.select == 0) {
            InitialListStaffs.remove(infopeople);

        }


        if (InfoOfQmc.select == 1) {


            if (qmc == 0) {

                infoqmc.setname("Quezon Memorial Circle");
                infoqmc.settype("National Park");
                InitialListStaffs.add(infoqmc);
                qmc = 1;


            } else if (qmc == 1) {

            }

        } else if (InfoOfQmc.select == 0) {
            InitialListStaffs.remove(infoqmc);

        }

        if (InfoOfVargas.select == 1) {


            if (vargas == 0) {

                infovargas.setname("Jorge B. Vargas");
                infovargas.settype("Museum");
                InitialListStaffs.add(infovargas);
                vargas = 1;
            } else if (vargas == 1) {

            } else if (InfoOfVargas.select == 0) {
                InitialListStaffs.remove(infovargas);

            }

        }
        if (InfoOfWatershed.select == 1) {


            if (watershed == 0) {

                infowatershed.setname("La mesa Watershed");
                infowatershed.settype("Eco Park");
                InitialListStaffs.add(infowatershed);
                watershed = 1;
            } else if (watershed == 1) {

            }


        } else if (InfoOfWatershed.select == 0) {
            InitialListStaffs.remove(infowatershed);

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
        Intent i = new Intent(this, ChoicesOfPlace.class);
        startActivity(i);
      //  finish();


    }

    @Override
    public void onBackPressed() {

       // finish();
        Intent i = new Intent(this, ChoicesOfPlace.class);
        startActivity(i);
    }



}
