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
 * Created by Amos on 9/25/2017.
 */
public class Pack1_manila extends Activity {
    private Button qp1;
    private TextView subtitleTextView, subDesc;
    private View descriptionLayout;

    String placeid;
    RecyclerView r2;
    TextView sr1;
    com.example.compoundlayout.CircleGradientRadioLayout p111, p112, p113, p114, p115;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.set1_manila);   //activity_choices_of_package
        progressDialog = new ProgressDialog(this);


        sr1 = (TextView) findViewById(R.id.r1);
        sr1.setVisibility(View.INVISIBLE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

        qp1 = (Button) findViewById(R.id.p1);
        qp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                traffic.packs = 1;
                Intent i = new Intent(Pack1_manila.this, traffic.class);
                startActivity(i);

            }
        });


        subtitleTextView = (TextView) findViewById(R.id.subtitle);
        subDesc = (TextView) findViewById(R.id.subdes);
        descriptionLayout = findViewById(R.id.description_layout);


        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_1), R.string.luneta, R.string.desc_luneta);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_22), R.string.casa, R.string.desc_casa);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_3), R.string.manilacathedral, R.string.desc_manilacathedral);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_4), R.string.american, R.string.desc_american);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_25), R.string.intramuros, R.string.desc_intramuros);

        p111 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_1);
        p112 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_22);
        p113 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_3);
        p114 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_4);
        p115 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_25);

        p111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJPxN-XiXKlzMRMpp1toc0Krc";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);

            }
        });

        p112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJgS96OD3KlzMR91wyTDiHHCg";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);
            }
        });


        p113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJeWcu0hfKlzMRnYOqfe-gowY";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);

            }
        });


        p114.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJKeIIzxG3lzMREPRXb7ccU40";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);

            }
        });

        p115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJsZziyUi2lzMR3jzSSV_20S0";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);

            }
        });


    }


    /**
     * Bind compound listener.
     *
     * @param compoundLayout Compound layout.
     * @param subtitle       Subtitle to set.
     * @param subdes         Subdes to set.
     */

    private void bindCompoundListener(final CompoundLayout compoundLayout, @StringRes final int subtitle , @StringRes final int subdes) {
        compoundLayout.setOnCheckedChangeListener(new CompoundLayout.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundLayout compoundLayout, boolean checked) {
                if (checked) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(Pack1_manila.this, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            subtitleTextView.setText(getString(subtitle));
                            subDesc.setText(getString(subdes));
                            descriptionLayout.startAnimation(AnimationUtils.loadAnimation(Pack1_manila.this, android.R.anim.fade_in));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    descriptionLayout.startAnimation(fadeOutAnimation);
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


    public RecyclerView.LayoutManager layoutManager;


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
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerAdapter = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

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

