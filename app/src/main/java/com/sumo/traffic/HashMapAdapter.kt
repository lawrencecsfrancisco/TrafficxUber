package com.sumo.traffic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.sumo.traffic.model.ApplicationConstants

/**
 * Created by alessio on 26/07/17.
 */

class HashMapAdapter(val mList: ArrayList<HashMap<String, String>>) : BaseAdapter() {

    override fun getItem(position: Int): HashMap<String, String> {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return mList[position][ApplicationConstants._ID]!!.toLong()  // the !! means that the value can't be null
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val result: View

        if (convertView == null) {
            result = LayoutInflater.from(parent!!.context).inflate(R.layout.notifications_layout,
                    parent, false)
        } else {
            result = convertView
        }

        val alarmList = getItem(position)
        val hourPicked = alarmList[ApplicationConstants.HOUR]!!.toInt();
        val minutesPicked = alarmList[ApplicationConstants.MINUTE]!!.toInt();


        val destinationText = result.findViewById(R.id.destination_main) as TextView
        val hourText = result.findViewById(R.id.hour_main) as TextView
        val minuteText = result.findViewById(R.id.minute_main) as TextView
        // In kotlin you can use text instead of setText or getText, really nice :D
        hourText.text = if (hourPicked < 10)
            "0$hourPicked" else hourPicked.toString()
        minuteText.text =
                if (minutesPicked < 10)
                    "0$minutesPicked" else minutesPicked.toString()
        destinationText.text = alarmList[ApplicationConstants.DESTINATION]

        return result
    }
}