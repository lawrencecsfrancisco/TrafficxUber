package com.sumo.traffic;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;

import android.icu.util.Calendar;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils;
import com.google.maps.model.DirectionsRoute;
import com.kyo.expandablelayout.ExpandableLayout;
import com.sumo.traffic.AlarmCodes.AlarmReceiver;
import com.sumo.traffic.InfoOfPlaces.InfoOfArt;
import com.sumo.traffic.InfoOfPlaces.InfoOfAteneo;
import com.sumo.traffic.InfoOfPlaces.InfoOfBayani;
import com.sumo.traffic.InfoOfPlaces.InfoOfCOF;
import com.sumo.traffic.InfoOfPlaces.InfoOfDam;
import com.sumo.traffic.InfoOfPlaces.InfoOfEast;
import com.sumo.traffic.InfoOfPlaces.InfoOfEdsa;
import com.sumo.traffic.InfoOfPlaces.InfoOfMaginhawa;
import com.sumo.traffic.InfoOfPlaces.InfoOfNinoy;
import com.sumo.traffic.InfoOfPlaces.InfoOfParish;
import com.sumo.traffic.InfoOfPlaces.InfoOfPeople;
import com.sumo.traffic.InfoOfPlaces.InfoOfQmc;
import com.sumo.traffic.InfoOfPlaces.InfoOfUp;
import com.sumo.traffic.InfoOfPlaces.InfoOfVargas;
import com.sumo.traffic.InfoOfPlaces.InfoOfWatershed;
import com.sumo.traffic.InfoOfPlaces_Manila.BahayTsinoy;
import com.sumo.traffic.InfoOfPlaces_Manila.CCP;
import com.sumo.traffic.InfoOfPlaces_Manila.CasaManila;
import com.sumo.traffic.InfoOfPlaces_Manila.FilipinoChinese;
import com.sumo.traffic.InfoOfPlaces_Manila.Luneta;
import com.sumo.traffic.InfoOfPlaces_Manila.ManilaCathedral;
import com.sumo.traffic.InfoOfPlaces_Manila.NationalMuseum;
import com.sumo.traffic.InfoOfPlaces_Manila.NayongFilipino;
import com.sumo.traffic.InfoOfPlaces_Manila.PacoPark;
import com.sumo.traffic.InfoOfPlaces_Manila.SanAgustinChurch;
import com.sumo.traffic.InfoOfPlaces_Manila.coconutpalace;
import com.sumo.traffic.InfoOfPlaces_Manila.starcity;
import com.sumo.traffic.bestplaces.bestplaces_package1;
import com.sumo.traffic.bestplaces.bestplaces_package2;
import com.sumo.traffic.bestplaces.bestplaces_package3;
import com.sumo.traffic.bestplaces.bestplaces_package4;
import com.sumo.traffic.bestplaces.bestplaces_package5;
import com.sumo.traffic.model.ApplicationConstants;
import com.uber.sdk.android.core.auth.AuthenticationError;
import com.uber.sdk.android.core.auth.LoginCallback;
import com.uber.sdk.android.rides.RideParameters;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.android.rides.RideRequestButtonCallback;
import com.uber.sdk.core.auth.AccessToken;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.error.ApiError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadFactory;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import static com.sumo.traffic.traffic.connectAsyncTask2.*;


