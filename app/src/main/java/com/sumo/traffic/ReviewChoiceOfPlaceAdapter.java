package com.sumo.traffic;

/**
 * Created by lawre on 7/13/2017.
 * <p>
 * Created by william on 5/29/2017.
 */

/**
 * Created by william on 5/29/2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BW-33105 on 5/15/2017.
 */


public class ReviewChoiceOfPlaceAdapter extends RecyclerView.Adapter<ReviewChoiceOfPlaceAdapter.ViewHolder> {
    int lastPosition = -1;
    private List<placeitem> listStaffs;
    private Context context;




    public ReviewChoiceOfPlaceAdapter(List<placeitem> listStaffs, Context context) {
        // getting all the staffs
        this.listStaffs = listStaffs;
        this.context = context;


    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public ReviewChoiceOfPlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.placeitem, parent, false);
        return new ReviewChoiceOfPlaceAdapter.ViewHolder(v);
    }

    @Override

    public void onBindViewHolder(ReviewChoiceOfPlaceAdapter.ViewHolder holder, final int position) {
        final placeitem listStaff = listStaffs.get(position);

        holder.name.setText(listStaff.getname());
        holder.type.setText(listStaff.gettype());


        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;


/*
        if(listStaff.getPosition().matches("1")) {
            holder.textViewPosition.setText("Manager");
        }
        else if(listStaff.getPosition().matches("2")) {
            holder.textViewPosition.setText("Staff");
        }
        else if(listStaff.getPosition().matches("3")) {
            holder.textViewPosition.setText("Admin");
        }*/
        holder.linearLayoutStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder alertbox = new AlertDialog.Builder(v.getRootView().getContext());
                alertbox.setMessage("Do you want to delete this place?");
                alertbox.setTitle("Warning");


                alertbox.setNeutralButton("YES",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0,
                                                int arg1) {
                                Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show();
                                listStaffs.remove(position);
                                listStaff.getname();




                                if (listStaff.getname() == "UP Technohub") {
                                    InfoOfUp.select = 0;
                                }
                                if (listStaff.getname() == "Art in Island") {
                                    InfoOfArt.select = 0;
                                }
                                if (listStaff.getname() == "Parish of Holy Sacrifice") {
                                    InfoOfParish.select = 0;
                                }

                                if (listStaff.getname() == "Quezon Memorial Circle") {
                                    InfoOfQmc.select = 0;
                                }

                                if (listStaff.getname() == "Ateneo Art Gallery") {
                                    InfoOfAteneo.select = 0;
                                }
                                if (listStaff.getname() == "Bantayog ng Bayani") {
                                    InfoOfBayani.select = 0;
                                }
                                if (listStaff.getname() == "Circle of Fun") {
                                    InfoOfCOF.select = 0;
                                }
                                if (listStaff.getname() == "La mesa Ecopark") {
                                    InfoOfDam.select = 0;
                                }
                                if (listStaff.getname() == "Edsa Shrine") {
                                    InfoOfEdsa.select = 0;
                                }
                                if (listStaff.getname() == "Eastwood City") {
                                    InfoOfEast.select = 0;
                                }
                                if (listStaff.getname() == "Maginhawa Food Park") {
                                    InfoOfMaginhawa.select = 0;
                                }
                                if (listStaff.getname() == "Wildlife Mini Zoo") {
                                    InfoOfNinoy.select = 0;
                                }
                                if (listStaff.getname() == "People Power Monument") {
                                    InfoOfPeople.select = 0;
                                }
                                if (listStaff.getname() == "Jorge B. Vargas") {
                                    InfoOfVargas.select = 0;
                                }
                                if (listStaff.getname() == "La mesa Watershed") {
                                    InfoOfWatershed.select = 0;
                                }
                                notifyDataSetChanged();


                            }
                        });
                alertbox.show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return listStaffs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView type;


        public LinearLayout linearLayoutStaff;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            type = (TextView) itemView.findViewById(R.id.type);


            linearLayoutStaff = (LinearLayout) itemView.findViewById(R.id.linearLayoutStaff);
        }
    }
}