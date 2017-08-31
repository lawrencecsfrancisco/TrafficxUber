package com.sumo.traffic

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import com.sumo.traffic.AlarmCodes.AlarmReceiver
import com.sumo.traffic.model.ApplicationConstants
import java.util.ArrayList

class AlarmActivity : AppCompatActivity() {
    var adapter: HashMapAdapter? = null;
    internal var positions: Int = 0
 //  lateinit var destination: DestinationActivity



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_alarm)
        showData()
    }




    private fun showData(){
        val relLayout = findViewById(R.id.content_main) as RelativeLayout
        val listView = findViewById(R.id.list_view) as ListView


        // if no alarms, show the empty layout, otherwise the listview
        if (traffic.alarmClocks.size == 0){
            listView.visibility = View.GONE
            relLayout.visibility = View.VISIBLE
        } else {
            relLayout.visibility = View.GONE
            showListView(listView)


        }
    }

    private fun showListView(listView: ListView) {
        adapter = HashMapAdapter(traffic.alarmClocks)
        listView.visibility = View.VISIBLE
        listView.adapter = adapter

 /*       listView.setOnItemClickListener { parent, view, position, id ->
       //    editAlarm(id)
            val intent = Intent(applicationContext, poppers::class.java)
            intent.putExtra("currentMarker", positions  +2)
            intent.putExtra("alarm", positions )
            startActivity(intent)
            finish()

        }*/

        listView.setOnItemLongClickListener { parent, view, position, id ->
            registerForContextMenu(listView)
            openContextMenu(listView)
            positions = position
            true
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Cancel this notification")
      //  menu.add(0, v!!.id , 0, "Change it")
        menu.add(0, v!!.id, 0, "Delete it")

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.title == "Delete it") {
            // unsetAlarm(item.itemId )
                unsetAlarm(positions)
                traffic.timestoStay[poppers.currentMarkerIndex - 1] = "0"
                traffic.mins[poppers.currentMarkerIndex - 1] = "0"
                adapter!!.notifyDataSetChanged()


        }
     /*    else if (item?.title == "Change it") {
            editAlarm(item.itemId.toLong())

        }*/ else
            return false
        return true
    }

    private fun editAlarm(id: Long) {
        val intent = Intent(applicationContext, poppers::class.java)
        intent.putExtra("currentMarker", positions + 1)
        intent.putExtra("alarm", positions)
        startActivity(intent)
        finish()
    }

    private fun unsetAlarm(id: Int) {
        val alarm = traffic.alarmClocks[id ] // we get the alarm details
        val reminder = alarm[ApplicationConstants.REMINDER]
        val destination = alarm[ApplicationConstants.DESTINATION]

        val i = Intent(applicationContext, AlarmReceiver::class.java)
        i.putExtra(ApplicationConstants._ID, id) // the position should be the notification id
        i.putExtra(ApplicationConstants.REMINDER, reminder)
        i.putExtra(ApplicationConstants.DESTINATION, destination)
        val pi = PendingIntent.getBroadcast(applicationContext, id, i, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        //we cancel the notification
        alarmManager.cancel(pi)

        traffic.alarmClocks.remove(alarm)  // remove the alarm from the arraylist
    }
}