public class traffic extends FragmentActivity implements LocationListener, OnMapReadyCallback,
        GoogleMap.OnMapLongClickListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnMarkerClickListener, TextToSpeech.OnInitListener {

    public static LinkedList<MarkerOptions> mList = new LinkedList<MarkerOptions>();
    public static LinkedList<LatLng> points = new LinkedList<LatLng>();
    public static LinkedList<LatLng> place = new LinkedList<LatLng>();
    public static LinkedList<String> placename = new LinkedList<String>();
    public static LinkedList<String> placevicinity = new LinkedList<String>();
    public static LinkedList<Marker> markers = new LinkedList<Marker>();
    public static LinkedList<String> distances = new LinkedList<String>();
    public static LinkedList<String> durations = new LinkedList<String>();
    public static LinkedList<String> timestoStay = new LinkedList<String>();
    public static LinkedList<String> mins = new LinkedList<String>();
    public static LinkedList<String> reminders = new LinkedList<String>();
    public static LinkedList<String> listofturns = new LinkedList<String>();
    public static ArrayList<HashMap<String, String>> alarmClocks = new ArrayList<>();
    static String placeId;
    LinkedList<MarkerOptions> placeMarkers = new LinkedList<MarkerOptions>();
    static BitmapDescriptor[] icons = null;
    String[] loadingToasts = null;
    static int streetmapenabled = 0;
    private Button rout;
    private Button traffic;
    private Button altroute;
    static TextView pointview, durationview, distanceview;
    static LatLng latLng;
    LatLng oldplace;
    Polyline line, bigline;
    Timer t = new Timer();
    String res;

    boolean clear = false;
    int rn = 0, rl;

    ListView listViewz;

    String ins = "html_instructions";
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;

    static CoordinatorLayout main;

    public static double latitude;
    public static double longitude;

    static Integer reminder = 0;
    public static GoogleMap mMap;

    PlaceAutocompleteFragment autocompleteFragment;
    private TextToSpeech tts;
    static int placesnumber;

    static LinearLayout hideme;
    static Button selected;

    static int ekis;


    static LatLng streetmap;

    static int button3;
    static int button1;

    static Button b1, b2, b3;
    private BottomNavigationView bottomNavigationView;


    static int qp1, qp2, qp3, qp4, qp5;
    int driving = 0;
    static int packs, itc;

    static Button nav;

    com.github.clans.fab.FloatingActionButton fab4, fab2, fab3;
    com.github.clans.fab.FloatingActionMenu menured;
    com.github.clans.fab.FloatingActionButton drivermode;
    static int checklist = 0;
    float dX;
    float dY;
    int lastAction;

    static String place_id = null;
    String placeID = "";
    List<String> placesId = new ArrayList<String>();

    JSONArray turns;
    private final int interval = 10000; // 1 Second
    private Handler handler = new Handler();
    ArrayList<JSONArray> listOfRouteArray = new ArrayList<>();
    private ArrayList<Integer> listOfIndicesOfCurrentRoutes = new ArrayList<>();
    private ArrayList<Polyline> polylines = new ArrayList<>();
    private ArrayList<DirectionsRoute[]> listOfSetOfRoutesOfPolylines = new ArrayList<>();

    final BottomSheetDialogFragment myBottomSheet = MyBottomSheetDialogFragment.newInstance("Modal Bottom Sheet");

    JSONObject t2;
    String get;
    Double layo;


    private RecyclerView recyclerViewStaff;
    private RecyclerView.Adapter adapterStaff;
    private List<TurnItem> InitialListStaffs;


    List<Double> latz = new ArrayList<Double>();
    List<Double> longz = new ArrayList<Double>();
    List<Double> elatz = new ArrayList<Double>();
    List<Double> elongz = new ArrayList<Double>();
    List<String> ttsturns = new ArrayList<>();
    final Context context = this;

    double kantolayo;
    float kantoliko;
    double markarlayo;
    int kantors = 0;
    int desto = 2;
    int markerinos = 0;
    LinearLayout reroute, driversearch, driverspeed, mainmenus, turntexter;
    int checkreroute = 0;
    float speedofuser;
    private TextView meterz, durationz, distancez;
    int traffik = 0;
    String emailnguser;
    public static LinkedList<Marker> markerino = new LinkedList<Marker>();
    String s;
    String date;


    // String[] multipleHours = {"9", "11", "13", "14", "15", "17", "18"}; //store here the hours for every alarm you want to set
    //  String[] multipleMinutes = {"45", "0", "0", "0", "45", "0", "45"}; //store here the minutes
    int[] multipleHours; //= {19, 11, 13, 14, 15, 17, 18}; //store here the hours for every alarm you want to set
    int[] multipleMinutes; //= {48, 0, 0, 0, 45, 0, 45}; //store here the minutes
    String[] multipleDestinations; //= {"Departure", "Quezon Heritage House", "Art In Island", "Quezon City Experience", "Quezon Memorial", " Destination 5", "Destination 6"}; //same thing for destinations
    String[] multipleReminders;// = {"You need to go to Destination 1", "Timeout, Go to next destination", "Timeout, Go to next destination", "Timeout, Go to next destination", "Timeout, Go to next destination", "Timeout, Go to next destination", "Package Ended!"};
    String alal;
    private int alarmIndex = -1;

    SimpleDateFormat simpleDateFormat;
    String out;
    String datex;
    String currentDateTimeString;
    Date date1, date2;
    String test;

    RideRequestButton requestButton;
    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        date = DateFormat.getDateTimeInstance().format(new Date());
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                emailnguser = userInput.getText().toString();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                emailnguser = "";
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        final ExpandableLayout expandableLayout = (ExpandableLayout) this.findViewById(R.id.expandablelayout);
        tts = new TextToSpeech(this, this);

        recyclerViewStaff = (RecyclerView) findViewById(R.id.recyclerViewStaff);
        meterz = (TextView) findViewById(R.id.meterpersecond);
        distancez = (TextView) findViewById(R.id.distancex);
        durationz = (TextView) findViewById(R.id.durationx);


        recyclerViewStaff.setHasFixedSize(true);
        recyclerViewStaff.setLayoutManager(new LinearLayoutManager(this));
        InitialListStaffs = new ArrayList<>();


        Runnable runnable = new Runnable() {
            public void run() {
                if (TemplateOrChoices.packages == 0) {
                    selected();
                } else if (TemplateOrChoices.packages == 1) {
                    packganern();
                }
            }
        };

        handler.postAtTime(runnable, System.currentTimeMillis() + interval);
        handler.postDelayed(runnable, interval);
        reroute = (LinearLayout) findViewById(R.id.reroute);
        driversearch = (LinearLayout) findViewById(R.id.driversearch);
        driverspeed = (LinearLayout) findViewById(R.id.driverspeed);
        mainmenus = (LinearLayout) findViewById(R.id.mainmenudriver);
        turntexter = (LinearLayout) findViewById(R.id.turnmoto);
        turntexter.setVisibility(View.GONE);
        driverspeed.setVisibility(View.GONE);
        reroute.setVisibility(View.GONE);
        drivermode = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.Plot);
        drivermode.setImageResource(R.drawable.exploremode);

        fab4 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mList = new LinkedList<MarkerOptions>();
                points = new LinkedList<LatLng>();
                place = new LinkedList<LatLng>();
                placename = new LinkedList<String>();
                placevicinity = new LinkedList<String>();
                markers = new LinkedList<Marker>();
                distances = new LinkedList<String>();
                durations = new LinkedList<String>();
                timestoStay = new LinkedList<String>();
                mins = new LinkedList<String>();
                reminders = new LinkedList<String>();
                listofturns = new LinkedList<String>();
                alarmClocks = new ArrayList<>();
                mMap.clear();
                InitialListStaffs = new ArrayList<TurnItem>();
                latz = new ArrayList<Double>();
                longz = new ArrayList<Double>();
                elatz = new ArrayList<Double>();
                elongz = new ArrayList<Double>();
                ttsturns = new ArrayList<>();
                Intent i = new Intent(traffic.this, Packagesets.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();

            }
        });
        fab2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab2);


        fab3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab3);
        menured = (com.github.clans.fab.FloatingActionMenu) findViewById(R.id.menu_red);


        if (Packagesets.packages == 1) {
            fab2.setLabelText("Destinations");
            bottomNavigationView.findViewById(R.id.directions).setVisibility(View.GONE);
            bottomNavigationView.findViewById(R.id.places).setVisibility(View.GONE);
            bottomNavigationView.findViewById(R.id.reset).setVisibility(View.GONE);
            fab4.setVisibility(View.VISIBLE);
        } else if (TemplateOrChoices.packages == 0) {
            fab2.setLabelText("Reselect");
            bottomNavigationView.findViewById(R.id.directions).setVisibility(View.GONE);
            bottomNavigationView.findViewById(R.id.places).setVisibility(View.GONE);
            bottomNavigationView.findViewById(R.id.reset).setVisibility(View.GONE);
            fab4.setVisibility(View.GONE);

        } else if (SelectQcBagManila.packages == 3) {
            fab2.setLabelText("Reselect");
            bottomNavigationView.findViewById(R.id.directions).setVisibility(View.VISIBLE);
            bottomNavigationView.findViewById(R.id.places).setVisibility(View.VISIBLE);
            menured.setVisibility(View.GONE);
            bottomNavigationView.findViewById(R.id.reset).setVisibility(View.GONE);
            fab4.setVisibility(View.GONE);
        }


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Packagesets.packages == 1) {  // TemplateOrChoices
                    if (packs == 1) {   // ChoicesOfPacakge
                        Intent i = new Intent(traffic.this, bestplaces_package1.class);
                        startActivity(i);
                    } else if (packs == 2) {
                        Intent i = new Intent(traffic.this, bestplaces_package2.class);
                        startActivity(i);
                    } else if (packs == 3) {
                        Intent i = new Intent(traffic.this, bestplaces_package3.class);
                        startActivity(i);
                    } else if (packs == 4) {
                        Intent i = new Intent(traffic.this, bestplaces_package4.class);
                        startActivity(i);
                    } else if (packs == 5) {
                        Intent i = new Intent(traffic.this, bestplaces_package5.class);
                        startActivity(i);
                    }

                } else if (TemplateOrChoices.packages == 0) {
                    mList = new LinkedList<MarkerOptions>();
                    points = new LinkedList<LatLng>();
                    place = new LinkedList<LatLng>();
                    placename = new LinkedList<String>();
                    placevicinity = new LinkedList<String>();
                    markers = new LinkedList<Marker>();
                    distances = new LinkedList<String>();
                    durations = new LinkedList<String>();
                    timestoStay = new LinkedList<String>();
                    mins = new LinkedList<String>();
                    reminders = new LinkedList<String>();
                    listofturns = new LinkedList<String>();
                    alarmClocks = new ArrayList<>();
                    InitialListStaffs = new ArrayList<TurnItem>();
                    latz = new ArrayList<Double>();
                    longz = new ArrayList<Double>();
                    elatz = new ArrayList<Double>();
                    elongz = new ArrayList<Double>();
                    ttsturns = new ArrayList<>();


                    mMap.clear();
                    Intent i = new Intent(traffic.this, ReviewChoiceOfPlace.class);
                    // set the new task and clear flags
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);

                }
            }
        });


        main = (CoordinatorLayout) findViewById(R.id.activity_main);


  /*      if (TemplateOrChoices.renew ==1)
        {
            Intent mIntent=new Intent(traffic.this, ChoicesOfPlace.class);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(mIntent);

        }*/



  /*      rout = (Button) findViewById(R.id.Broute);
        traffic = (Button) findViewById(R.id.traffic);
        altroute = (Button) findViewById(R.id.Aroute);
        PROXIMITY_RADIUS = (EditText) findViewById(R.id.radiuz);
*/


        icons = new BitmapDescriptor[11];
        icons[0] = BitmapDescriptorFactory.fromResource(R.drawable.kikomarke1r11);
        icons[1] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[2] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[3] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[4] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[5] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[6] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[7] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[8] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[9] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);
        icons[10] = BitmapDescriptorFactory.fromResource(R.drawable.ccheck);

        loadingToasts = new String[10];
        loadingToasts[0] = "1st Marker Loading...";
        for (int i = 1; i <= 9; i++) {
            loadingToasts[i] = (i + 1) + "nd Marker Loading...";
        }


        pointview = (TextView) findViewById(R.id.tv1);
        durationview = (TextView) findViewById(R.id.tv2);
        distanceview = (TextView) findViewById(R.id.tv3);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.route) {
                    if (checklist == 0) {
                        Toast.makeText(getApplicationContext(), "Select Packages first or Add a marker in the map", Toast.LENGTH_LONG).show();

                    } else {
                        Intent z = new Intent(traffic.this, DestinationActivity.class);
                        z.putExtra("currentMarker", markers.size());
                        startActivityForResult(z, 99);

                    }


                } else if (item.getItemId() == R.id.places) {
                    myBottomSheet.show(getSupportFragmentManager(), myBottomSheet.getTag());

                    mMap.setTrafficEnabled(false);
                } else if (item.getItemId() == R.id.directions) {
                    Intent i = new Intent(traffic.this, Home.class);
                    startActivity(i);


                } else if (item.getItemId() == R.id.traffic) {
                    if (checklist == 0) {
                        Toast.makeText(getApplicationContext(), "Add a marker in the map, This button create alternate route.", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(context, "Alternate Route Created", Toast.LENGTH_SHORT).show();
                        alternateRoute();
                        Log.e("Testing", String.valueOf(polylines));
                        Log.e("Testing", String.valueOf(listOfRouteArray));
                        Log.e("Testing", String.valueOf(listOfIndicesOfCurrentRoutes));

                    }


                } /*else if (item.getItemId() == R.id.reset) {
                    //Correction starts here
                    for (Marker marker : markers) {
                        marker.remove();
                    }
                    markers.clear();

                    for (Polyline polyline : polylines) {
                        polyline.remove();
                    }
                    polylines.clear();
                    listOfIndicesOfCurrentRoutes.clear();
                    listOfRouteArray.clear();
                    InitialListStaffs.clear();
                    adapterStaff.notifyDataSetChanged();
                    //Correction ends here
                    mMap.clear();
                    try {
                        pointview.setVisibility(View.GONE);
                        durationview.setVisibility(View.GONE);
                        distanceview.setVisibility(View.GONE);
                        clear = true;
                        place = new LinkedList<LatLng>();
                        points = new LinkedList<LatLng>();
                        markers = new LinkedList<>();
                        durations = new LinkedList<String>();
                        distances = new LinkedList<String>();
                        mList = new LinkedList<MarkerOptions>();

                        try {
                            altroute.setVisibility(View.GONE);
                            rout.setVisibility(View.GONE);
                        } catch (Exception e) {
                        }

                        rn = 0;
                        rl = 0;
                        res = "";
                        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        Criteria criteria = new Criteria();
                        String provider = locationManager.getBestProvider(criteria, true);
                        Location myLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_GRANTED) {
                            mMap.getUiSettings().setMyLocationButtonEnabled(false);
                        }
                        //onLocationChanged(myLocation);
                        // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 200,1, (android.location.LocationListener) traffic.this);

                        if (myLocation == null) {
                            Log.d("meme", "null location");
                        }

                 *//*       mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);*//*

*//*                        MarkerOptions markerOptions = new MarkerOptions()
                                .position(latLng)
                                .title("My Location")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.kikomarke1r11))
                                .anchor(0.5f, 1);

                        Marker m = mMap.addMarker(markerOptions);

                        markers.add(m);
                        //EXTRA CODES
                        mList.add(markerOptions);
                        durations.add(new String("0"));
                        distances.add(new String("0"));

                        // Log.d("meme",myLocation.toString());
                        LatLng myLatLng = new LatLng(myLocation.getLatitude(),
                                myLocation.getLongitude());
                        // Log.d("meme",myLatLng.toString());

                        points.add(latLng);*//*


                        Log.e("Testing", "hello" + String.valueOf(polylines));
                        Log.e("Testing", "hello" + String.valueOf(listOfRouteArray));
                        Log.e("Testing", "hello" + String.valueOf(listOfIndicesOfCurrentRoutes));

                    } catch (Exception e) {

                    }
                }*/


                return false;
            }
        });

        requestButton = (RideRequestButton) findViewById(R.id.button8);

        SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId("NwteyMA-ot7Xc1qMElNyw7ai5kLtSZQS")
                .setServerToken("oa48R-U1O7FiJWCAl1qKCa-AAFf59VNqx8T70xht")
                .build();
        ServerTokenSession session = new ServerTokenSession(config);
        requestButton.setSession(session);

    }

    public void packganern() {
        if (packs == 1) {


            ArtInIsland();
            qcx();
            circleoffun();
            domingo();
            amoranto();


        } else if (packs == 2) {

            ateneogallery();
            santamaria();
            uptc();
            balara();
            heritage();


        } else if (packs == 3) {

            edsa();
            eastwood();
            churchgesu();
            maginhawa();
            up();


        } else if (packs == 4) {

            cubaoexpo();
            rita();
            bantayog();
            pagasa();
            wildlife();


        } else if (packs == 5) {

            kamalig();
            armedforces();
            mystery();
            monasterio();
            fernwood();


        }

        if (SelectQcBagManila.manila == 1) {
            if (packs == 1) {


                luneta();
                casa();
                manilacathedral();
                manilaamericancemetery();

            } else if (packs == 2) {

             casa();
                bahaytsinoy();
                chinatown();
                manilachinesecemetery();



            } else if (packs == 3) {

                quiapochurch();
               sansebastian();
                casa();
             luneta();


            } else if (packs == 4) {

           manilazoo();
                nationalmuseum();
                culturalcenter();
                pacopark();
                sanagustin();

            } else if (packs == 5) {

               starcity();
                coconutpalace();
                manilaoceanpark();
                museopambata();


            }
        }


       /* for (int i = 0; i < multipleHours.length; i++) {
            int notificationId = (alarmIndex >= 0) ? alarmIndex : alarmClocks.size();
            HashMap<String, String> alarm = new HashMap<>();
            alarm.put(ApplicationConstants._ID, String.valueOf(notificationId));
            alarm.put(ApplicationConstants.HOUR, String.valueOf(multipleHours[i]));
            alarm.put(ApplicationConstants.MINUTE, String.valueOf(multipleMinutes[i]));
            alarm.put(ApplicationConstants.REMINDER, String.valueOf(multipleReminders[i]));
            alarm.put(ApplicationConstants.DESTINATION, String.valueOf(multipleDestinations[i]));
            alarmClocks.add(alarm);
            setAlarm(multipleHours[i], multipleMinutes[i], notificationId, multipleReminders[i], multipleDestinations[i]);
        }*/


    }


    @Override
    protected void onResume() {
        super.onResume();

        //new Handler().postDelayed(new Runnable() {
        //    @Override
        //    public void run() {
        //        try {
        //            latLng = myLocation();
        //            oldplace = latLng;
        //            points.add(latLng);
        //            Log.d("mkmk", "c1");
        //            getplaces();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //    }
        //}, 3000);

        //   t.scheduleAtFixedRate(new TimerTask() {
        //                             @Override
        //
        //                            public void run() {
        try {
            latLng = updateLocation();
            float check = distance(oldplace, latLng);
            if (clear == false) {
                points.removeFirst();
                Log.d("mkmk", "d");
            }
            points.addFirst(latLng);
            Log.d("mkmk", "c2");
            if (check > 500 || clear == true) {
                clear = false;
                oldplace = latLng;
                getplaces();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // }}, 0,5000);
    }

    public void navigate(View view) {


        if (mGoogleApiClient.isConnected()) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            mGoogleApiClient.disconnect();
            driving = 0;
            drivermode.setImageResource(R.drawable.drivermode);
            mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));


        } else if (!mGoogleApiClient.isConnected()) {
            drivermode.setImageResource(R.drawable.exploremode);
            float mapZoom = mMap.getCameraPosition().zoom >= 30 ? mMap.getCameraPosition().zoom : 30;
            CameraPosition cameraPosition =
                    new CameraPosition.Builder()
                            .target(latLng)
                            .bearing(20)
                            .tilt(90)
                            .zoom(mapZoom)
                            .build();

            mMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(cameraPosition));

            mGoogleApiClient.connect();
            driving = 1;
            mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.drivingmode));
            if (!InitialListStaffs.isEmpty()) {


            }


        }

        if (checkreroute == 0) {
            reroute.setVisibility(View.GONE);
            driverspeed.setVisibility(View.GONE);
            driversearch.setVisibility(View.VISIBLE);
            mainmenus.setVisibility(View.VISIBLE);
            menured.setVisibility(View.VISIBLE);
            turntexter.setVisibility(View.GONE);
            requestButton.setVisibility(View.GONE);
            checkreroute = 1;
        } else if (checkreroute == 1) {
            reroute.setVisibility(View.VISIBLE);
            driverspeed.setVisibility(View.VISIBLE);
            menured.setVisibility(View.GONE);
            driversearch.setVisibility(View.GONE);
            mainmenus.setVisibility(View.GONE);
            requestButton.setVisibility(View.VISIBLE);
            turntexter.setVisibility(View.VISIBLE);
            checkreroute = 0;
        }
        //finalize






     /*   mMap.setOnCameraMoveStartedListener(this);*/

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private static final String TAG = traffic.class.getSimpleName();

    @Override
    public void onMapReady(GoogleMap googleMap) {

   /*     if (TemplateOrChoices.packages == 1) {
            for (int i = 0; i < multipleHours.length; i++) {
                int notificationId = (alarmIndex >= 0) ? alarmIndex : alarmClocks.size();
                HashMap<String, String> alarm = new HashMap<>();
                alarm.put(ApplicationConstants._ID, String.valueOf(notificationId));
                alarm.put(ApplicationConstants.HOUR, String.valueOf(multipleHours[i]));
                alarm.put(ApplicationConstants.MINUTE, String.valueOf(multipleMinutes[i]));
                alarm.put(ApplicationConstants.REMINDER, String.valueOf(multipleReminders[i]));
                alarm.put(ApplicationConstants.DESTINATION, String.valueOf(multipleDestinations[i]));
                alarmClocks.add(alarm);
                setAlarm(multipleHours[i], multipleMinutes[i], notificationId, multipleReminders[i], multipleDestinations[i]);
            }
        }
*/

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));


            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ESTABLISHMENT)
                .build();
        //  autocompleteFragment.getView().setVisibility(View.GONE);
        autocompleteFragment.setFilter(typeFilter);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                LatLng pickupLocation = place.getLatLng();

                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(pickupLocation);
                mMap.animateCamera(cameraUpdate);


            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("", "An error occurred: " + status);
            }
        });


        mMap = googleMap;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    latLng = myLocation();
                    //  points.add(latLng);
                    Log.d("mkmk", "b1");
                    oldplace = latLng;
                    getplaces();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000);


        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {


            }
        }, 0, 10000);

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    latLng = updateLocation();
                    float check = distance(oldplace, latLng);

                    if (clear == false) {
                        points.removeFirst();
                        Log.d("mkmk", "a");
                    }
                    points.addFirst(latLng);
                    Log.d("mkmk", "b2");
                    if (check > 500 || clear == true) {
                        clear = false;
                        oldplace = latLng;
                        getplaces();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5000);

        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapLongClickListener(this);
        mMap.setBuildingsEnabled(true);

        // ================================================================
        // ================================================================
        // ================================================================
        // ================================================================
        // ================================================================

        mMap = googleMap;

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }


    }

    public void revise(View view) {

        //add markers back
        mMap.clear();
        // lister.clear();
        int current = 0;
        InitialListStaffs.clear();
        ttsturns.clear();
        elatz.clear();
        elongz.clear();
        for (
                MarkerOptions options : mList)

        {
            Marker m = mMap.addMarker(options);
            //reset icons
            m.setIcon(icons[current++]);
            adapterStaff.notifyDataSetChanged();
        }

        //add places back
        for (
                MarkerOptions place : placeMarkers)

        {
            Marker m = mMap.addMarker(place);
        }


        String url = null;
        try

        {
            url = makeURL4();
        } catch (
                UnsupportedEncodingException e)

        {
            e.printStackTrace();
        }

        try {

            connectAsyncTask3 downloadTask2 = new connectAsyncTask3(url, this, false);
            downloadTask2.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }


        //  }


    }


    public void replot2(View view) {

        //add markers back
        mMap.clear();
        // lister.clear();
        int current = 0;
        InitialListStaffs.clear();
        ttsturns.clear();
        elatz.clear();
        elongz.clear();
        for (
                MarkerOptions options : mList)

        {
            Marker m = mMap.addMarker(options);
            //reset icons
            m.setIcon(icons[current++]);
            adapterStaff.notifyDataSetChanged();
        }

        //add places back
        for (
                MarkerOptions place : placeMarkers)

        {
            Marker m = mMap.addMarker(place);
        }


        String url = null;
        try

        {
            url = makeURL3();
        } catch (
                UnsupportedEncodingException e)

        {
            e.printStackTrace();
        }

        try {

            connectAsyncTask3 downloadTask2 = new connectAsyncTask3(url, this, false);
            downloadTask2.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }


        //  }


    }

    public void replot() {


        //add markers back
        mMap.clear();
        // lister.clear();
        int current = 0;
        ttsturns.clear();
        InitialListStaffs.clear();
        elatz.clear();
        elongz.clear();
        for (
                MarkerOptions options : mList)

        {
            Marker m = mMap.addMarker(options);
            //reset icons
            m.setIcon(icons[current++]);
            adapterStaff.notifyDataSetChanged();
        }

        //add places back
        for (
                MarkerOptions place : placeMarkers)

        {
            Marker m = mMap.addMarker(place);
        }


        String url = null;
        try

        {
            url = makeURL3();
        } catch (
                UnsupportedEncodingException e)

        {
            e.printStackTrace();
        }

        try {

            connectAsyncTask3 downloadTask2 = new connectAsyncTask3(url, this, false);
            downloadTask2.execute();
            //   Thread.sleep(7000);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //  }


    }


    // ================================================================
    // ================================================================
    // ================================================================
    // ================================================================
    // ================================================================
    // ================================================================

    @TargetApi(Build.VERSION_CODES.M)

    public LatLng myLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.getUiSettings().setMyLocationButtonEnabled(true);

        }
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);

        //onLocationChanged(myLocation);
        // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 200,1, (android.location.LocationListener) traffic.this);

       /* mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);*/
        mMap.setMyLocationEnabled(true);


   /*     MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("My Location")

                .icon(BitmapDescriptorFactory.fromResource(R.drawable.kikomarke1r11))
                .anchor(0.5f, 1);

        Marker m = mMap.addMarker(markerOptions);

        markers.addFirst(m);
        //EXTRA CODES
        mList.addFirst(markerOptions);

        // Log.d("meme",myLocation.toString());


        // Log.d("meme",myLatLng.toString());

        points.add(latLng);*/
