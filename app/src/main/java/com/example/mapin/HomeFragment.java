package com.example.mapin;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

/**
 * 10119097
 * Ikhsan Nurul Rizki
 * IF-3 */
public class HomeFragment extends Fragment {
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_home, container, false);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        getCurrentLocation();
        // Inflate the layout for this fragment
        return fragment;
    }
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(mapFragment.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mapFragment.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng lokasiUtama = new LatLng(-6.918919627227166, 107.55173684343683);
                            LatLng tmptMakan1 = new LatLng(-6.918822462759702, 107.55143631570921);
                            LatLng tmptMakan2 = new LatLng(-6.918515501858281, 107.55201901528282);
                            LatLng tmptMakan3 = new LatLng(-6.917874461601158, 107.55168306860061);
                            LatLng tmptMakan4 = new LatLng(-6.917411154702314, 107.55196067722723);
                            LatLng tmptMakan5 = new LatLng(-6.918006328439158, 107.55305112586534);
                            googleMap.setMapType(googleMap.MAP_TYPE_HYBRID);
                            MarkerOptions options = new MarkerOptions().position(lokasiUtama).title("Lokasi Saat Ini");
                            googleMap.addMarker(new MarkerOptions().position(tmptMakan1).title("Baso Jadoel"));
                            googleMap.addMarker(new MarkerOptions().position(tmptMakan2).title("Warung Nasi Gubrag Sila"));
                            googleMap.addMarker(new MarkerOptions().position(tmptMakan3).title("Pempek Khas Palembang Dd Arka"));
                            googleMap.addMarker(new MarkerOptions().position(tmptMakan4).title("Rumah Makan June"));
                            googleMap.addMarker(new MarkerOptions().position(tmptMakan5).title("Restorja Noodle Shop"));
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasiUtama,17));
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }
}