package com.sumo.traffic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.compoundlayout.CompoundLayout;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amos on 8/24/2017.
 */
public class Pack4 extends Activity {
    private Button qp4;
    private TextView subtitleTextView_3, subDesc_3;
    private View descriptionLayout3;


    String placeid;
    RecyclerView r4;
    TextView sr4;
    com.example.compoundlayout.CircleGradientRadioLayout p41, p42, p43, p44, p45;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.set4);   //activity_choices_of_package
        progressDialog = new ProgressDialog(this);


        sr4 = (TextView) findViewById(R.id.r4);
        sr4.setVisibility(View.INVISIBLE);


        r4 = (RecyclerView) findViewById(R.id.recyclerView4);
        r4.setHasFixedSize(true);

        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

        qp4 = (Button) findViewById(R.id.p4);
        qp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                traffic.packs = 4;
                Intent i = new Intent(Pack4.this, traffic.class);
                startActivity(i);
            }
        });


        subtitleTextView_3 = (TextView) findViewById(R.id.subtitle3);
        subDesc_3 = (TextView) findViewById(R.id.subdes3);
        descriptionLayout3 = findViewById(R.id.description_layout3);


        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_14), R.string.bayani, R.string.desc_bayani);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_15), R.string.zoo, R.string.desc_zoo);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_16), R.string.rita, R.string.desc_ritaa);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_17), R.string.pagasa, R.string.desc_pagasa);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_23), R.string.cubaoexpo, R.string.desc_cubaoexpo);

        p41 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_14);
        p42 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_15);
        p43 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_16);
        p44 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_17);
        p45 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_23);

        p41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r4.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJ2yEQTQe3lzMRbfDgt60K770";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr4.setVisibility(View.VISIBLE);
            }
        });

        p42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r4.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJAeHvngW3lzMRikJHv1z5cVI";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr4.setVisibility(View.VISIBLE);
            }
        });


        p43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r4.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJH0W3P_62lzMRMg5dO-FkrKI";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr4.setVisibility(View.VISIBLE);
            }
        });


        p44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r4.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJn9JPuQe3lzMRn3Wi8utObiI";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr4.setVisibility(View.VISIBLE);
            }
        });

        p45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r4.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJ7TL-17-3lzMRxP6C7aZp64A";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr4.setVisibility(View.VISIBLE);
            }
        });


    }


    /**
     * Bind compound listener.
     *
     * @param compoundLayout Compound layout.
     * @param subtitle3       Subtitle to set.
     * @param subdes3         Subdes to set.
     */

    private void bindCompoundListener(final CompoundLayout compoundLayout, @StringRes final int subtitle3 , @StringRes final int subdes3) {
        compoundLayout.setOnCheckedChangeListener(new CompoundLayout.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundLayout compoundLayout, boolean checked) {
                if (checked) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(Pack4.this, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            subtitleTextView_3.setText(getString(subtitle3));
                            subDesc_3.setText(getString(subdes3));
                            descriptionLayout3.startAnimation(AnimationUtils.loadAnimation(Pack4.this, android.R.anim.fade_in));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    descriptionLayout3.startAnimation(fadeOutAnimation);
                }
            }
        });
    }






    final Context context = this;
    ProgressDialog progressDialog;
    GoogleApiClient mGoogleApiClient;
    private ViewPager viewPager;
    public RecyclerView recyclerView;

    public RecyclerView.Adapter recyclerAdapter;
    public RecyclerView.Adapter recyclerAdapter4;
    public RecyclerView.LayoutManager layoutManager4;


    private List<String> reviewAuthorNames = new ArrayList<>(),
            authorTexts = new ArrayList<>();
    private Map<String, String> profilePictureUrl = new HashMap<>();
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
                    + placeid + "&key=AIzaSyDK1zxUEp38e6sQYzJq6qGNKxdOUqUZR1Y";
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
                    if (singleReviews.has("profile_photo_url")) {
                        String profilePicture = singleReviews.getString("profile_photo_url");
                        //  String url ="http:".concat(profilePicture);
                        profilePictureUrl.put(authorName, profilePicture);
                    } else profilePictureUrl.put(authorName, null);
                    authorTexts.add(singleReviews.getString("text"));
                }
                layoutManager4 = new LinearLayoutManager(context);
                r4.setLayoutManager(layoutManager4);
                recyclerAdapter4 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                r4.setAdapter(recyclerAdapter4);
                recyclerAdapter4.notifyDataSetChanged();

                if (progressDialog.isShowing()) progressDialog.dismiss();
                Log.d("ZXC2", "" + result);
                Log.d("ZXC2", "" + reviews);
            } catch (Exception e) {
                Log.d("ZXC2", "" + e);

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