/*
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLatLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(20));
        */

        return latLng;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public LatLng updateLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
        }
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (myLocation == null) {
            Log.d("meme", "null location");
        }

        return latLng;
    }

    public float distance(LatLng StartP, LatLng EndP) throws Exception {
        Location loc1 = new Location("");
        loc1.setLatitude(StartP.latitude);
        loc1.setLongitude(StartP.longitude);

        Location loc2 = new Location("");
        loc2.setLatitude(EndP.latitude);
        loc2.setLongitude(EndP.longitude);

        float distanceInMeters = loc1.distanceTo(loc2);

        return distanceInMeters;

    }




/*
    public void navigate(View view) {


        rn++;
        rn = rn % rl;
        drawPath(res);
    }
*/

    public void schedule(View view) {

        Intent i = new Intent(traffic.this, AlarmActivity.class);
        startActivity(i);

    }


    static String makeURL1() throws UnsupportedEncodingException {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 500);
        googlePlacesUrl.append("&type=" + "church");
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyCx8-ZK6m5FTgEoTaSRaUuALV-5Vnz1Co4");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    static String makeURL2() throws UnsupportedEncodingException {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 500);
        googlePlacesUrl.append("&type=" + "atm");
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyCx8-ZK6m5FTgEoTaSRaUuALV-5Vnz1Co4");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    static String urlplace2() throws UnsupportedEncodingException {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 500);
        googlePlacesUrl.append("&type=" + "gas_station");
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyCx8-ZK6m5FTgEoTaSRaUuALV-5Vnz1Co4");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    static String urlplace3() throws UnsupportedEncodingException {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 500);
        googlePlacesUrl.append("&type=" + "shopping_mall");
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyCx8-ZK6m5FTgEoTaSRaUuALV-5Vnz1Co4");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }


    static String urlplace4() throws UnsupportedEncodingException {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 300);
        googlePlacesUrl.append("&type=" + "police");
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyCx8-ZK6m5FTgEoTaSRaUuALV-5Vnz1Co4");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    public void getplaces() {

        String url = null;
        String url2 = null;
        String url3 = null;
        String url4 = null;
        String url5 = null;

        try {

            url = urlplace4();
            url2 = urlplace3();
            url3 = urlplace2();
            url4 = makeURL2();
            url5 = makeURL1();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        placesAsyncTask download = new placesAsyncTask(url);
        placesAsyncTask download2 = new placesAsyncTask(url2);
        placesAsyncTask download3 = new placesAsyncTask(url3);
        placesAsyncTask download4 = new placesAsyncTask(url4);
        placesAsyncTask download5 = new placesAsyncTask(url5);


        download.execute();
        download2.execute();
        download3.execute();
        download4.execute();
        download5.execute();


    }


    public void showplaces(String result) {
        try {
            placeMarkers = new LinkedList<MarkerOptions>();

            final JSONObject son = new JSONObject(result);
            JSONArray placesArray = son.getJSONArray("results");
            for (int i = 1; i < placesArray.length(); i++) {
                JSONObject places = placesArray.getJSONObject(i);
                JSONObject geometry = places.getJSONObject("geometry");
                JSONObject location = geometry.getJSONObject("location");

                placeId = places.getString("place_id");
                LatLng temp = new LatLng((Double) location.get("lat"), (Double) location.get("lng"));
                Log.d("tyty", places.getString("name"));
                if (!place.contains(temp)) {
                    place.add(temp);
                    placename.add(places.getString("name"));
                    placevicinity.add(places.getString("vicinity"));
                    MarkerOptions markerOptions =
                            new MarkerOptions()
                                    .position(temp
                                    ).title(places.getString("name"))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon4))
                                    .snippet("placeId:" + placeId);

                    // Marker placeMarker = mMap.addMarker(markerOptions);
                    //  placeMarkers.add(markerOptions);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("tyty", e.getMessage());
        }

    }


    public static String makeURL3() throws UnsupportedEncodingException {
        String params, waypoints, sensor, main;
        // String traf = "&departure_time=now";
        int i;
        if (points.size() > 2) {
            waypoints = "waypoints=optimize:false";
            for (i = 1; i < points.size() - 1; i++) {
                String Temp = URLEncoder.encode("|", "UTF-8") + points.get(i).latitude + "," + points.get(i).longitude;
                waypoints = waypoints.concat(Temp);
            }
            sensor = "&alternatives=true&sensor=false&mode=driving";
            main = "origin=" + Double.toString(points.get(0).latitude) + "," + Double.toString(points.get(0).longitude) + "&destination=" + Double.toString(points.get(points.size() - 1).latitude) + "," + Double.toString(points.get(points.size() - 1).longitude);
            params = main + "&" + waypoints + sensor;
        } else {
            sensor = "&sensor=false&mode=driving&alternatives=true";
            main = "origin=" + Double.toString(latLng.latitude) + "," + Double.toString(latLng.longitude) + "&destination=" + Double.toString(points.get(points.size() - 1).latitude) + "," + Double.toString(points.get(points.size() - 1).longitude);
            params = main + sensor;
        }
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + params + "&key=AIzaSyDK1zxUEp38e6sQYzJq6qGNKxdOUqUZR1Y";
        Log.d("mama", url);
        return url;
    }

    public static String makeURL4() throws UnsupportedEncodingException {
        String params, waypoints, sensor, main;
        // String traf = "&departure_time=now";
        int i;
        if (points.size() > 1) {
            waypoints = "waypoints=optimize:true";
            for (i = 1; i < points.size() - 1; i++) {
                String Temp = URLEncoder.encode("|", "UTF-8") + points.get(i).latitude + "," + points.get(i).longitude;
                waypoints = waypoints.concat(Temp);
            }
            sensor = "&alternatives=true&sensor=false&mode=driving";
            main = "origin=" + Double.toString(points.get(0).latitude) + "," + Double.toString(points.get(0).longitude) + "&destination=" + Double.toString(points.get(points.size() - 1).latitude) + "," + Double.toString(points.get(points.size() - 1).longitude);
            params = main + "&" + waypoints + sensor;
        } else {
            sensor = "&sensor=false&mode=driving&alternatives=true";
            main = "origin=" + Double.toString(latLng.latitude) + "," + Double.toString(latLng.longitude) + "&destination=" + Double.toString(points.get(points.size() - 1).latitude) + "," + Double.toString(points.get(points.size() - 1).longitude);
            params = main + sensor;
        }
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + params + "&key=AIzaSyDK1zxUEp38e6sQYzJq6qGNKxdOUqUZR1Y";
        Log.d("mama", url);
        return url;
    }

    public void drawcheck(String result) {
        try {
            //Tranform the string into a json object
            final JSONObject json = new JSONObject(result);
            JSONArray routeArray = json.getJSONArray("routes");
            JSONArray waypoints = json.getJSONArray("geocoded_waypoints");
            Log.d("tntn", waypoints.length() + "");
            if (routeArray.length() > 1) {
                altroute.setVisibility(View.VISIBLE);
                res = result;
                rl = routeArray.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawPath(String result) {
//        if (line != null) {
//            line.remove();
//        }


        try {
            //Transform the string into a json object
            final JSONObject json = new JSONObject(result);
            JSONArray routeArray = json.getJSONArray("routes");


            JSONArray waypoints = json.getJSONArray("geocoded_waypoints");


            if (routeArray.length() > 1) {
                try {
                    altroute.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                }

                res = result;
                rl = routeArray.length();
            }

            if (routeArray.length() > 0) {

                //add the set of routes to the list of routeArray
                listOfRouteArray.add(routeArray);

                //add the index of the route currently used
                //add the index of the route currently used
                listOfIndicesOfCurrentRoutes.add(0);

                JSONObject routes = routeArray.getJSONObject(0);
                JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
                String encodedString = overviewPolylines.getString("points");

                List<LatLng> list = decodePoly(encodedString);
                PolylineOptions options = new PolylineOptions().width(10).color(Color.GREEN).geodesic(true);


                for (int z = 0; z < list.size(); z++) {
                    LatLng point = list.get(z);
                    options.add(point);
                }
                polylines.add(mMap.addPolyline(options));

                //add the new polyline to the list of polylines

            /*    if (waypoints.length() > 2) {
                    bigline = line;
                }*/

                JSONArray legsarray = routes.getJSONArray("legs");
                JSONObject forturn = legsarray.getJSONObject(0);
                turns = forturn.getJSONArray("steps");

                durations = new LinkedList<String>();
                distances = new LinkedList<String>();
                durations.add(new String("0"));
                distances.add(new String("0"));
                reminders.add(new String("0"));
                timestoStay.add(new String("0"));
                mins.add(new String("0"));
//                polylines.add(line);
                String distance = "0";
                String duration = "0";

                if (legsarray.length() > 0) {


                    String temp1 = "";

                    for (int i = 0; i < markers.size() - 1; i++) {


                        JSONObject legs = legsarray.getJSONObject(i);
                        JSONObject distanceobject = legs.getJSONObject("distance");
                        distances.add(distanceobject.getString("value"));


                        JSONObject durationObject = legs.getJSONObject("duration");
                        durations.add(convertSecondsToTimeString(Integer.parseInt(durationObject.getString("value"))));


                        int zx = listofturns.size();
                        Log.d("zxc", "" + zx);


                        duration = duration + "-- " + durationObject.getString("value");
                        distance = distance + "-- " + distanceobject.getString("value");
                        temp1 = temp1 + " -->" + "pt" + i;


                    }


                }


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Double lat;
            Double lon;
            Double elat;
            Double elon;

            for (int zxcz = 0; zxcz < turns.length(); zxcz++) {
                TurnItem turnk = new TurnItem();
                JSONObject t1 = turns.getJSONObject(zxcz);
                JSONObject layo = t1.getJSONObject("distance");
                JSONObject oras = t1.getJSONObject("duration");
                JSONObject startUser = t1.getJSONObject("start_location");
                lat = Double.valueOf(Html.fromHtml(startUser.getString("lat")).toString());
                lon = Double.valueOf(Html.fromHtml(startUser.getString("lng")).toString());
                Log.d("ustart", "" + lat);
                Log.d("ustart", "" + lon);
                latz.add(lat);
                longz.add(lon);
                JSONObject EndUser = t1.getJSONObject("end_location");
                elat = Double.valueOf(Html.fromHtml(EndUser.getString("lat")).toString());
                elon = Double.valueOf(Html.fromHtml(EndUser.getString("lng")).toString());
                Log.d("endstart", "" + elat);
                Log.d("endstart", "" + elon);
                elatz.add(elat);
                elongz.add(elon);


                turnk.setturn(Html.fromHtml(t1.getString(ins)).toString());
                turnk.setdis(Html.fromHtml(layo.getString("text")).toString());
                turnk.setdur(Html.fromHtml(oras.getString("text")).toString());

                InitialListStaffs.add(turnk);
                ttsturns.add(Html.fromHtml(t1.getString(ins)).toString());

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapterStaff = new TurnAdapter(InitialListStaffs, getApplicationContext());

        recyclerViewStaff.setAdapter(adapterStaff);
    }


  /*  public void drawPath(String result) {
        if (line != null) {
            line.remove();
        }
        try {
            //Transform the string into a json object
            final JSONObject json = new JSONObject(result);
            JSONArray routeArray = json.getJSONArray("routes");
            JSONArray waypoints = json.getJSONArray("geocoded_waypoints");

            if (routeArray.length() > 1) {
                try {
                    altroute.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                }

                res = result;
                rl = routeArray.length();
            }

            if(routeArray.length() > 0) {

                //add the set of routes to the list of routeArray
                listOfRouteArray.add(routeArray);

                //add the index of the route currently used
                listOfIndicesOfCurrentRoutes.add(0);

                JSONObject routes = routeArray.getJSONObject(rn);
                JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
                String encodedString = overviewPolylines.getString("points");
                List<LatLng> list = decodePoly(encodedString);
                PolylineOptions options = new PolylineOptions().width(10).color(Color.GREEN).geodesic(true);
                for (int z = 0; z < list.size(); z++) {
                    LatLng point = list.get(z);
                    options.add(point);
                }
                line = mMap.addPolyline(options);
                if (waypoints.length() > 2) {
                    bigline = line;
                }
                JSONArray legsarray = routes.getJSONArray("legs");

                durations = new LinkedList<String>();
                distances = new LinkedList<String>();
                durations.add(new String("0"));
                distances.add(new String("0"));
                reminders.add(new String("0"));
                timestoStay.add(new String("0"));
                mins.add(new String("0"));


                String distance = "0";
                String duration = "0";

                if (legsarray.length() > 0) {


                    String temp1 = "";

                    for (int i = 0; i < markers.size() - 1; i++) {
                        JSONObject legs = legsarray.getJSONObject(i);
                        JSONObject distanceobject = legs.getJSONObject("distance");
                        distances.add(distanceobject.getString("value"));
                        JSONObject durationObject = legs.getJSONObject("duration");
                        durations.add(convertSecondsToTimeString(Integer.parseInt(durationObject.getString("value"))));

                        duration = duration + "--Second:" + durationObject.getString("value");
                        distance = distance + "--Meters: " + distanceobject.getString("value");
                        temp1 = temp1 + " -->" + "pt" + i;
                    }


                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/

    //called when alternate route button is clicked
    public void alternateRoute() {

        //If the displayed polyline of the route to the first destination is not the last alternative
        //polyline, display the next alternative polyline else called the
        // incrementRouteIndexOfNextOrderPolyline() function. Take a look at
        // incrementRouteIndexOfNextOrderPolyline() and look at this example. example: if we have
        // 138 the next count is 139.

        if (!listOfRouteArray.isEmpty()) {
            if ((listOfIndicesOfCurrentRoutes.get(0) + 1) < listOfRouteArray.get(0).length()) {

                alternatePolyline(0, listOfIndicesOfCurrentRoutes.get(0) + 1);

            } else {
                incrementRouteIndexOfNextOrderPolyline(0);
            }
        }

        Log.d("WAXAAXAXAXAXAX", String.valueOf(listOfRouteArray));
        Log.d("WAXAAXAXAXAXAX2", String.valueOf(listOfIndicesOfCurrentRoutes));

    }

    //To easily understand the functioning of this function, counting from 0 to 100. We start at 000,
    //when we reach 009, the next count is 010. When we reach 019, the next count is 020 and so on.
    //when we reach 099 the next count is 100 and when we reach 199 the next count is 200 and so on.
    //Now consider that to alternate routes, we are counting them an displaying the current count on
    //the map. The difference between this count and the one in the example is that the last digit is
    //not always 9 or the same for each digit order. That is the number of alternative routes from the
    //origin to a destination is not always the same for all destinations. Some might have 2, 1, 3 etc.
    //An example of a counting for this routes is 000 then 100 or 1234 then 2000, with the number of
    //digit representing the number of destination. This function helps in a next order incrementation;
    //that is in transition such as 009 t0 010 or 099 to 100 or 122 t0 200 or 111 to 200 etc
    private void incrementRouteIndexOfNextOrderPolyline(int indexOfPolyline) {

        //sets the polyline of the route to a destination to the first polyline of the list of all
        //possible polylines of the route to that destination. Tha is if a digit was 9 set it to 0.
        alternatePolyline(indexOfPolyline, 0);

        //if the route to destination with dealing with is the route to the lastly added destination
        //return. that is if the digit is the first 9 in 9999 return.
        if ((indexOfPolyline + 1) >= polylines.size()) {
            return;
        }

        //if the polyline of the next order route to destination is not that last possible alternative
        //polyline for that route, set it to the next possible polyline else increment the index of it's
        // next order polyline. that is if we have 118 and we are dealing with 8 make the next count to
        // be 119 else we have 119 make it to be 120
        if ((listOfIndicesOfCurrentRoutes.get(indexOfPolyline + 1) + 1) <
                listOfRouteArray.get(indexOfPolyline + 1).length()) {

            //Correction on this statement
            alternatePolyline(indexOfPolyline + 1,
                    listOfIndicesOfCurrentRoutes.get(indexOfPolyline + 1) + 1);

        } else {
            incrementRouteIndexOfNextOrderPolyline(indexOfPolyline + 1);
        }

        //This function is recursive a such the incrementation will done recursively. for example if
        //we have 199 the first order 9 will be set to 0 and the second order 9 incremented. The
        // second order 9 in turns will be set to 0 and the third order 1 will be 2 to give 200. But
        //in case of 189 the result will obviously be 190 without a recursive call.
    }

    //Used to display the new polyline in place of the currently displayed polyline for the route to
    //a specific destination.


    private void alternatePolyline(int indexOfRouteToAlternate, int indexOfNewPolyline) {

        try {
            JSONObject routes = listOfRouteArray.get(indexOfRouteToAlternate).getJSONObject(indexOfNewPolyline);
            JSONArray legsarray = routes.getJSONArray("legs");
            JSONObject forturn = legsarray.getJSONObject(0);
            turns = forturn.getJSONArray("steps");
            JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
            String encodedString = overviewPolylines.getString("points");
            List<LatLng> list = decodePoly(encodedString);
            PolylineOptions options = new PolylineOptions().width(10).color(Color.GREEN).geodesic(true);
            for (int z = 0; z < list.size(); z++) {
                LatLng point = list.get(z);
                options.add(point);

            }

            InitialListStaffs.clear();
            ttsturns.clear();

            polylines.get(indexOfRouteToAlternate).remove();
            polylines.set(indexOfRouteToAlternate, mMap.addPolyline(options));


            listOfIndicesOfCurrentRoutes.set(indexOfRouteToAlternate, indexOfNewPolyline);

            for (int zxcz = 0; zxcz < turns.length(); zxcz++) {
                TurnItem turnk = new TurnItem();
                JSONObject t1 = turns.getJSONObject(zxcz);
                JSONObject layo = t1.getJSONObject("distance");
                JSONObject oras = t1.getJSONObject("duration");
                turnk.setturn(Html.fromHtml(t1.getString(ins)).toString());
                turnk.setdis(Html.fromHtml(layo.getString("text")).toString());
                turnk.setdur(Html.fromHtml(oras.getString("text")).toString());
                InitialListStaffs.add(turnk);
                ttsturns.add((Html.fromHtml(t1.getString(ins)).toString()));
            }

            //Correction starts here
//            line = mMap.addPolyline(options);

            //Correction ends here

        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapterStaff = new TurnAdapter(InitialListStaffs, getApplicationContext());

        recyclerViewStaff.setAdapter(adapterStaff);
        adapterStaff.notifyDataSetChanged();
        recyclerViewStaff.invalidate();
    }


    public String convertSecondsToTimeString(int seconds) {

        int sec = seconds % 60;
        int min = (seconds / 60) % 60;
        int hours = (seconds / 60) / 60;

        if (hours > 0) {
            return hours + " hrs: " + min + " min: " + sec + " s";
        } else {
            return min + " min: " + sec + " s";
        }
    }


    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }


    int bayani = 0;
    int cof = 0;
    int dam = 0;
    int east = 0;
    int edsa = 0;
    int maginhawa = 0;
    int ninoy = 0;
    int parish = 0;
    int ateneo = 0;
    int art = 0;
    int people = 0;

    int qmc = 0;
    int up = 0;
    int vargas = 0;
    int watershed = 0;
    int wildlife = 0;

    int ayala = 0;

    int tsinoy = 0;
    int casa = 0;
    int ccp = 0;
    int coconut = 0;
    int filipino = 0;
    int luneta = 0;
    int manilacathedral = 0;
    int national = 0;
    int nayongfilipino = 0;
    int pacopark = 0;
    int sanagustin = 0;
    int star = 0;

    public void places(View view) {
      /*  if (button1 == 1) {
            ChoicesOfPlace.open = 1;
            Intent i = new Intent(traffic.this, ChoicesOfPlace.class);
            startActivity(i);
        } else if (button1 == 2) {

            Intent i = new Intent(traffic.this, SummaryOfTour.class);
            startActivity(i);
        }
*/

    }


    public void selected() {

        if (InfoOfArt.select == 1) {
            if (art == 0) {

                ArtInIsland();
                art = 1;


            } else if (art == 1) {


            }
        }


        if (InfoOfCOF.select == 1) {

            if (cof == 0) {
                circleoffun();
                cof = 1;
            } else if (cof == 1) {

            }
        }

        if (InfoOfQmc.select == 1) {


            if (qmc == 0) {


                MemorialCircle();
                qmc = 1;


            } else if (qmc == 1) {

            }

        }


        if (InfoOfNinoy.select == 1) {


            if (ninoy == 0) {
                wildlife();
                ninoy = 1;
            } else if (ninoy == 1) {

            }

        }


        if (InfoOfBayani.select == 1) {
            if (bayani == 0) {
                bantayog();
                bayani = 1;
            } else if (bayani == 1) {

            }

        }

        if (InfoOfMaginhawa.select == 1) {


            if (maginhawa == 0) {
                maginhawa();
                maginhawa = 1;
            } else if (maginhawa == 1) {

            }
        }


        if (InfoOfVargas.select == 1) {


            if (vargas == 0) {
                vargas();
                vargas = 1;
            } else if (vargas == 1) {

            }

        }


        if (InfoOfUp.select == 1) {
            if (ayala == 0) {
                ayala();
                ayala = 1;
            } else if (ayala == 1) {

            }
        }


        if (InfoOfParish.select == 1) {
            if (parish == 0) {
                parish();
                parish = 1;

            } else if (parish == 1) {

            }
        }
        if (InfoOfAteneo.select == 1) {

            if (ateneo == 0) {
                ateneogallery();
                ateneo = 1;
            } else if (ateneo == 1) {

            }

        }


        if (InfoOfEdsa.select == 1) {

            if (edsa == 0) {
                edsa();
                edsa = 1;
            } else if (edsa == 1) {

            }

        }
        if (InfoOfPeople.select == 1) {


            if (people == 0) {
                people();
                people = 1;
            } else if (people == 1) {

            }

        }


        if (InfoOfEast.select == 1) {

            if (east == 0) {
                eastwood();
                east = 1;
            } else if (east == 1) {

            }
        }


        if (InfoOfWatershed.select == 1) {


            if (watershed == 0) {
                watershed();
                watershed = 1;
            } else if (watershed == 1) {

            }

        }


        if (InfoOfDam.select == 1) {

            if (dam == 0) {
                lamesa();
                dam = 1;
            } else if (dam == 1) {

            }
        }

        ////////////////MANILA////////////////////////////

        if (SelectQcBagManila.manila == 1) {
            if (BahayTsinoy.select == 1) {

                if (tsinoy == 0) {
                    bahaytsinoy();
                    tsinoy = 1;
                } else if (tsinoy == 1) {

                }
            }

            if (CasaManila.select == 1) {

                if (casa == 0) {
                    casa();
                    casa = 1;
                } else if (casa == 1) {

                }
            }

            if (CCP.select == 1) {

                if (ccp == 0) {
                    culturalcenter();
                    ccp = 1;
                } else if (ccp == 1) {

                }
            }


            if (coconutpalace.select == 1) {

                if (coconut == 0) {
                    coconutpalace();
                    coconut = 1;
                } else if (coconut == 1) {

                }
            }

            if (FilipinoChinese.select == 1) {

                if (filipino == 0) {
                    filipinochinese();
                    filipino = 1;
                } else if (filipino == 1) {

                }
            }

            if (Luneta.select == 1) {

                if (luneta == 0) {
                    luneta();
                    luneta = 1;
                } else if (luneta == 1) {

                }
            }

            if (ManilaCathedral.select == 1) {

                if (manilacathedral == 0) {
                    manilacathedral();
                    manilacathedral = 1;
                } else if (manilacathedral == 1) {

                }
            }

            if (NationalMuseum.select == 1) {

                if (national == 0) {
                    nationalmuseum();
                    national = 1;
                } else if (national == 1) {

                }
            }

            if (NayongFilipino.select == 1) {

                if (nayongfilipino == 0) {
                    nayongfilipino();
                    nayongfilipino = 1;
                } else if (nayongfilipino == 1) {

                }
            }
            if (PacoPark.select == 1) {

                if (pacopark == 0) {
                    pacopark();
                    pacopark = 1;
                } else if (pacopark == 1) {

                }
            }

            if (SanAgustinChurch.select == 1) {

                if (sanagustin == 0) {
                    sanagustin();
                    sanagustin = 1;
                } else if (sanagustin == 1) {

                }
            }
            if (starcity.select == 1) {

                if (star == 0) {
                    starcity();
                    star = 1;
                } else if (star == 1) {

                }
            }
        }

        Toast.makeText(getApplicationContext(), "Place Updated!", Toast.LENGTH_LONG).show();


    }


    public void destinationclear(View view) {

        mMap.clear();
        points.clear();
        markers.clear();
        mList.clear();
        distances.clear();
        durations.clear();
        reminders.clear();
        timestoStay.clear();
        mins.clear();

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("My Location")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.kikomarke1r11))
                .anchor(0.5f, 1);

        Marker m = mMap.addMarker(markerOptions);

        markers.add(m);
        //EXTRA CODES
        mList.add(markerOptions);

/*    durations.add(new String("0"));
    distances.add(new String("0"));*/

        // Log.d("meme",myLocation.toString());
        LatLng myLatLng = new LatLng(myLocation.getLatitude(),
                myLocation.getLongitude());
        // Log.d("meme",myLatLng.toString());

        points.add(myLatLng);


    }

    public void coconutpalace() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5552;
        double we = 120.9801;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Coconut Palace")
                .snippet("placeId:" + "ChIJHd9_vGjJlzMRh8gyqquj-IU")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void starcity() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5560;
        double we = 120.9858;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Star City")
                .snippet("placeId:" + "ChIJO2OyW9jLlzMRYewVuNPw_b4")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void pacopark() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5810;
        double we = 120.9884;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Paco Park and Cemetery")
                .snippet("placeId:" + "ChIJCZYEzInJlzMR3mf_SZ0OMC8")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void culturalcenter() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5583;
        double we = 120.9857;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Cultural Center of the Philippines")
                .snippet("placeId:" + "ChIJ4-SowNnLlzMReoFLHeWmnvo")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void nationalmuseum() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5869;
        double we = 120.9812;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("National Museum")
                .snippet("placeId:" + "ChIJa5tW0CPKlzMRKuDqk7sMx88")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void museopambata() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5791;
        double we = 120.9771;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Museo Pambata")
                .snippet("placeId:" + "ChIJJ5tR6C_KlzMRotI-i4JR63c")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void manilaoceanpark() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5792;
        double we = 120.9725;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Manila Ocean Park")
                .snippet("placeId:" + "ChIJDXUM9QPKlzMRDOajr3iHEoQ")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void filipinochinese() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5971459;
        double we = 120.9764795;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Filipino - Chinese Friendship Arch")
                .snippet("placeId:" + "ChIJ-2XPChrKlzMRqX24Y0diny0")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void nayongfilipino() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.584872;
        double we = 120.980213;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Nayong Filipino")
                .snippet("placeId:" + "ChIJBwiSdSTKlzMRotTbhah69VU")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void bahaytsinoy() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5909;
        double we = 120.9750;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Bahay Tsinoy")
                .snippet("placeId:" + "ChIJOQDs4RfKlzMRaB4gcZD1FyY")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void sanagustin() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5886;
        double we = 120.9749;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("San Agustin Church and Museum")
                .snippet("placeId:" + "ChIJyRjgIz3KlzMRMB6UgLCNQ58")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void manilacathedral() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5915;
        double we = 120.9736;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Manila Cathedral")
                .snippet("placeId:" + "ChIJeWcu0hfKlzMRnYOqfe-gowY")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void casa() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.591496;
        double we = 120.9794;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Casa Manila Intramuros")
                .snippet("placeId:" + "ChIJgS96OD3KlzMR91wyTDiHHCg")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }
    public void moa() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5346;
        double we = 120.9825;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Ayala Triangle Gardens")
                .snippet("placeId:" + "ChIJ144ohPzLlzMRmx9wLn0FQug")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void sansebastian() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5996;
        double we = 120.9890;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("San Sebastian Church")
                .snippet("placeId:" + "ChIJ13JFIvjJlzMRj092bSUBXv0")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void quiapochurch() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5988;
        double we = 120.9838;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Quiapo Church")
                .snippet("placeId:" + "ChIJJ55LwhzKlzMR98AoQTtJ7SY")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void luneta() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5831;
        double we = 120.9794;
        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Luneta/Rizal Park")
                .snippet("placeId:" + "ChIJPxN-XiXKlzMRMpp1toc0Krc")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void ayala() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6614;
        double we = 121.0635;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("UP Technohub")
                .snippet("placeId:" + "ChIJK2RZshS3lzMRBFjc7R0tyIU")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void parish() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6584;
        double we = 121.0711;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .snippet("placeId:" + "ChIJo3WucGe3lzMR_iYmkhk6TjI")
                .title("The Parish Sacrifice")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void watershed() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.7452;
        double we = 121.0984;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Lamesa Watershed")
                .snippet("placeId:" + "ChIJS8sCX8e6lzMRuwnG170scsI")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void vargas() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.653056;
        double we = 121.066667;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Jorge B.Vargas Museum")
                .snippet("placeId:" + "ChIJc7klbG-3lzMRpQnjjsAGPqw")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void people() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6000;
        double we = 121.0600;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("People Power Monument")
                .snippet("placeId:" + "ChIJkVJ4z-G3lzMRtIL8hox324E")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));
        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void manilachinesecemetery() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6325;
        double we = 120.9847;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Manila Chinese Cemetery")
                .snippet("placeId:" + "ChIJhZI7NN61lzMRa1404T_5MlM")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void chinatown() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6012;
        double we = 120.9750;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("China Town / Binondo")
                .snippet("placeId:" + "ChIJCYk0LRDKlzMR-N9ONSkgq-0")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void manilaamericancemetery() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5409;
        double we = 121.0503;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Manila American Cemetery")
                .snippet("placeId:" + "ChIJBxujhOnIlzMRlFEu4ycSgK0")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void armedforces() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6110;
        double we = 121.0619;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Armed Forces of the Philippines Museum")
                .snippet("placeId:" + "ChIJK725zei3lzMRdjehQsQsUKw")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void domingo() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6263;
        double we = 121.0102;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Santo Domingo Church")
                .snippet("placeId:" + "ChIJZyfdAEC2lzMRjdk72SmJsyw")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void monasterio() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6303;
        double we = 121.0746;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Monasterio De Sta. Clara")
                .snippet("placeId:" + "ChIJzVQIaoa3lzMR5AnOW2Sdfd0")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void cubaoexpo() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6223;
        double we = 121.0564;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Cubao expo")
                .snippet("placeId:" + "ChIJ7TL-17-3lzMRxP6C7aZp64A")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void lamesa() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.7164;
        double we = 121.0724;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("La Mesa Dam and Reservoir")
                .snippet("placeId:" + "ChIJbyf0oIawlzMRCRQnxW-0wEs")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void pagasa() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6474;
        double we = 121.0396;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Pagasa Planetarium")
                .snippet("placeId:" + "ChIJn9JPuQe3lzMRn3Wi8utObiI")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void rita() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6483;
        double we = 121.0322;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Sta. Rita de Cascia Parish")
                .snippet("placeId:" + "ChIJH0W3P_62lzMRMg5dO-FkrKI")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void wildlife() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6509;
        double we = 121.0440;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Ninoy Aquino WildLife")
                .snippet("placeId:" + "ChIJAeHvngW3lzMRikJHv1z5cVI")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void bantayog() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6442;
        double we = 121.0393;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Bantayog ng mga Bayani")
                .snippet("placeId:" + "ChIJ2yEQTQe3lzMRbfDgt60K770")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void eastwood() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6099;
        double we = 121.0811;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Eastwood City")
                .snippet("placeId:" + "ChIJp79Jhh24lzMRGBBcLU5fzio")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void churchgesu() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6401;
        double we = 121.0800;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Church of the Gesu")
                .snippet("placeId:" + "ChIJh1SYgtW5lzMRgkVhXmhwt9E")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void maginhawa() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6467;
        double we = 121.0588;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Maginhawa Food Park")
                .snippet("placeId:" + "ChIJLyKHcHO3lzMRkPD3eaV8zo4")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));
        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void edsa() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5926;
        double we = 121.0587;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Edsa Shrine")
                .snippet("placeId:" + "ChIJ83np5BjIlzMRQnvbQuvP320")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void ateneogallery() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6401;
        double we = 121.0773;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Ateneo Art Gallery")
                .snippet("placeId:" + "ChIJQdDOsX-3lzMRsMd8b7e3uDk")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void santamaria() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6475;
        double we = 121.0752;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Sta Maria Dela Strada")
                .snippet("placeId:" + "ChIJazWVwHy3lzMRAUHR5Esc9AA")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));
        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void uptc() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6509;
        double we = 121.0753;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("UP Town Center")
                .snippet("placeId:" + "ChIJHao_OWO3lzMRjOuMs_XND84")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void balara() {




       /* Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();*/

        double wa = 14.6572;
        double we = 121.0779;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Balara Filter Park")
                .snippet("placeId:" + "ChIJCyiJ5d-5lzMR0CBYpfXkOE8")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void up() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6546;
        double we = 121.0647;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("University of the Philippines Diliman")
                .snippet("placeId:" + "ChIJBURBCm63lzMR65XYe4mXKhw")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void qcx() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6516;
        double we = 121.0514;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Quezon City Experience")
                .snippet("placeId:" + "ChIJJRUU-w23lzMRkCSPWgARC-A")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void circleoffun() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6534;
        double we = 121.0480;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Circle of Fun")
                .snippet("placeId:" + "ChIJKeIIzxG3lzMREPRXb7ccU40")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void heritage() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6495;
        double we = 121.0503;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("The Quezon Heritage House")
                .snippet("placeId:" + "ChIJCykyhw63lzMRDY_BQBLbE8o")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

/*

        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);
*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void MemorialCircle() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6516;
        double we = 121.04941;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Quezon Memorial Circle")
                .snippet("placeId:" + "ChIJ6csDPg63lzMR6I3qWXvgpVY")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));
        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/


        //connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        // downloadTask2.execute();

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void mystery() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6063;
        double we = 121.0787;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Mystery Manila")
                .snippet("placeId:" + "ChIJ3bGhD_i3lzMROoN7udn8v30")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));
        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/


        //connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        // downloadTask2.execute();

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void kamalig() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6192;
        double we = 121.0564;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Sining Kamalig")
                .snippet("placeId:" + "ChIJ3xrTH8C3lzMReJnE6215ffA")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));
        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/


        //connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        // downloadTask2.execute();

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }

    public void manilazoo() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.5651;
        double we = 120.9885;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Manila Zoo")
                .snippet("placeId:" + "ChIJ4_WFMX7JlzMRJOkBCvft38A")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));
        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/


        //connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        // downloadTask2.execute();

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void fernwood() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6690;
        double we = 121.0481;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Fernwood Gardens")
                .snippet("placeId:" + "ChIJ5222gju3lzMRTgrD9gxfVko")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));
        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/


        //connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        // downloadTask2.execute();

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void amoranto() {


        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();

        double wa = 14.6300;
        double we = 121.0231;

        LatLng was = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(was)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Amoranto Sports Complex")
                .snippet("placeId:" + "ChIJsZziyUi2lzMR3jzSSV_20S0")
                .anchor(0.5f, 1);


        points.add(was);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));
        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));

        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/


        //connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        // downloadTask2.execute();

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    public void q1() {
        String[] multipleHours = {"9", "11", "13", "14", "15", "17", "18"}; //store here the hours for every alarm you want to set
        String[] multipleMinutes = {"45", "0", "0", "0", "45", "0", "45"}; //store here the minutes
        // int[] multipleHours = {9, 11, 13, 14, 15, 17, 18}; //store here the hours for every alarm you want to set
        // int[] multipleMinutes = {45, 0, 0, 0, 45, 0, 45}; //store here the minutes
        String[] multipleDestinations = {"Departure", "Quezon Heritage House", "Art In Island", "Quezon City Experience", "Quezon Memorial", " Destination 5", "Destination 6"}; //same thing for destinations
        String[] multipleReminders = {"You need to go to Destination 1", "Timeout, Go to next destination", "Timeout, Go to next destination", "Timeout, Go to next destination", "Timeout, Go to next destination", "Timeout, Go to next destination", "Package Ended!"}; //and reminders
        HashMap<String, String> alarm = new HashMap<>();
        int notificationId = (alarmIndex >= 0) ? alarmIndex : alarmClocks.size();
        alarm.put(ApplicationConstants._ID, String.valueOf(notificationId));
        alarm.put(ApplicationConstants.HOUR, Arrays.toString(multipleHours));
        alarm.put(ApplicationConstants.MINUTE, Arrays.toString(multipleMinutes));
        alarm.put(ApplicationConstants.REMINDER, String.valueOf(multipleReminders));
        alarm.put(ApplicationConstants.DESTINATION, String.valueOf(multipleDestinations));
        alarmClocks.add(alarm);

    }

    private void setAlarm(int hour, int minute, int notificationId, String reminder, String destination) {
        Intent i;
        PendingIntent pi;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int currentHour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        int monthDay = calendar.get(java.util.Calendar.DAY_OF_YEAR);
        i = new Intent(this, AlarmReceiver.class);
        i.putExtra(ApplicationConstants._ID, notificationId);
        i.putExtra(ApplicationConstants.REMINDER, reminder);
        i.putExtra(ApplicationConstants.DESTINATION, destination);
        pi = PendingIntent.getBroadcast(this, notificationId, i, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (currentHour > hour) {
            calendar.set(java.util.Calendar.DAY_OF_YEAR, (monthDay + 1));
            calendar.set(java.util.Calendar.HOUR_OF_DAY, hour);
            calendar.set(java.util.Calendar.MINUTE, minute);
            calendar.set(java.util.Calendar.SECOND, 0);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        } else if (currentHour <= hour) {
            calendar.set(java.util.Calendar.HOUR_OF_DAY, hour);
            calendar.set(java.util.Calendar.MINUTE, minute);
            calendar.set(java.util.Calendar.SECOND, 0);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        }
    }

    public void ArtInIsland() {


        double wa = 14.6228;
        double we = 121.0581;

        LatLng xaxa = new LatLng(wa, we);


        MarkerOptions markerOptions = new MarkerOptions()
                .position(xaxa)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placesz))
                .title("Art In Island")
                .snippet("placeId:" + "ChIJ5UTioJW3lzMRCVEsXIinoQY")
                .anchor(0.5f, 1);


        points.add(xaxa);


        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String("."));
        timestoStay.add(new String("."));
        mins.add(new String("."));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


/*        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);*/

        connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, true);
        downloadTask2.execute();


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Collect data from the intent and use it
        int request = requestCode;
        int result = resultCode;

        mMap.clear();
        InitialListStaffs.clear();
        ttsturns.clear();
        elatz.clear();
        elongz.clear();
        //add markers back
        int current = 0;
        for (MarkerOptions options : mList) {
            Marker m = mMap.addMarker(options);
            //reset icons
            m.setIcon(icons[current++]);
            adapterStaff.notifyDataSetChanged();
        }

        //add places back
        for (MarkerOptions place : placeMarkers) {
            Marker m = mMap.addMarker(place);
        }


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {

            connectAsyncTask2 downloadTask2 = new connectAsyncTask2(url, this, false);
            downloadTask2.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void cleardestination() {
        mMap.clear();
        points.clear();
        markers.clear();
        mList.clear();
        distances.clear();
        durations.clear();
        reminders.clear();
        timestoStay.clear();
        mins.clear();

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("My Location")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.kikomarke1r11))
                .anchor(0.5f, 1);

        Marker m = mMap.addMarker(markerOptions);

        markers.add(m);
        //EXTRA CODES
        mList.add(markerOptions);

