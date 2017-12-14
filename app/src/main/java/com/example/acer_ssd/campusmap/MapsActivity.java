package com.example.acer_ssd.campusmap;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.Objects;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker_library;
    private Marker marker_postoffice;
    private Marker marker_rings;
    private Marker marker_theater;
    private Marker marker_hospital;
    private Marker marker_gouhao;
    private Marker marker_canteen_3;
    private Marker marker_taobao;
    private Marker marker_stadium;
    private Marker marker_atm;
    private Marker marker_mobile;
    private Marker marker_suguo;
    private Marker marker_canteen_2;
    private Marker marker_barbershop;
    private Marker marker_hotdog;
    private Marker marker_canteen_1;
    private Marker marker_building6;
    int badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.places) {
            Intent intent = new Intent(this, Options.class);
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try{
            String product = data.getStringExtra("countryName");
            if (product == null) {
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
            }
            // Objects.equals(product, new String("Australia"))
            if (product.equals("Third Canteen")) {
                //if (Objects.equals(product, new String("Australia"))){
                marker_canteen_3.showInfoWindow();
            }
            if (product.equals("Library")) {
                marker_library.showInfoWindow();
            }
            if (product.equals("Post Office")) {
                marker_postoffice.showInfoWindow();
            }
            if (product.equals("North Stadium")) {
                marker_rings.showInfoWindow();
            }
            if (product.equals("Theater")) {
                marker_theater.showInfoWindow();
            }
            if (product.equals("Hospital")) {
                marker_hospital.showInfoWindow();
            }
            if (product.equals("Supermarket")) {
                marker_gouhao.showInfoWindow();
            }
            if (product.equals("Taobao")) {
                marker_taobao.showInfoWindow();
            }
            if (product.equals("East Stadium")) {
                marker_stadium.showInfoWindow();
            }
            if (product.equals("ATM")) {
                marker_atm.showInfoWindow();
            }
            if (product.equals("China Mobile")) {
                marker_mobile.showInfoWindow();
            }
            if (product.equals("School Suguo")) {
                marker_suguo.showInfoWindow();
            }
            if (product.equals("Second Canteen")) {
                marker_canteen_2.showInfoWindow();
            }
            if (product.equals("Barbershop")) {
                marker_barbershop.showInfoWindow();
            }
            if (product.equals("HotDog Bar")) {
                marker_hotdog.showInfoWindow();
            }
            if (product.equals("First Canteen")) {
                marker_canteen_1.showInfoWindow();
            }
            if (product.equals("CS Building")) {
                marker_building6.showInfoWindow();
            }
        }catch (RuntimeException e) {

        }



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (mMap!= null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){

                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {

                    if (marker.equals(marker_hotdog)) {
                        badge = R.drawable.place15;
                    }
                    if (marker.equals(marker_canteen_3)) {
                        badge = R.drawable.place7;
                    }
                    if (marker.equals(marker_library)) {
                        badge = R.drawable.place1;
                    }
                    if (marker.equals(marker_postoffice)) {
                        badge = R.drawable.place2;
                    }
                    if (marker.equals(marker_rings)) {
                        badge = R.drawable.place3;
                    }
                    if (marker.equals(marker_theater)) {
                        badge = R.drawable.place4;
                    }
                    if (marker.equals(marker_hospital)) {
                        badge = R.drawable.place5;
                    }
                    if (marker.equals(marker_gouhao)) {
                        badge = R.drawable.place6;
                    }
                    if (marker.equals(marker_canteen_3)) {
                        badge = R.drawable.place7;
                    }
                    if (marker.equals(marker_taobao)) {
                        badge = R.drawable.place8;
                    }
                    if (marker.equals(marker_stadium)) {
                        badge = R.drawable.place9;
                    }
                    if (marker.equals(marker_atm)) {
                        badge = R.drawable.place10;
                    }
                    if (marker.equals(marker_mobile)) {
                        badge = R.drawable.place11;
                    }
                    if (marker.equals(marker_suguo)) {
                        badge = R.drawable.place12;
                    }
                    if (marker.equals(marker_canteen_2)) {
                        badge = R.drawable.place13;
                    }
                    if (marker.equals(marker_barbershop)) {
                        badge = R.drawable.place14;
                    }
                    if (marker.equals(marker_canteen_1)) {
                        badge = R.drawable.place16;
                    }
                    if (marker.equals(marker_building6)) {
                        badge = R.drawable.place17;
                    }

                    View v = getLayoutInflater().inflate(R.layout.info_window,null);

                    TextView title = (TextView) v.findViewById(R.id.textView2);
                    //TextView description = (TextView) v.findViewById(R.id.textView3);
                    TextView tvsnippet = (TextView) v.findViewById(R.id.textView4);
                    ImageView icon = (ImageView) v.findViewById(R.id.imageView2);

                    icon.setImageResource(badge);
                    title.setText(marker.getTitle());
                    //description.setText("This is description of my marker");
                    tvsnippet.setText(marker.getSnippet());
                    return v;
                }
            });
        }

        LatLng library = new LatLng(32.111739, 118.932053);
        LatLng postoffice = new LatLng(32.111122, 118.933350);
        LatLng rings = new LatLng(32.117975, 118.930795);
        LatLng theater = new LatLng(32.117157, 118.931275);
        LatLng hospital = new LatLng(32.116716, 118.931653);
        LatLng gouhao = new LatLng(32.117237, 118.933370);
        LatLng canteen_3 = new LatLng(32.117523, 118.933450);
        LatLng taobao= new LatLng(32.116221, 118.935470);
        LatLng stadium= new LatLng(32.114690, 118.934317);
        LatLng atm= new LatLng(32.110505, 118.932834);
        LatLng mobile= new LatLng(32.110371, 118.932820);
        LatLng suguo= new LatLng(32.110244, 118.932839);
        LatLng canteen2= new LatLng(32.111771, 118.933153);
        LatLng barbershop= new LatLng(32.109285, 118.932960);
        LatLng hot_dog_bar = new LatLng(32.108946, 118.933291);
        LatLng canteen1= new LatLng(32.108410, 118.933534);
        LatLng building6= new LatLng(32.115749, 118.929395);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(library, 15));

        marker_library = mMap.addMarker(new MarkerOptions()
                .position(library)
                .title("Marker in Library")
                .snippet("NUPT library")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.openbook)));
        marker_postoffice = mMap.addMarker(new MarkerOptions()
                .position(postoffice)
                .title("Post Office")
                .snippet("China post")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mailbox)));
        marker_rings = mMap.addMarker(new MarkerOptions()
                .position(rings)
                .title("Stadium")
                .snippet("North stadium")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.stadium)));
        marker_theater = mMap.addMarker(new MarkerOptions()
                .position(theater)
                .title("Theater")
                .snippet("NUPT theater")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.theater)));
        marker_hospital = mMap.addMarker(new MarkerOptions()
                .position(hospital)
                .title("Hospital")
                .snippet("NUPT hospital")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hearts)));
        marker_gouhao = mMap.addMarker(new MarkerOptions()
                .position(gouhao)
                .title("Supermarket")
                .snippet("NUPT Gouhao market")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.store)));
        marker_canteen_3 = mMap.addMarker(new MarkerOptions()
                .position(canteen_3)
                .title("Canteen")
                .snippet("NUPT canteen #3")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.canteen)));
        marker_taobao = mMap.addMarker(new MarkerOptions()
                .position(taobao)
                .title("Taobao")
                .snippet("Get your package")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.box)));
        marker_stadium = mMap.addMarker(new MarkerOptions()
                .position(stadium)
                .title("Stadium")
                .snippet("East stadium")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.stadium)));
        marker_atm = mMap.addMarker(new MarkerOptions()
                .position(atm)
                .title("ATM")
                .snippet("Citic bank ATM")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.money)));
        marker_mobile = mMap.addMarker(new MarkerOptions()
                .position(mobile)
                .title("China mobile")
                .snippet("NUPT China mobile")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.smartphone)));
        marker_suguo = mMap.addMarker(new MarkerOptions()
                .position(suguo)
                .title("Suguo")
                .snippet("NUPT mini suguo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.store)));
        marker_canteen_2 = mMap.addMarker(new MarkerOptions()
                .position(canteen2)
                .title("Canteen")
                .snippet("Canteen #2")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.canteen)));
        marker_barbershop = mMap.addMarker(new MarkerOptions()
                .position(barbershop)
                .title("Barbershop")
                .snippet("NUPT barbershop")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.barbershop)));
        marker_hotdog = mMap.addMarker(new MarkerOptions()
                .position(hot_dog_bar)
                .title("HotDog bar")
                .snippet("Tea and HotDog cafe")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hot_dog)));
        marker_canteen_1 = mMap.addMarker(new MarkerOptions()
                .position(canteen1)
                .title("Canteen")
                .snippet("Canteen #1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.canteen)));
        marker_building6 = mMap.addMarker(new MarkerOptions()
                .position(building6)
                .title("CST building")
                .snippet("Building #6")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.notebook)));


       if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.zoomIn());
        }


    }

}
