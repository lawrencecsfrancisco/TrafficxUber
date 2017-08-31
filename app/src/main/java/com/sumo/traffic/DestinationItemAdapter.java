package com.sumo.traffic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sumo.traffic.AlarmCodes.AlarmReceiver;
import com.sumo.traffic.model.ApplicationConstants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by dalem on 11/17/2016.
 */

public class DestinationItemAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    private traffic traffic;
    private DestinationActivity destination;


    public DestinationItemAdapter(ArrayList<String> list, Context context, DestinationActivity destination) {
        this.list = list;
        this.context = context;
        this.destination = destination;



    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {

        return list.get(pos);

    }

    @Override
    public long getItemId(int pos) {
        //return list.get(pos).getId();
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.destination_item, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button editBtn = (Button)view.findViewById(R.id.edit_btn);

 /*       if (traffic.nodelete == 1)
        {
            deleteBtn.setVisibility(View.INVISIBLE);
        }
        else if (traffic.nodelete == 0)
        {
            deleteBtn.setVisibility(View.VISIBLE);
        }*/


        Resources res = context.getResources();
        Drawable drawable = res.getDrawable(R.drawable.aa_edit);
        editBtn.setBackground(drawable);

        Drawable drawable2 = res.getDrawable(R.drawable.aa_delete);
        deleteBtn.setBackground(drawable2);


        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                if (position > 0) {
                    traffic.markers.get(position).remove();

                    traffic.distances.remove(position);
                    traffic.durations.remove(position);
                    traffic.mList.remove(position);
                    traffic.points.remove(position);
                    traffic.markers.remove(position);
                    traffic.timestoStay.remove(position);
                    traffic.reminders.remove(position);
                    list.remove(position);
                    if (!traffic.alarmClocks.isEmpty()) {
                        if (position - 1 >= 0 && position - 1 < traffic.alarmClocks.size()) {
                            unsetAlarm(position - 1);
                            traffic.alarmClocks.remove(position - 1);
                            Toast.makeText(context, ""+(position - 1), Toast.LENGTH_SHORT).show();
                        }
                    }

                    notifyDataSetChanged();
                } else if (position == 0) {
                    unsetAlarm(position);
                    traffic.alarmClocks.remove(position);
                    notifyDataSetChanged();
                }
            }
        });



        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent i = new Intent(destination , poppers.class);
                i.putExtra("currentMarker", position+1);
                i.putExtra("alarm", position);
                poppers.posit = position;
                destination.startActivityForResult(i, 100);
                //do something
                //notifyDataSetChanged();
            }
        });

        return view;
    }

    private void unsetAlarm(int position){
        HashMap<String, String> alarm = traffic.alarmClocks.get(position); // we get the alarm details
        String reminder = alarm.get(ApplicationConstants.REMINDER);
        String destination = alarm.get(ApplicationConstants.DESTINATION);

        Intent i;
        i = new Intent(context, AlarmReceiver.class);
        i.putExtra(ApplicationConstants._ID, position); // the position should be the notification id
        i.putExtra(ApplicationConstants.REMINDER, reminder);
        i.putExtra(ApplicationConstants.DESTINATION, destination);
        PendingIntent pi = PendingIntent.getBroadcast(context, position, i, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        //we cancel the notification
        alarmManager.cancel(pi);
    }
}
