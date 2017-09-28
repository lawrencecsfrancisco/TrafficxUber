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


public class MyHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
    //OUR VIEWS
    private final Context context;
    ImageView img;
    TextView nameTxt,posTxt;
    Bitmap bmp;
    RatingBar rb;
    ItemClickListener itemClickListener;
    public MyHolder2(View itemView) {
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
                intent = new Intent(context, NationalMuseum.class);

                break;
            case 1:
                intent =  new Intent(context, FilipinoChinese.class);
                break;
            case 2:
                intent =  new Intent(context, NayongFilipino.class);
                break;
            case 3:
                intent =  new Intent(context, BahayTsinoy.class);
                break;
            case 4:
                intent =  new Intent(context, SanAgustinChurch.class);
                break;
            case 5:
                intent =  new Intent(context, ManilaCathedral.class);
                break;
            case 6 :
                intent =  new Intent(context, CasaManila.class);
                break;
            case 7:
                intent =  new Intent(context, Luneta.class);
                break;

            case 8:
                intent =  new Intent(context, CCP.class);
                break;
            case 9:
                intent =  new Intent(context, PacoPark.class);
                break;


            case 10:
                intent =  new Intent(context, starcity.class);
                break;
            case 11:
                intent =  new Intent(context, coconutpalace.class);
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