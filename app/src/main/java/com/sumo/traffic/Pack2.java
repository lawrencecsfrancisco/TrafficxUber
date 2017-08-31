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
public class Pack2 extends Activity {
    private Button qp2;
    private TextView subtitleTextView_1, subDesc_1;
    private View descriptionLayout1;

    static int packs;
    String placeid;
    RecyclerView r2;
    TextView sr2;
    com.example.compoundlayout.CircleGradientRadioLayout p21, p22, p23, p24, p25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.set2);   //activity_choices_of_package
        progressDialog = new ProgressDialog(this);


        sr2 = (TextView) findViewById(R.id.r2);
        sr2.setVisibility(View.INVISIBLE);


        r2 = (RecyclerView) findViewById(R.id.recyclerView2);
        r2.setHasFixedSize(true);

        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

        qp2 = (Button) findViewById(R.id.p2);
        qp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                packs = 2;
                Intent i = new Intent(Pack2.this, traffic.class);
                startActivity(i);
            }
        });


        subtitleTextView_1 = (TextView) findViewById(R.id.subtitle1);
        subDesc_1 = (TextView) findViewById(R.id.subdes1);
        descriptionLayout1 = findViewById(R.id.description_layout1);


        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_5), R.string.balara, R.string.desc_balara);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_2), R.string.qch, R.string.desc_heritage);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_6), R.string.uptown, R.string.desc_uptown);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_7), R.string.stamaria, R.string.desc_stamaria);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_8), R.string.ateneo, R.string.desc_ateneo);

        p21 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_5);
        p22 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_2);
        p23 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_6);
        p24 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_7);
        p25 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_8);

        p21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r2.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJmad1wOG5lzMR3OKejNp3HIg";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr2.setVisibility(View.VISIBLE);
            }
        });

        p22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r2.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJCykyhw63lzMRDY_BQBLbE8o";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr2.setVisibility(View.VISIBLE);
            }
        });


        p23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r2.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJHao_OWO3lzMRjOuMs_XND84";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr2.setVisibility(View.VISIBLE);
            }
        });


        p24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r2.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJazWVwHy3lzMRAUHR5Esc9AA";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr2.setVisibility(View.VISIBLE);
            }
        });

        p25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r2.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJQdDOsX-3lzMRsMd8b7e3uDk";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr2.setVisibility(View.VISIBLE);
            }
        });


    }


    /**
     * Bind compound listener.
     *
     * @param compoundLayout Compound layout.
     * @param subtitle1       Subtitle to set.
     * @param subdes1         Subdes to set.
     */

    private void bindCompoundListener(final CompoundLayout compoundLayout, @StringRes final int subtitle1 , @StringRes final int subdes1) {
        compoundLayout.setOnCheckedChangeListener(new CompoundLayout.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundLayout compoundLayout, boolean checked) {
                if (checked) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(Pack2.this, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            subtitleTextView_1.setText(getString(subtitle1));
                            subDesc_1.setText(getString(subdes1));
                            descriptionLayout1.startAnimation(AnimationUtils.loadAnimation(Pack2.this, android.R.anim.fade_in));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    descriptionLayout1.startAnimation(fadeOutAnimation);
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

    public RecyclerView.Adapter recyclerAdapter2;
    public RecyclerView.LayoutManager layoutManager2;


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
                layoutManager2 = new LinearLayoutManager(context);
                r2.setLayoutManager(layoutManager2);
                recyclerAdapter2 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                r2.setAdapter(recyclerAdapter2);
                recyclerAdapter2.notifyDataSetChanged();

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
