package com.example.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener{

    private GoogleMap mMap;

    Button buttonNormal;
    Button buttonSatellite;
    Button buttonHybrid;
    Button buttonNavigate;
    SupportMapFragment mapFragment;

    TextView mainmenu ;

    /*Bundle bundle = getIntent().getExtras();
    double lati_start = bundle.getDouble("lati_start");
    double longi_start = bundle.getDouble("longi_start");
    double lati_dest = bundle.getDouble("lati_dest");
    double longi_dest = bundle.getDouble("longi_dest");*/

    final LatLng sydney = new LatLng(-34, 151);
    final LatLng myHome = new LatLng(-34.1, 150);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        buttonNormal = (Button) findViewById(R.id.buttonNormal);
        buttonSatellite = (Button) findViewById(R.id.buttonSatellite);
        buttonHybrid = (Button) findViewById(R.id.buttonHybrid);
        buttonNavigate = (Button) findViewById(R.id.buttonNavigate);

        buttonNormal.setOnClickListener(this);
        buttonSatellite.setOnClickListener(this);
        buttonHybrid.setOnClickListener(this);
        buttonNavigate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonNavigate:

                openGoogleMap(myHome, sydney);
                break;
            case R.id.buttonSatellite:
                buttonSatellite.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map2));
                buttonHybrid.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map));
                buttonNormal.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map));
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.buttonHybrid:
                buttonSatellite.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map));
                buttonHybrid.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map2));
                buttonNormal.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map));
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            default:
                buttonSatellite.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map));
                buttonHybrid.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map));
                buttonNormal.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_map2));
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
        }

        mapFragment.getMapAsync(this);
    }

    private void openGoogleMap(LatLng src, LatLng dest) {
        String url = "http://maps.google.com/maps?saddr="+src.latitude+","+src.longitude+"&daddr="+dest.latitude+","+dest.longitude+"&mode=driving";
        Uri gmmIntentUri = Uri.parse(url);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").snippet("Hello Sydney"));


        mMap.addMarker(new MarkerOptions().position(myHome).title("My Home").snippet("Hello my home"));

        LatLng center = new LatLng(-34.05, 150.5);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 8));

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {


            @Override
            // Return null here, so that getInfoContents() is called next.
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Inflate the layouts for the info window, title and snippet.
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_contents, null);


                TextView title = ((TextView) infoWindow.findViewById(R.id.textViewName));
                title.setText(marker.getTitle());


                TextView snippet = ((TextView) infoWindow.findViewById(R.id.textViewSnippet));
                snippet.setText(marker.getSnippet());

                ImageView imageView = (ImageView) infoWindow.findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.ic_city);
                if ("My Home".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.ic_home);
                }

                return infoWindow;
            }
        });

        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e("test", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("test", "Can't find style. Error: ", e);
        }

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(sydney)  // Sydney
                .add(myHome));// My Home


    }

}
