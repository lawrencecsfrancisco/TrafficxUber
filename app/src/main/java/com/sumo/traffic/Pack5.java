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
import android.widget.Toast;

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
public class Pack5 extends Activity {
    private Button qp5;
    private TextView subtitleTextView_4, subDesc_4;
    private View descriptionLayout4;

    static int packs;
    String placeid;
    RecyclerView r5;
    TextView sr5;
    com.example.compoundlayout.CircleGradientRadioLayout p51, p52, p53, p54, p55;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.set5);   //activity_choices_of_package
        progressDialog = new ProgressDialog(this);


        sr5 = (TextView) findViewById(R.id.r5);
        sr5.setVisibility(View.INVISIBLE);


        r5 = (RecyclerView) findViewById(R.id.recyclerView5);
        r5.setHasFixedSize(true);

        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

        qp5 = (Button) findViewById(R.id.p5);
        qp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                packs = 5;
                Intent i = new Intent(Pack5.this, traffic.class);
                startActivity(i);
            }
        });


        subtitleTextView_4 = (TextView) findViewById(R.id.subtitle4);
        subDesc_4 = (TextView) findViewById(R.id.subdes4);
        descriptionLayout4 = findViewById(R.id.description_layout4);


        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_18), R.string.sining, R.string.desc_sining);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_19), R.string.fernwood, R.string.desc_fernwood);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_20), R.string.armed, R.string.desc_armed);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_21), R.string.mystery, R.string.desc_mystery);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_24), R.string.monasterio, R.string.desc_monasterio);

        p51 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_18);
        p52 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_19);
        p53 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_20);
        p54 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_21);
        p55 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_24);

        p51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r5.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                Toast.makeText(context, "No reviews", Toast.LENGTH_SHORT).show();
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr5.setVisibility(View.VISIBLE);
            }
        });

        p52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r5.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJ5222gju3lzMRTgrD9gxfVko";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr5.setVisibility(View.VISIBLE);
            }
        });


        p53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r5.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJK725zei3lzMRdjehQsQsUKw";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr5.setVisibility(View.VISIBLE);
            }
        });


        p54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r5.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJ3bGhD_i3lzMROoN7udn8v30";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr5.setVisibility(View.VISIBLE);
            }
        });

        p55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r5.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJzVQIaoa3lzMR5AnOW2Sdfd0";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr5.setVisibility(View.VISIBLE);
            }
        });


    }


    /**
     * Bind compound listener.
     *
     * @param compoundLayout Compound layout.
     * @param subtitle4       Subtitle to set.
     * @param subdes4         Subdes to set.
     */

    private void bindCompoundListener(final CompoundLayout compoundLayout, @StringRes final int subtitle4 , @StringRes final int subdes4) {
        compoundLayout.setOnCheckedChangeListener(new CompoundLayout.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundLayout compoundLayout, boolean checked) {
                if (checked) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(Pack5.this, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            subtitleTextView_4.setText(getString(subtitle4));
                            subDesc_4.setText(getString(subdes4));
                            descriptionLayout4.startAnimation(AnimationUtils.loadAnimation(Pack5.this, android.R.anim.fade_in));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    descriptionLayout4.startAnimation(fadeOutAnimation);
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
    public RecyclerView.Adapter recyclerAdapter5;
    public RecyclerView.LayoutManager layoutManager5;


    private List<String> reviewAuthorNames = new ArrayList<>(),authorTexts = new ArrayList<>();
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
                layoutManager5 = new LinearLayoutManager(context);
                r5.setLayoutManager(layoutManager5);
                recyclerAdapter5 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                r5.setAdapter(recyclerAdapter5);
                recyclerAdapter5.notifyDataSetChanged();

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

