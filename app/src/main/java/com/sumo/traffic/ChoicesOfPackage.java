package com.sumo.traffic;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.compoundlayout.CompoundLayout;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.kyo.expandablelayout.ExpandableLayout;
import com.sumo.traffic.InfoOfPlaces.InfoOfUp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChoicesOfPackage extends Activity {
    private Button qp1, qp2, qp3, qp4, qp5;
    private TextView subtitleTextView, subDesc, subtitleTextView_1, subDesc_1, subtitleTextView_2, subDesc_2, subtitleTextView_3, subDesc_3, subtitleTextView_4, subDesc_4;
    private View descriptionLayout, descriptionLayout_1, descriptionLayout_2, descriptionLayout_3, descriptionLayout_4;
    static int packs;
    static int wats;
    String placeid;
    ImageView mp1;
    RecyclerView r2,r3,r4,r5;
    TextView sr1,sr2,sr3,sr4,sr5;
    com.example.compoundlayout.CircleGradientRadioLayout p11, p12, p13, p14, p15;
    com.example.compoundlayout.CircleGradientRadioLayout p21, p22, p23, p24, p25;
    com.example.compoundlayout.CircleGradientRadioLayout p31, p32, p33, p34, p35;
    com.example.compoundlayout.CircleGradientRadioLayout p41, p42, p43, p44, p45;
    com.example.compoundlayout.CircleGradientRadioLayout p51, p52, p53, p54, p55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_choices_of_package);
        progressDialog = new ProgressDialog(this);

        sr1 = (TextView) findViewById(R.id.r1);
        sr2 = (TextView) findViewById(R.id.r2);
        sr3 = (TextView) findViewById(R.id.r3);
        sr4 = (TextView) findViewById(R.id.r4);
        sr5 = (TextView) findViewById(R.id.r5);

        sr1.setVisibility(View.INVISIBLE);
        sr2.setVisibility(View.INVISIBLE);
        sr3.setVisibility(View.INVISIBLE);
        sr4.setVisibility(View.INVISIBLE);
        sr5.setVisibility(View.INVISIBLE);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
       r2 = (RecyclerView) findViewById(R.id.recyclerView2);
        r2.setHasFixedSize(true);
        r3 = (RecyclerView) findViewById(R.id.recyclerView3);
        r3.setHasFixedSize(true);
        r4 = (RecyclerView) findViewById(R.id.recyclerView4);
        r4.setHasFixedSize(true);
        r5 = (RecyclerView) findViewById(R.id.recyclerView5);
        r5.setHasFixedSize(true);

        progressDialog.setMessage("Fetching Data, Please Wait...");
        progressDialog.show();
        placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
        FetchReviews fetchReviews = new FetchReviews();
        fetchReviews.execute();

        qp1 = (Button) findViewById(R.id.p1);
        qp1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                packs = 1;
                Intent i = new Intent(ChoicesOfPackage.this, traffic.class);
                startActivity(i);


            }
        });
        qp2 = (Button) findViewById(R.id.p2);
        qp2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                packs = 2;
                Intent i = new Intent(ChoicesOfPackage.this, traffic.class);
                startActivity(i);
            }
        });
        qp3 = (Button) findViewById(R.id.p3);
        qp3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                packs = 3;
                Intent i = new Intent(ChoicesOfPackage.this, traffic.class);
                startActivity(i);
            }
        });
        qp4 = (Button) findViewById(R.id.p4);
        qp4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                packs = 4;
                Intent i = new Intent(ChoicesOfPackage.this, traffic.class);
                startActivity(i);
            }
        });
        qp5 = (Button) findViewById(R.id.p5);
        qp5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                packs = 5;
                Intent i = new Intent(ChoicesOfPackage.this, traffic.class);
                startActivity(i);
            }
        });


        subtitleTextView = (TextView) findViewById(R.id.subtitle);
        subDesc = (TextView) findViewById(R.id.subdes);
        descriptionLayout = findViewById(R.id.description_layout);

        subtitleTextView_1 = (TextView) findViewById(R.id.subtitle1);
        subDesc_1 = (TextView) findViewById(R.id.subdes1);
        descriptionLayout_1 = findViewById(R.id.description_layout1);

        subtitleTextView_2 = (TextView) findViewById(R.id.subtitle2);
        subDesc_2 = (TextView) findViewById(R.id.subdes2);
        descriptionLayout_2 = findViewById(R.id.description_layout2);

        subtitleTextView_3 = (TextView) findViewById(R.id.subtitle3);
        subDesc_3 = (TextView) findViewById(R.id.subdes3);
        descriptionLayout_3 = findViewById(R.id.description_layout3);

        subtitleTextView_4 = (TextView) findViewById(R.id.subtitle4);
        subDesc_4 = (TextView) findViewById(R.id.subdes4);
        descriptionLayout_4 = findViewById(R.id.description_layout4);


        bindCompoundListener((CompoundLayout)
                        findViewById(R.id.profile_1), R.string.artin, R.string.desc_artin, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_22), R.string.santodomingo, R.string.desc_domingo, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_2), R.string.qch, R.string.desc_heritage, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_3), R.string.qmx, R.string.desc_qmx, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_4), R.string.cof, R.string.desc_cof, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_25), R.string.amoranto, R.string.desc_amoranto, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        p11 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_1);
        p12 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_22);
        p13 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_3);
        p14 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_4);
        p15 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_25);

        p11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJ5UTioJW3lzMRCVEsXIinoQY";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);

            }
        });

        p12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJZyfdAEC2lzMRjdk72SmJsyw";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);
            }
        });


        p13.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                reviewAuthorNames.clear();
                authorTexts.clear();
                profilePictureUrl.clear();
                reviewRating.clear();
                progressDialog.setMessage("Fetching Data, Please Wait...");
                progressDialog.show();
                placeid = "ChIJJRUU-w23lzMRkCSPWgARC-A";
                FetchReviews fetchReviews = new FetchReviews();
                fetchReviews.execute();
                sr1.setVisibility(View.VISIBLE);

            }
        });


        p14.setOnClickListener(new OnClickListener() {
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

        p15.setOnClickListener(new OnClickListener() {
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


        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_5), R.string._, R.string._, R.string.balara, R.string.desc_balara, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_2), R.string._, R.string._, R.string.qch, R.string.desc_heritage, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_6), R.string._, R.string._, R.string.uptown, R.string.desc_uptown, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_7), R.string._, R.string._, R.string.stamaria, R.string.desc_stamaria, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_8), R.string._, R.string._, R.string.ateneo, R.string.desc_ateneo, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._);
        p21 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_5);
        p22 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_2);
        p23 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_6);
        p24 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_7);
        p25 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_8);


        p21.setOnClickListener(new OnClickListener() {
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

        p22.setOnClickListener(new OnClickListener() {
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


        p23.setOnClickListener(new OnClickListener() {
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


        p24.setOnClickListener(new OnClickListener() {
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

        p25.setOnClickListener(new OnClickListener() {
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
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_9), R.string._, R.string._, R.string._, R.string._, R.string.edsa, R.string.desc_edsa, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_10), R.string._, R.string._, R.string._, R.string._, R.string.maginhwa, R.string.desc_maginhwa, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_11), R.string._, R.string._, R.string._, R.string._, R.string.church, R.string.desc_church, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_12), R.string._, R.string._, R.string._, R.string._, R.string.up, R.string.desc_up, R.string._, R.string._, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_13), R.string._, R.string._, R.string._, R.string._, R.string.east, R.string.desc_east, R.string._, R.string._, R.string._, R.string._);
        p31 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_9);
        p32 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_10);
        p33 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_11);
        p34 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_12);
        p35 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_13);


        p31.setOnClickListener(new OnClickListener() {
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

        p32.setOnClickListener(new OnClickListener() {
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


        p33.setOnClickListener(new OnClickListener() {
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


        p34.setOnClickListener(new OnClickListener() {
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

        p35.setOnClickListener(new OnClickListener() {
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
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_14), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.bayani, R.string.desc_bayani, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_15), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.zoo, R.string.desc_zoo, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_16), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.rita, R.string.desc_ritaa, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_17), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.pagasa, R.string.desc_pagasa, R.string._, R.string._);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_23), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.cubaoexpo, R.string.desc_cubaoexpo, R.string._, R.string._);
        p41 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_14);
        p42 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_15);
        p43 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_16);
        p44 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_17);
        p45 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_23);


        p41.setOnClickListener(new OnClickListener() {
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

        p42.setOnClickListener(new OnClickListener() {
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


        p43.setOnClickListener(new OnClickListener() {
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


        p44.setOnClickListener(new OnClickListener() {
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

        p45.setOnClickListener(new OnClickListener() {
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
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_18), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.sining, R.string.desc_sining);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_19), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.fernwood, R.string.desc_fernwood);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_20), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.armed, R.string.desc_armed);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_21), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.mystery, R.string.desc_mystery);
        bindCompoundListener((CompoundLayout) findViewById(R.id.profile_24), R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string._, R.string.monasterio, R.string.desc_monasterio);

        p51 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_18);
        p52 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_19);
        p53 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_20);
        p54 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_21);
        p55 = (com.example.compoundlayout.CircleGradientRadioLayout) findViewById(R.id.profile_24);


        p51.setOnClickListener(new OnClickListener() {
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

        p52.setOnClickListener(new OnClickListener() {
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


        p53.setOnClickListener(new OnClickListener() {
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


        p54.setOnClickListener(new OnClickListener() {
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

        p55.setOnClickListener(new OnClickListener() {
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
        final ExpandableLayout expandableLayout = (ExpandableLayout) this.findViewById(R.id.expandablelayout);
        final ExpandableLayout expandableLayout2 = (ExpandableLayout) this.findViewById(R.id.expandablelayout2);
        final ExpandableLayout expandableLayout3 = (ExpandableLayout) this.findViewById(R.id.expandablelayout3);
        final ExpandableLayout expandableLayout4 = (ExpandableLayout) this.findViewById(R.id.expandablelayout4);
        final ExpandableLayout expandableLayout5 = (ExpandableLayout) this.findViewById(R.id.expandablelayout5);


        this.findViewById(R.id.imageview).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              recyclerView.setVisibility(View.INVISIBLE);
                final Animation myAnim = AnimationUtils.loadAnimation(ChoicesOfPackage.this, R.anim.button_bounce);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                expandableLayout.startAnimation(myAnim);
                expandableLayout.toggleExpansion();

            }
        });

        this.findViewById(R.id.imageview2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setVisibility(View.INVISIBLE);
                Animation myAnim = AnimationUtils.loadAnimation(ChoicesOfPackage.this, R.anim.button_bounce);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                expandableLayout2.startAnimation(myAnim);
                expandableLayout2.toggleExpansion();
            }
        });

        this.findViewById(R.id.imageview3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                r3.setVisibility(View.INVISIBLE);
                final Animation myAnim = AnimationUtils.loadAnimation(ChoicesOfPackage.this, R.anim.button_bounce);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                expandableLayout3.startAnimation(myAnim);
                expandableLayout3.toggleExpansion();
            }
        });

        this.findViewById(R.id.imageview4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                r4.setVisibility(View.INVISIBLE);
                final Animation myAnim = AnimationUtils.loadAnimation(ChoicesOfPackage.this, R.anim.button_bounce);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                expandableLayout4.startAnimation(myAnim);
                expandableLayout4.toggleExpansion();
            }
        });

        this.findViewById(R.id.imageview5).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                r5.setVisibility(View.INVISIBLE);
                final Animation myAnim = AnimationUtils.loadAnimation(ChoicesOfPackage.this, R.anim.button_bounce);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                expandableLayout5.startAnimation(myAnim);
                expandableLayout5.toggleExpansion();
            }
        });


    }


    /**
     * Bind compound listener.
     *
     * @param compoundLayout Compound layout.
     * @param subtitle       Subtitle to set.
     * @param subdes         Subdes to set.
     * @param subtitle_1     Subtitle_1 to set.
     * @param subdes_1       subdes_1 to set.
     * @param subtitle_2     Subtitle_1 to set.
     * @param subdes_2       subdes_1 to set.
     * @param subtitle_3     Subtitle_1 to set.
     * @param subdes_3       subdes_1 to set.
     * @param subtitle_4     Subtitle_1 to set.
     * @param subdes_4       subdes_1 to set.
     */

    private void bindCompoundListener(final CompoundLayout compoundLayout, @StringRes final int subtitle, @StringRes final int subdes, @StringRes final int subtitle_1, @StringRes final int subdes_1, @StringRes final int subtitle_2, @StringRes final int subdes_2, @StringRes final int subtitle_3, @StringRes final int subdes_3, @StringRes final int subtitle_4, @StringRes final int subdes_4) {
        compoundLayout.setOnCheckedChangeListener(new CompoundLayout.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundLayout compoundLayout, boolean checked) {
                if (checked) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(ChoicesOfPackage.this, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            subtitleTextView.setText(getString(subtitle));
                            subDesc.setText(getString(subdes));
                            subtitleTextView_1.setText(getString(subtitle_1));
                            subDesc_1.setText(getString(subdes_1));
                            subtitleTextView_2.setText(getString(subtitle_2));
                            subDesc_2.setText(getString(subdes_2));
                            subtitleTextView_3.setText(getString(subtitle_3));
                            subDesc_3.setText(getString(subdes_3));
                            subtitleTextView_4.setText(getString(subtitle_4));
                            subDesc_4.setText(getString(subdes_4));

                            descriptionLayout.startAnimation(AnimationUtils.loadAnimation(ChoicesOfPackage.this, android.R.anim.fade_in));
                            descriptionLayout_1.startAnimation(AnimationUtils.loadAnimation(ChoicesOfPackage.this, android.R.anim.fade_in));
                            descriptionLayout_2.startAnimation(AnimationUtils.loadAnimation(ChoicesOfPackage.this, android.R.anim.fade_in));
                            descriptionLayout_3.startAnimation(AnimationUtils.loadAnimation(ChoicesOfPackage.this, android.R.anim.fade_in));
                            descriptionLayout_4.startAnimation(AnimationUtils.loadAnimation(ChoicesOfPackage.this, android.R.anim.fade_in));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    descriptionLayout.startAnimation(fadeOutAnimation);
                    descriptionLayout_1.startAnimation(fadeOutAnimation);
                    descriptionLayout_2.startAnimation(fadeOutAnimation);
                    descriptionLayout_3.startAnimation(fadeOutAnimation);
                    descriptionLayout_4.startAnimation(fadeOutAnimation);
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
    public RecyclerView.Adapter recyclerAdapter3;
    public RecyclerView.Adapter recyclerAdapter4;
    public RecyclerView.Adapter recyclerAdapter5;

    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.LayoutManager layoutManager2;
    public RecyclerView.LayoutManager layoutManager3;
    public RecyclerView.LayoutManager layoutManager4;
    public RecyclerView.LayoutManager layoutManager5;

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
                layoutManager2 = new LinearLayoutManager(context);
                layoutManager3= new LinearLayoutManager(context);
                layoutManager4 = new LinearLayoutManager(context);
                layoutManager5= new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
               r2.setLayoutManager(layoutManager2);
                r3.setLayoutManager(layoutManager3);
                r4.setLayoutManager(layoutManager4);
                r5.setLayoutManager(layoutManager5);

                recyclerAdapter = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerAdapter2 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerAdapter3 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerAdapter4= new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerAdapter5 = new RecyclerAdapter(reviewAuthorNames, profilePictureUrl, authorTexts, reviewRating);
                recyclerView.setAdapter(recyclerAdapter);
               r2.setAdapter(recyclerAdapter2);
                r3.setAdapter(recyclerAdapter3);
                r4.setAdapter(recyclerAdapter4);
                r5.setAdapter(recyclerAdapter5);
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
