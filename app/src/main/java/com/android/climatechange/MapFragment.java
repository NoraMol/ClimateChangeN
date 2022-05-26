package com.android.climatechange;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class MapFragment extends Fragment implements OnMapReadyCallback {
    SupportMapFragment supportMapFragment;
    GoogleMap map;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private Location userLastKnownLocation;
    private Location location;


    private static final int REQUEST_CODE = 101;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
         fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.getActivity());


        FloatingActionButton fab_dustbin = (FloatingActionButton) view.findViewById(R.id.fab_dustbin);

        fab_dustbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDustbins();
            }
        });

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(this);




                return view;
            }






    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMyLocationButtonEnabled(true);



        //asking for permission
        Dexter.withContext(this.getContext())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse)
                    {
                        LocationRequest locationRequest = LocationRequest.create();
                        locationRequest.setInterval(5000);
                        locationRequest.setFastestInterval(1000);
                        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);



                        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
                        SettingsClient settingsClient = LocationServices.getSettingsClient(MapFragment.this.getContext());
                        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());

                        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
                            @Override
                            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                                showlocation();

                            }
                        });





                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse)
                    {
                        Toast.makeText(getContext(), "permission denied", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();

                    }
                }).check();

    }




    @SuppressLint("MissingPermission")
    private void showlocation() {
        map.setMyLocationEnabled(true);

        //getting the lastknown location
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>()
        {
            @Override
            public void onComplete(@NonNull Task<Location> task)
            {
                if (task.isSuccessful())
                {
                    userLastKnownLocation= task.getResult();

                    if (userLastKnownLocation !=null)
                    {
                        LatLng currentuserLocation= new LatLng(userLastKnownLocation.getLatitude(),userLastKnownLocation.getLongitude());
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentuserLocation, 20));


                    }
                    else {

                    }

                }


            }
        });




    }

    public  void showDustbins(){

        //Dustbin at KCB roundabout
        MarkerOptions dustbin1 = new MarkerOptions();
        dustbin1.position(new LatLng(-0.10502304149202323, 34.75368463959616  ));
        dustbin1.title("Dustbin");
        map.addMarker(dustbin1);
        map.animateCamera(CameraUpdateFactory.newLatLng(dustbin1.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dustbin1.getPosition(), 20));



        //around imperial hotel



        MarkerOptions dustbin2 = new MarkerOptions();
        dustbin2.position(new LatLng( -0.10384165111065195, 34.75509940441136  ));
        dustbin2.title("Dustbin");
        map.addMarker(dustbin2);
        map.animateCamera(CameraUpdateFactory.newLatLng(dustbin2.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dustbin2.getPosition(), 20));


        //around sportsground

        MarkerOptions dustbin3 = new MarkerOptions();
        dustbin3.position(new LatLng( -0.10389440469509756, 34.75479837842093  ));
        dustbin3.title("Dustbin");
        map.addMarker(dustbin3);
        map.animateCamera(CameraUpdateFactory.newLatLng(dustbin3.getPosition()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dustbin3.getPosition(), 20));



        //around Nairobi University


        MarkerOptions dustbin4 = new MarkerOptions();
        dustbin4.position(new LatLng( -0.10436570842727337, 34.753186295602084  ));
        dustbin4.title("Dustbin");
        map.addMarker(dustbin4);
        map.animateCamera(CameraUpdateFactory.newLatLng(dustbin4.getPosition()));

        // around united mall

        MarkerOptions dustbin5 = new MarkerOptions();
        dustbin5.position(new LatLng( -0.09859703834618533, 34.76214408528165 ));
        dustbin5.title("Dustbin");
        map.addMarker(dustbin5);
        map.animateCamera(CameraUpdateFactory.newLatLng(dustbin5.getPosition()));


        //sports ground


        MarkerOptions dustbin6 = new MarkerOptions();
        dustbin6.position(new LatLng( -0.10281522752202744, 34.7542056626622 ));
        dustbin6.title("Dustbin");
        map.addMarker(dustbin6);
        map.animateCamera(CameraUpdateFactory.newLatLng(dustbin6.getPosition()));

    }
//for converting vector assets into Bipmap for us in dustbin markers

    private BitmapDescriptor getBitmapDescriptor(@DrawableRes int resId) {
        Drawable vectorDrawable = ResourcesCompat.getDrawable(getResources(),resId,null);
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    //Receiving the results of the request to turn on GPS


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==101)
        {
            if (resultCode == RESULT_OK)
            {
                //user accepted allocation

                showlocation();
            }
        }
    }
}