/*    durations.add(new String("0"));
    distances.add(new String("0"));*/

        // Log.d("meme",myLocation.toString());
        LatLng myLatLng = new LatLng(myLocation.getLatitude(),
                myLocation.getLongitude());
        // Log.d("meme",myLatLng.toString());

        points.add(myLatLng);
    }


    Marker now;
    double curTime = 0;
    double oldLat = 0.0;
    double oldLon = 0.0;
    CameraPosition cameraPosition;
    int exisitingx;
    Marker m;

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        latLng = new LatLng(location.getLatitude(), location.getLongitude());


        Log.d("InfoOfArt.select", "InfoOfArt.select" + InfoOfArt.select);
        Log.d("InfoOfArt.select", "art" + art);

        getspeed(location);


        Log.d("asd123,lat", "" + latitude);
        Log.d("asd123,long", "" + longitude);
        Log.d("asd123,latlng", "" + latLng);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(false);
        Log.d("onLocationChanged", "entered");


        //Toast.makeText(traffic.this, "Your Current Location", Toast.LENGTH_LONG).show();
/*        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("My Location")

                .icon(BitmapDescriptorFactory.fromResource(R.drawable.drivermode))
                .anchor(0.5f, 1);

        Marker m = mMap.addMarker(markerOptions);*/

        if (durations.size() > 1 && distances.size() > 1) {
            distancez.setText(distances.get(1).toString() + "m");
            durationz.setText(durations.get(1).toString());
        } else {
            distancez.setText("0");
            durationz.setText("0");
        }
        if (mList.size() == 0) {

            MarkerOptions markerOptions = new MarkerOptions()
                    .position(latLng)
                    .title("My Location")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.kikomarke1r11))
                    .anchor(0.5f, 1);

            m = mMap.addMarker(markerOptions);
            getplaces();

            markers.add(m);
            //EXTRA CODES
            mList.add(markerOptions);
            durations.add(new String("0"));
            distances.add(new String("0"));
            reminders.add(new String(""));


            // Log.d("meme",myLocation.toString());

            // Log.d("meme",myLatLng.toString());

            points.add(latLng);

        }

