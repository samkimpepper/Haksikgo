package com.example.hcgologin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mgoogleMap;

    TextView tv_currLocation;
    Marker preMarker;
    String add;
    Button btnasdads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        tv_currLocation = findViewById(R.id.currLocation_textview);
        btnasdads = findViewById(R.id.btn_asdasd);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mgoogleMap = googleMap;
        Context context = this;

        //final LatLng latLng = new LatLng(37.403315, 126.929927);
        LatLng latLng = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("대림대학교");
        markerOptions.draggable(true);
        preMarker = mgoogleMap.addMarker(markerOptions);

        UiSettings uiSettings = mgoogleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);


        mgoogleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mgoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            }
        }); // 로딩 완료 후에 카메라 위치를 내가 설정한 곳으로 조정

        mgoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                String address = GetAddress(latLng);

                preMarker.remove();
                markerOptions.position(latLng);
                markerOptions.title(address);
                preMarker = mgoogleMap.addMarker(markerOptions);
                tv_currLocation.setText(address);
                add = address;

                mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            }
        });

        btnasdads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("address", add);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


    public String GetAddress(LatLng latlng) {
        final Geocoder geocoder = new Geocoder(this);
        List<Address> list = null;
        try {
            list = geocoder.getFromLocation(latlng.latitude, latlng.longitude, 10);

        } catch(IOException e) {
            e.printStackTrace();
        }

        if(list != null && list.size() != 0) {
            return list.get(0).getAddressLine(0);
        }
        return "실패";
    }

}