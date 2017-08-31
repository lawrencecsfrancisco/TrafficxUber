package com.sumo.traffic.InfoOfPlaces;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.sumo.traffic.JSONParser;
import com.sumo.traffic.R;
import com.sumo.traffic.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Amos on 12/22/2016.
 */
public class InfoOfAteneo extends AppCompatActivity {
static int open = 0;

    Button add;
    public static int select = 0;
    RelativeLayout wat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_ateneo);




        add = (Button) findViewById(R.id.ad);


      wat = (RelativeLayout) findViewById(R.id.hiders);
        wat.setVisibility(View.GONE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        recyclerView.setHasFixedSize(true);
       FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();



    }






    public void artadd(View view)
    {

        select = 1;
        Toast.makeText(getApplicationContext(), "You added Ateneo as One of your Destination", Toast.LENGTH_LONG).show();

        wat.setVisibility(View.VISIBLE);

    }

    public void artdelete(View view) {

        select = 0;
        Toast.makeText(getApplicationContext(), "You unselected this destination", Toast.LENGTH_LONG).show();


    }


    public void p1(View view)
    {
        Intent i = new Intent(InfoOfAteneo.this,InfoOfMaginhawa.class);
        startActivity(i);
        finish();
    }

    public void p2(View view)
    {
        Intent i = new Intent(InfoOfAteneo.this,InfoOfQmc.class);
        startActivity(i);
        finish();

    }

    public void p3(View view)
    {
        Intent i = new Intent(InfoOfAteneo.this,InfoOfUp.class);
        startActivity(i);
        finish();


    }


    ProgressDialog progressDialog;
    GoogleApiClient mGoogleApiClient;
    private ViewPager viewPager;
    public RecyclerView recyclerView;
    public RecyclerView.Adapter recyclerAdapter;
    public RecyclerView.LayoutManager layoutManager;
    private List<String> reviewAuthorNames = new ArrayList<>(), authorTexts = new ArrayList<>();
    private Map<String,String> profilePictureUrl = new HashMap<>();
    private List<Integer> reviewRating = new ArrayList<>();
    ArrayList<BitmapDrawable> bitmapDrawables = new ArrayList<>();

    PlacePhotoMetadataBuffer photoMetadataBuffer;

    private class FetchReviews extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... args) {
            String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid="
                    + "ChIJQdDOsX-3lzMRsMd8b7e3uDk" + "&key=AIzaSyDK1zxUEp38e6sQYzJq6qGNKxdOUqUZR1Y";
            JSONParser jsonParser = new JSONParser();
            String json = jsonParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(String json) {
            try {
                final JSONObject jsonObject = new JSONObject(json);
                JSONObject result = jsonObject.getJSONObject("result");
                JSONArray reviews = result.getJSONArray("reviews");
                for (int i = 0; i < reviews.length(); i++) {
                    JSONObject singleReviews = reviews.getJSONObject(i);
                    //    JSONObject aspects = singleReviews.getJSONArray("aspects").getJSONObject(0);
                    reviewRating.add(singleReviews.getInt("rating"));
                    String authorName = singleReviews.getString("author_name");
                    reviewAuthorNames.add(authorName);
                    if(singleReviews.has("profile_photo_url")){
                        String profilePicture = singleReviews.getString("profile_photo_url");
                        //  String url ="http:".concat(profilePicture);
                        profilePictureUrl.put(authorName,profilePicture);
                    } else profilePictureUrl.put(authorName,null);
                    authorTexts.add(singleReviews.getString("text"));
                }
                layoutManager = new LinearLayoutManager(InfoOfAteneo.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerAdapter = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerView.setAdapter(recyclerAdapter);
                if (progressDialog.isShowing()) progressDialog.dismiss();
                Log.d("ZXC2",""+result);
                Log.d("ZXC2",""+reviews);
            } catch (Exception e) {
                Log.d("ZXC2",""+e);

                //couldnt fetch the reviews datas, what to do? I'll show an alert dialog for now
            /*    AlertDialog.Builder builder = new AlertDialog.Builder(MarkerInfoActivity.this);
                builder.setTitle("Error retrieving reviews data")
                        .setMessage("This might either be because of a faulty internet connection or"
                                + " simply because reviews are not available for this place")
                        .setPositiveButton("Ok", null);
                AlertDialog dialog = builder.create();
                dialog.show();*/
            }
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        //if list is not cleared, memory is quickly consumed
        bitmapDrawables = new ArrayList<>();
        reviewAuthorNames = new ArrayList<>();
        authorTexts = new ArrayList<>();
        profilePictureUrl = new HashMap<>();
        reviewRating = new ArrayList<>();
        if (viewPager != null) viewPager = new ViewPager(this);
     //   photoMetadataBuffer.release();
       // mGoogleApiClient.disconnect();

    }

}