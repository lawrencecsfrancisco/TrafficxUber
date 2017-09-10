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
public class Pack3 extends Activity {
    private Button qp3;
    private TextView subtitleTextView_2, subDesc_2;
    private View descriptionLayout2;


    String placeid;
    RecyclerView r3;
    TextView sr3;
    com.example.compoundlayout.CircleGradientRadioLayout p31, p32, p33, p34, p35;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.set3);   //activity_choices_of_package
        progressDialog = new ProgressDialog(this);


        sr3 = (TextView) findViewById(R.id.r3);
        sr3.setVisibility(View.INVISIBLE);


        r3 = (RecyclerView) findViewById(R.id.recyclerView3);
        r3.setHasFixedSize(true);

        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

        qp3 = (Button) findViewById(R.id.p3);
        qp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                traffic.packs = 3;
                Intent i = new Intent(Pack3.this, traffic.class);
                startActivity(i);
            }
        });


        subtitleTextView_2 = (TextView) findViewById(R.id.subtitle2);
        subDesc_2 = (TextView) findViewById(R.id.subdes2);
        descriptionLayout2 = findViewById(R.id.description_layout2);


        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_9), R.string.edsa, R.string.desc_edsa);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_10), R.string.maginhwa, R.string.desc_maginhwa);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_11), R.string.church, R.string.desc_church);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_12), R.string.up, R.string.desc_up);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_13), R.string.east, R.string.desc_east);

        p31 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_9);
        p32 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_10);
        p33 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_11);
        p34 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_12);
        p35 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_13);

        p31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r3.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJ83np5BjIlzMRQnvbQuvP320";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr3.setVisibility(View.VISIBLE);
            }
        });

        p32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r3.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJLyKHcHO3lzMRkPD3eaV8zo4";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr3.setVisibility(View.VISIBLE);
            }
        });


        p33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r3.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJh1SYgtW5lzMRgkVhXmhwt9E";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr3.setVisibility(View.VISIBLE);
            }
        });


        p34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r3.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJBURBCm63lzMR65XYe4mXKhw";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr3.setVisibility(View.VISIBLE);
            }
        });

        p35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r3.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJp79Jhh24lzMRGBBcLU5fzio";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr3.setVisibility(View.VISIBLE);
            }
        });


    }


    /**
     * Bind compound listener.
     *
     * @param compoundLayout Compound layout.
     * @param subtitle2       Subtitle to set.
     * @param subdes2         Subdes to set.
     */

    private void bindCompoundListener(final CompoundLayout compoundLayout, @StringRes final int subtitle2 , @StringRes final int subdes2) {
        compoundLayout.setOnCheckedChangeListener(new CompoundLayout.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundLayout compoundLayout, boolean checked) {
                if (checked) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(Pack3.this, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            subtitleTextView_2.setText(getString(subtitle2));
                            subDesc_2.setText(getString(subdes2));
                            descriptionLayout2.startAnimation(AnimationUtils.loadAnimation(Pack3.this, android.R.anim.fade_in));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    descriptionLayout2.startAnimation(fadeOutAnimation);
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
    public RecyclerView.Adapter recyclerAdapter3;
    public RecyclerView.LayoutManager layoutManager3;


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
                layoutManager3 = new LinearLayoutManager(context);
                r3.setLayoutManager(layoutManager3);
                recyclerAdapter3 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                r3.setAdapter(recyclerAdapter3);
                recyclerAdapter3.notifyDataSetChanged();

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
