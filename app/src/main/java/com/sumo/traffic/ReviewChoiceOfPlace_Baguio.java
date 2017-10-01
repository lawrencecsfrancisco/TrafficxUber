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
import com.sumo.traffic.InfoOfPlaces_Baguio.ArcaYard;
import com.sumo.traffic.InfoOfPlaces_Baguio.CampJohnHay;
import com.sumo.traffic.InfoOfPlaces_Baguio.DiplomatHotel;
import com.sumo.traffic.InfoOfPlaces_Baguio.FarmerDaughterRestaurant;
import com.sumo.traffic.InfoOfPlaces_Baguio.GoodShepherdPlace;
import com.sumo.traffic.InfoOfPlaces_Baguio.GoodTasteRestaurant;
import com.sumo.traffic.InfoOfPlaces_Baguio.MinesViewPark;
import com.sumo.traffic.InfoOfPlaces_Baguio.NightMarket;
import com.sumo.traffic.InfoOfPlaces_Baguio.PinkSisterConvent;
import com.sumo.traffic.InfoOfPlaces_Baguio.STOBOSAMuralArts;
import com.sumo.traffic.InfoOfPlaces_Baguio.TheMansion;
import com.sumo.traffic.InfoOfPlaces_Baguio.WrightPark;
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

public class ReviewChoiceOfPlace_Baguio extends AppCompatActivity {

    static RecyclerView recyclerViewStaff;
    static RecyclerView.Adapter adapterStaff;
    static List<placeitem> InitialListStaffs;

    int arcayard = 0;
    int campjohnhay = 0;
    int diplomathotel = 0;
    int farmerdaughter = 0;
    int goodshepherplace = 0;
    int goodtaste = 0;
    int minesviewpark = 0;
    int nightmarket = 0;
    int pinksister = 0;
    int stobosa = 0;
    int themansion = 0;
    int wrightpark = 0;

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

        if (ArcaYard.select == 1) {
            if (arcayard == 0) {

                infoup.setname("Arca's Yard");
                infoup.settype("Cafe");
                InitialListStaffs.add(infoup);
                arcayard= 1;
            } else if (arcayard== 1) {

            }
        } else if (ArcaYard.select == 0) {
            InitialListStaffs.remove(infoup);

        }


        if (CampJohnHay.select == 1) {
            if (campjohnhay == 0) {

                infoart.setname("Camp John Hay");
                infoart.settype("Hotels");
                InitialListStaffs.add(infoart);
                campjohnhay = 1;

            } else if (campjohnhay == 1) {

            }
        } else if (CampJohnHay.select == 0) {
            InitialListStaffs.remove(infoart);

        }


        if (DiplomatHotel.select == 1) {
            if (diplomathotel == 0) {

                infoparish.setname("Diplomat Hotel");
                infoparish.settype("Historical place");
                InitialListStaffs.add(infoparish);
                diplomathotel = 1;

            } else if (diplomathotel == 1) {

            }
        } else if (DiplomatHotel.select == 0) {
            InitialListStaffs.remove(infoparish);

        }


        if (FarmerDaughterRestaurant.select == 1) {

            if (farmerdaughter == 0) {

                infoateneo.setname("Farmer's Daughter Restaurant");
                infoateneo.settype("Restaurant");
                InitialListStaffs.add(infoateneo);
                farmerdaughter = 1;
            } else if (farmerdaughter == 1) {

            }

        } else if (FarmerDaughterRestaurant.select == 0) {
            InitialListStaffs.remove(infoateneo);

        }

        if (GoodShepherdPlace.select == 1) {
            if (goodshepherplace == 0) {

                infobayani.setname("Good Shepherd");
                infobayani.settype("Asian Grocery Store");
                InitialListStaffs.add(infobayani);
                goodshepherplace = 1;
            } else if (goodshepherplace == 1) {

            }

        } else if (GoodShepherdPlace.select == 0) {
            InitialListStaffs.remove(infobayani);

        }

        if (GoodTasteRestaurant.select == 1) {

            if (goodtaste== 0) {

                infocof.setname("Good Taste Restaurant");
                infocof.settype("Restaurant");
                InitialListStaffs.add(infocof);
                goodtaste = 1;
            } else if (goodtaste == 1) {

            }
        } else if (GoodTasteRestaurant.select == 0) {
            InitialListStaffs.remove(infocof);

        }

        if (MinesViewPark.select == 1) {

            if (minesviewpark == 0) {


                infodam.setname("Mines View Park");
                infodam.settype("Overlook Park");
                InitialListStaffs.add(infodam);
                minesviewpark = 1;
            } else if (minesviewpark == 1) {

            }
        } else if (MinesViewPark.select == 0) {
            InitialListStaffs.remove(infodam);

        }


        if (NightMarket.select == 1) {

            if (nightmarket ==0) {

                infoeast.setname("Baguio Night Market");
                infoeast.settype("Market");
                InitialListStaffs.add(infoeast);
                nightmarket = 1;
            } else if (nightmarket == 1) {

            }
        } else if (NightMarket.select == 0) {
            InitialListStaffs.remove(infoeast);

        }


        if (PinkSisterConvent.select == 1) {

            if (pinksister == 0) {

                infoedsa.setname("Pink Sisters Convent");
                infoedsa.settype("Convent");
                InitialListStaffs.add(infoedsa);
                pinksister = 1;
            } else if (pinksister == 1) {

            }

        } else if (PinkSisterConvent.select == 0) {
            InitialListStaffs.remove(infoedsa);

        }


        if (STOBOSAMuralArts.select == 1) {


            if (stobosa== 0) {

                infomaginhawa.setname("Stobosa Mural Art Work");
                infomaginhawa.settype("Colored House");
                InitialListStaffs.add(infomaginhawa);
                stobosa = 1;
            } else if (stobosa == 1) {

            }
        } else if (STOBOSAMuralArts.select == 0) {
            InitialListStaffs.remove(infomaginhawa);

        }


        if (TheMansion.select == 1) {


            if (themansion == 0) {

                infoninoy.setname("The Mansion");
                infoninoy.settype("Monument");
                InitialListStaffs.add(infoninoy);
                themansion = 1;
            } else if (themansion == 1) {

            } else if (TheMansion.select == 0) {
                InitialListStaffs.remove(infoninoy);

            }


        }

        if (WrightPark.select == 1) {


            if (wrightpark == 0) {

                infopeople.setname("Wright Park");
                infopeople.settype("Park");
                InitialListStaffs.add(infopeople);
                wrightpark = 1;
            } else if (wrightpark == 1) {

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
        Intent i = new Intent(this, ChoicesOfBaguio.class);
        startActivity(i);
        //  finish();


    }

    @Override
    public void onBackPressed() {

        // finish();
        Intent i = new Intent(this, ChoicesOfBaguio.class);
        startActivity(i);
    }



}