//major change in the onlocation change. other than that nothing else.
        if (mList.size() == 1) {
            if (!InitialListStaffs.isEmpty()) {
                InitialListStaffs.clear();
                adapterStaff.notifyDataSetChanged();
                polylines.clear();
                points.set(0, latLng);


            }
        }
// end of major change


        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
            //   m.remove();
        }


        if (driving == 1) {
            mMap.setMyLocationEnabled(false);

            mCurrLocationMarker = mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .flat(true)

                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.nav3)));


            cameraPosition =
                    new CameraPosition.Builder()
                            .target(latLng)
                            .bearing(kantoliko)

                            .tilt(90)
                            .zoom(19)
                            .build();

            mMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(cameraPosition));
            mCurrLocationMarker.setRotation(kantoliko);

        } else if (driving == 0) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory
                    .zoomTo(15)
            );


        }


        Log.d("asd123", "" + mList.size());
        Log.d("asd123", "" + points.size());
        Log.d("asd123", "" + markers.size());
        Log.d("asd123,desto", "" + desto);
        Log.d("asd123,markarlayo", "" + markarlayo);
        Log.d("asd123,markerinos", "" + markerinos);
        Log.d("asd123,kantors", "" + kantors);

        Log.d("asd123,elatz", "" + elatz.size());
        Log.d("asd123,elongz", "" + elongz.size());


        if (!elatz.isEmpty() && !elongz.isEmpty()) {
            if (mList.size() > 1) {

                RideParameters rideParams = new RideParameters.Builder()
                        .setPickupLocation(latitude, longitude, "You", "")
                        .setDropoffLocation(markers.get(1).getPosition().latitude, markers.get(1).getPosition().longitude, "Your Destination", "") // Price estimate will only be provided if this is provided.
                        .setProductId("a1111c8c-c720-46c3-8534-2fcdd730040d") // Optional. If not provided, the cheapest product will be used.
                        .build();


                RideRequestButtonCallback callback = new RideRequestButtonCallback() {

                    @Override
                    public void onRideInformationLoaded() {

                    }

                    @Override
                    public void onError(ApiError apiError) {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                };

                requestButton.setRideParameters(rideParams);

                requestButton.setCallback(callback);
                requestButton.loadRideInformation();


                Location user = new Location("");
                user.setLatitude(latitude);
                user.setLongitude(longitude);

                Location kanto = new Location("");
                kanto.setLatitude(elatz.get(0));
                kanto.setLongitude(elongz.get(0));
                kantolayo = user.distanceTo(kanto);
                kantoliko = user.bearingTo(kanto);

                Log.d("kantolayo", "" + kantolayo);

                Log.d("kantolayoliko", "" + kantoliko);


                if (markers.size() > 1) {

                    Location markar = new Location("");
                    markar.setLongitude(markers.get(1)
                            .getPosition().longitude);
                    markar.setLatitude(markers.get(1)
                            .getPosition().latitude);
                    markarlayo = user.distanceTo(markar);
                }

                Log.d("asd123,markar", "" + markers.get(1).getPosition().longitude);
                Log.d("asd123,markar", "" + markers.get(1).getPosition().latitude);


                Log.d("asd123,latskanto", "" + elatz.get(0));
                Log.d("asd123,longskanto", "" + elongz.get(0));
            }
            if (kantolayo < 8) {


                replot();


                //   adapterStaff.notifyDataSetChanged();
            }


            if (markarlayo < 25) {
                if (mList.size() > 1 && points.size() > 1 && markers.size() > 1) {

                    if (mList.size() != 0) {

                        if (mList.size() > 1) {
                            if (emailnguser == "") {
                                Toast.makeText(context, "Reaching your destination", Toast.LENGTH_SHORT).show();
                            } else {
                                sendMessage();
                            }

                        }


                    }


                }
            }


            if (markarlayo < 20) {


                if (mList.size() > 1 && points.size() > 1 && markers.size() > 1) {

                    if (mList.size() != 0) {

                        if (mList.size() > 1) {
                            //    desto--;
                            markers.remove(1);
                            mList.remove(1);
                            points.remove(1);
                            distances.remove(1);
                            reminders.remove(1);
                            timestoStay.remove(1);
                            // polylines.remove(desto);
                            //   listOfIndicesOfCurrentRoutes.remove(desto);
                            mins.remove(1);

                            mMap.clear();
                            points.set(0, latLng);
                            String myText1 = "You arrived";
                            tts.speak(myText1, TextToSpeech.QUEUE_FLUSH, null);
                            replot();


                            Log.d("asd123,pointsuser", "" + points.get(0).latitude);
                            Log.d("asd123,pointsuser", "" + points.get(0).longitude);

                        }


                    }


                }
            }
        }


        Log.d("onLocationChanged", String.format("latitude:%.9f longitude:%.9f", latitude, longitude));


        if (mGoogleApiClient == null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            Log.d("onLocationChanged", "Removing Location Updates");
        }


        Log.d("onLocationChanged", "Exit");

    }

    private void getspeed(Location location) {
        double newTime = System.currentTimeMillis();
        double newLat = location.getLatitude();
        double newLon = location.getLongitude();
        if (location.hasSpeed()) {
            float speed = location.getSpeed();

            Log.d("speedofusenospeed", "" + speed);

        } else {
            double distance = calculationBydistance(newLat, newLon, oldLat, oldLon);
            double timeDifferent = newTime - curTime;
            double speed = (distance / timeDifferent) * 100;
            Log.d("speedofuser", "" + speed);
            curTime = newTime;
            oldLat = newLat;
            oldLon = newLon;
            double y = (Math.floor(speed * 10000) / 10000) * 3.6;
            Log.d("speedofuser", "" + y);
            meterz.setText(String.format("%.2f", y) + "km/h");
        }
    }

    public double calculationBydistance(double lat1, double lon1, double lat2, double lon2) {
        double radius = 6371000;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return radius * c;
    }


    @Override
    public void onMapLongClick(LatLng latLng) {
        //Add marker on LongClick position
/*        Toast.makeText(getApplicationContext(), loadingToasts[mList.size() - 1], Toast.LENGTH_LONG).show();*/

     /*   HashMap<String, String> n = new HashMap<String, String>();
        n.put("a", "a");*/

        checklist = 1;

        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                //Small correction here, not too important
                .icon(icons[mList.size() + 1])
                .title("Destination " + mList.size() + 1)
                //end of correction
                .anchor(0.5f, 1);

        points.add(latLng);
        markers.add(mMap.addMarker(markerOptions));
        markerino.add(mMap.addMarker(markerOptions));

        //EXTRA CODES
        mList.add(markerOptions);

        Log.d("pointsize", "" + points.size());
        Log.d("markerssize", "" + markers.size());
        Log.d("mlistsize", "" + mList.size());

        distances.add(new String("0"));
        durations.add(new String("0"));
        reminders.add(new String(""));
        timestoStay.add(new String(""));
        mins.add(new String(""));


        String url = null;
        try {
            url = makeURL3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        pointview.setVisibility(View.VISIBLE);
        durationview.setVisibility(View.VISIBLE);
        distanceview.setVisibility(View.VISIBLE);


        connectAsyncTask3 downloadTask2 = new connectAsyncTask3(url, this, true);
        downloadTask2.execute();
        poppers.posit = alarmClocks.size() + 1;


    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        streetmap = marker.getPosition();
        double latitute = streetmap.latitude;
        double longotude = streetmap.longitude;

        String snippet = marker.getSnippet();
        Log.d("onMarkerClick", "snippet equals: " + snippet);
        if (snippet == null) {
            //marker is not a place, what info do you want to show? if nothing return else tell me
            return true;
        }


        String placeId = snippet.substring(8);
        Log.d("onMarkerClick", "placeId is: " + placeId);
        Intent toMarkerInfo = new Intent(traffic.this, MarkerInfoActivity.class);
        toMarkerInfo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        toMarkerInfo.putExtra("placeId", placeId);
        //  Toast.makeText(traffic.this, " " + placeId, Toast.LENGTH_SHORT).show();
        startActivity(toMarkerInfo);


        return true;


    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {


            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut() {

        tts.speak(ttsturns.get(0), TextToSpeech.QUEUE_FLUSH, null);
    }


    public class connectAsyncTask3 extends AsyncTask<Void, Void, String> {
        private ProgressDialog progressDialog;
        private traffic traffic;
        private boolean displayDestinationDetails;
        String url;
        boolean launchDestination;

        connectAsyncTask3(String urlPass, traffic traffic, boolean displayDestinationDetails) {
            this.url = urlPass;
            this.traffic = traffic;
            this.displayDestinationDetails = displayDestinationDetails;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            try {
                super.onPreExecute();
                progressDialog = new ProgressDialog(traffic.this);
                progressDialog.setMessage("Fetching route, Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... params) {
            JSONParser jParser = new JSONParser();
            String json = jParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.hide();
            checklist = 1;
            if (result != null) {
                Log.d("momo2", " : " + result);
                traffic.drawPath(result);
                speakOut();


            }

            if (displayDestinationDetails) {

                Intent i = new Intent(traffic.this, poppers.class);
                i.putExtra("currentMarker", traffic.markers.size());
                traffic.startActivity(i);


            }


        }
    }


    public class connectAsyncTask2 extends AsyncTask<Void, Void, String> {
        private ProgressDialog progressDialog;
        private traffic traffic;
        private boolean displayDestinationDetails;
        String url;
        boolean launchDestination;


        connectAsyncTask2(String urlPass, traffic traffic, boolean displayDestinationDetails) {
            this.url = urlPass;
            this.traffic = traffic;

            this.displayDestinationDetails = displayDestinationDetails;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            try {
                super.onPreExecute();
                progressDialog = new ProgressDialog(traffic.this);
                progressDialog.setMessage("Fetching route, Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... params) {
            JSONParser jParser = new JSONParser();
            String json = jParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.hide();
            checklist = 1;

            if (result != null) {
                Log.d("momo2", " : " + result);
                traffic.drawPath(result);
                speakOut();
            }


  /*          if (displayDestinationDetails) {

                if (TemplateOrChoices.packages == 1) {
                } else if (TemplateOrChoices.packages == 0) {

                } else {
                    Intent i = new Intent(traffic.this, poppers.class);
                    i.putExtra("currentMarker", traffic.markers.size());
                    traffic.startActivity(i);
                }

            }*/


        }
    }

    private class placesAsyncTask extends AsyncTask<Void, Void, String> {
        private ProgressDialog progressDialog;
        String url;

        placesAsyncTask(String urlPass) {
            url = urlPass;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            JSONParser jParser = new JSONParser();
            String json = jParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                Log.d("mzmz", " : " + result);
                showplaces(result);
            }
        }
    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    public static String getUrl(double latitude, double longitude, String nearbyPlace) {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + radiusplace.inputtedradius);
        googlePlacesUrl.append("&type=" + nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyDK1zxUEp38e6sQYzJq6qGNKxdOUqUZR1Y");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }

                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }


    public static class GetNearbyPlacesData extends AsyncTask<Object, String, String> {

        String googlePlacesData;
        GoogleMap mMap;
        String url;
        public static int reminders;

        @Override
        protected String doInBackground(Object... params) {
            try {
                Log.d("GetNearbyPlacesData", "doInBackground entered");
                mMap = (GoogleMap) params[0];
                url = (String) params[1];
                DownloadUrl downloadUrl = new DownloadUrl();
                googlePlacesData = downloadUrl.readUrl(url);
                Log.d("GooglePlacesReadTask", "doInBackground Exit");
            } catch (Exception e) {
                Log.d("GooglePlacesReadTask", e.toString());
            }
            return googlePlacesData;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("GooglePlacesReadTask", "onPostExecute Entered");
            List<HashMap<String, String>> nearbyPlacesList = null;
            DataParser dataParser = new DataParser();
            nearbyPlacesList = dataParser.parse(result);
            ShowNearbyPlaces(nearbyPlacesList, result);
            Log.d("GooglePlacesReadTask", "onPostExecute Exit");
        }

        private void ShowNearbyPlaces(List<HashMap<String, String>> nearbyPlacesList, String result) {

            try {

                ;
                JSONObject jsonObject = new JSONObject(result);
                LinkedList<MarkerOptions> placeMarkers = new LinkedList<MarkerOptions>();

                JSONArray placesArray = jsonObject.getJSONArray("results");
                for (int i = 0; i < placesArray.length(); i++) {
                    Log.d("onPostExecute", "Entered into showing locations");
                    JSONObject places = placesArray.getJSONObject(i);
                    JSONObject geometry = places.getJSONObject("geometry");
                    JSONObject location = geometry.getJSONObject("location");
                    //****************************
                    placeId = places.getString("place_id");
                    LatLng temp = new LatLng((Double) location.get("lat"), (Double) location.get("lng"));
                    Log.d("tyty", places.getString("name"));

                    if (!place.contains(temp)) {

                        place.add(temp);
                        placename.add(places.getString("name"));
                        MarkerOptions markerOptions =
                                new MarkerOptions()
                                        .position(temp
                                        ).title(places.getString("name"))
                                        .snippet("placeId:" + placeId);


                        if (reminders == 2) {

                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.air));

                        } else if (reminders == 3) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_station));
                        } else if (reminders == 4) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_rental));
                        } else if (reminders == 5) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.taxi_stand));
                        } else if (reminders == 6) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.train_station));
                        } else if (reminders == 7) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.transit_station));
                        } else if (reminders == 8) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.real_state_agency));
                        } else if (reminders == 9) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.insured));
                        } else if (reminders == 10) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.travel_agency));
                        } else if (reminders == 11) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_atm));
                        } else if (reminders == 12) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.police));
                        } else if (reminders == 13) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.fireszz));
                        } else if (reminders == 14) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital));
                        } else if (reminders == 15) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.pharmacy));
                        } else if (reminders == 16) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.parking));
                        } else if (reminders == 17) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.meal_delivery));
                        } else if (reminders == 18) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.hair_care));
                        } else if (reminders == 19) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.gyn));
                        } else if (reminders == 20) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_wash));
                        } else if (reminders == 21) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_repair));
                        } else if (reminders == 23) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.laundry));
                        } else if (reminders == 24) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station));
                        } else if (reminders == 25) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bicycle_store));
                        } else if (reminders == 26) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.book_store));
                        } else if (reminders == 27) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.hardware_store));
                        } else if (reminders == 28) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.furniture_store));
                        } else if (reminders == 29) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.jewelry_store));
                        } else if (reminders == 30) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.liquour_store));
                        } else if (reminders == 31) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.store));
                        } else if (reminders == 32) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.clothing_store));
                        } else if (reminders == 33) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.department_store));
                        } else if (reminders == 34) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.pet_store));
                        } else if (reminders == 35) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.electronics_store));
                        } else if (reminders == 36) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.parkor));
                        } else if (reminders == 37) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bar));
                        } else if (reminders == 38) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bowling_alley));
                        } else if (reminders == 39) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.cafe));
                        } else if (reminders == 40) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.campground));
                        } else if (reminders == 41) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.casino));
                        } else if (reminders == 42) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.night_club));
                        } else if (reminders == 43) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.art_gallery));
                        } else if (reminders == 44) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.shoppers));
                        } else if (reminders == 45) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.museum));
                        } else if (reminders == 46) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.park1));
                        } else if (reminders == 47) {
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.spa));
                        }

                        Marker placeMarker = mMap.addMarker(markerOptions);
                        placeMarkers.add(markerOptions);
                    }


                    //move map camera
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory
                            .zoomTo(15)
                    );

                    Log.d("REMINDERS", "" + reminders);
                    Log.d("REMINDERS", "" + reminders);
                    Log.d("REMINDERS", "" + reminders);


                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("tyty", e.getMessage());
            }
        }
    }

    private void sendMessage() {


        if (placename.isEmpty() && placevicinity.isEmpty()) {
            s = "TARA UPDATES of user: \n\n"
                    + "Time of arrival: " + date + "\n"
                    + "Current location:" + latLng + "\n"
                    + "Total Distance:" + distancez.getText().toString() + "\n"
                    + "Total Duration:" + durationz.getText().toString() + "\n"
                    + "Last Driving Instruction:" + ttsturns.get(0).toString() + "\n"

                    + "Use this site to find the exact place of the user: https://www.gps-coordinates.net/" + "\n";
        } else if (placename.size() >= 5 && placevicinity.size() >= 5) {
            s = "TARA UPDATES of user: \n\n"
                    + "Time of arrival: " + date + "\n"
                    + "Current location:" + latLng + "\n"
                    + "Total Distance:" + distancez.getText().toString() + "\n"
                    + "Total Duration:" + durationz.getText().toString() + "\n"
                    + "Last Driving Instruction:" + ttsturns.get(0).toString() + "\n\n"
                    + "5 Closest Landmark" + "\n"
                    + placename.get(0).toString() + "-----" + placevicinity.get(0).toString() + "\n"
                    + placename.get(1).toString() + "-----" + placevicinity.get(1).toString() + "\n"
                    + placename.get(2).toString() + "-----" + placevicinity.get(2).toString() + "\n"
                    + placename.get(3).toString() + "-----" + placevicinity.get(3).toString() + "\n"
                    + placename.get(4).toString() + "-----" + placevicinity.get(4).toString() + "\n"

                    + "Use this site to find the exact place of the user: https://www.gps-coordinates.net/" + "\n";

        } else if (placename.size() >= 2 && placevicinity.size() >= 2) {
            s = "TARA UPDATES of user: \n\n"
                    + "Time of arrival: " + date + "\n"
                    + "Current location:" + latLng + "\n"
                    + "Total Distance:" + distancez.getText().toString() + "\n"
                    + "Total Duration:" + durationz.getText().toString() + "\n"
                    + "Last Driving Instruction:" + ttsturns.get(0).toString() + "\n\n"
                    + "5 Closest Landmark" + "\n"
                    + placename.get(0).toString() + "-----" + placevicinity.get(0).toString() + "\n"
                    + placename.get(1).toString() + "-----" + placevicinity.get(1).toString() + "\n"
                    + placename.get(2).toString() + "-----" + placevicinity.get(2).toString() + "\n"

                    + "Use this site to find the exact place of the user: https://www.gps-coordinates.net/" + "\n";

        }


        String[] recipients = {emailnguser};
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail("taramobileappph@gmail.com", "lawrencekiko1");
        email.m.set_from("taramobileappph@gmail.com");
        email.m.setBody(s);
        email.m.set_to(recipients);
        email.m.set_subject("TARA UPDATES");
        email.execute();

        Log.d("Email", "" + emailnguser);
    }

    public void displayMessage(String message) {

    }


    class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        Mail m;
        traffic activity;

        public SendEmailAsyncTask() {
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                if (m.send()) {
                    activity.displayMessage("Email sent.");
                } else {
                    activity.displayMessage("Email failed to send.");
                }

                return true;
            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
                e.printStackTrace();
                activity.displayMessage("Authentication failed.");
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
                e.printStackTrace();
                activity.displayMessage("Email failed to send.");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                activity.displayMessage("Unexpected error occured.");
                return false;
            }
        }


    }
}
