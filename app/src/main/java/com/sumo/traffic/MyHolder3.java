package com.sumo.traffic;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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


public class MyHolder3 extends RecyclerView.ViewHolder implements View.OnClickListener {
    //OUR VIEWS
    private final Context context;
    ImageView img;
    TextView nameTxt,posTxt;
    Bitmap bmp;
    RatingBar rb;
    ItemClickListener itemClickListener;
    public MyHolder3(View itemView) {
        super(itemView);
        this.img= (ImageView) itemView.findViewById(R.id.playerImage);
        this.nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        this.posTxt= (TextView) itemView.findViewById(R.id.posTxt);
        // this.rb = (RatingBar)itemView.findViewById(R.id.ratingBar);
        context=itemView.getContext();
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        final Intent intent;
        switch (getAdapterPosition()){

            case 0:
                intent = new Intent(context, GoodShepherdPlace.class);

                break;
            case 1:
                intent =  new Intent(context, ArcaYard.class);
                break;
            case 2:
                intent =  new Intent(context, WrightPark.class);
                break;
            case 3:
                intent =  new Intent(context, MinesViewPark.class);
                break;
            case 4:
                intent =  new Intent(context, TheMansion.class);
                break;
            case 5:
                intent =  new Intent(context, DiplomatHotel.class);
                break;
            case 6 :
                intent =  new Intent(context, CampJohnHay.class);
                break;
            case 7:
                intent =  new Intent(context, GoodTasteRestaurant.class);
                break;

            case 8:
                intent =  new Intent(context, PinkSisterConvent.class);
                break;
            case 9:
                intent =  new Intent(context, FarmerDaughterRestaurant.class);
                break;


            case 10:
                intent =  new Intent(context, NightMarket.class);
                break;
            case 11:
                intent =  new Intent(context, STOBOSAMuralArts.class);
                break;

            default:
                intent =  new Intent(context, tests.class);
                break;
        }
        context.startActivity(intent);


        // this.itemClickListener.onItemClick(v,getLayoutPosition());

    }
    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }







}