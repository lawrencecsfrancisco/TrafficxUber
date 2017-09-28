package com.sumo.traffic.InfoOfPlaces_Manila;

import android.app.AlertDialog;
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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.Places;
import com.sumo.traffic.JSONParser;
import com.sumo.traffic.MarkerInfoActivity;
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
 * Created by Amos on 1/27/2017.
 */
public class SanAgustinChurch extends AppCompatActivity {

    public static int select;
    RelativeLayout wat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_manila_sanagustin);

/*        if (ChoicesOfPlace.open == 1) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            int width = dm.widthPixels;
            int height = dm.heightPixels;

            getWindow().setLayout((int)(width*.8),(int)(height*.8));
        }*/



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        recyclerView.setHasFixedSize(true);
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

    }

    public void artadd(View view) {

        select = 1;
        Toast.makeText(getApplicationContext(), "You added this as One of your Destination", Toast.LENGTH_LONG).show();


    }

    public void artdelete(View view) {

        select = 0;
        Toast.makeText(getApplicationContext(), "You unselected this destination", Toast.LENGTH_LONG).show();


    }


    ProgressDialog progressDialog;
    GoogleApiClient mGoogleApiClient;
    static TextView placeNameTV, placeTypeTV, placeAddressTV, placeNumberTV,placeIsOpenTV,placeOpeningHoursTV;
    private RatingBar ratingBar;
    private RelativeLayout pagerLayout;
    private String placeId;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    public RecyclerView recyclerView;
    public RecyclerView.Adapter recyclerAdapter;
    public RecyclerView.LayoutManager layoutManager;
    private List<String> reviewAuthorNames = new ArrayList<>(), authorTexts = new ArrayList<>();
    private Map<String,String> profilePictureUrl = new HashMap<>();
    private List<Integer> reviewRating = new ArrayList<>();
    String placeName, placeAddress, phoneNumber;
    List<Integer> placeType = new LinkedList<>();
    float rating;
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
                    + "ChIJyRjgIz3KlzMRMB6UgLCNQ58" + "&key=AIzaSyDK1zxUEp38e6sQYzJq6qGNKxdOUqUZR1Y";
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
                layoutManager = new LinearLayoutManager(SanAgustinChurch.this);
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
        // photoMetadataBuffer.release();
        //  mGoogleApiClient.disconnect();

    }




}
