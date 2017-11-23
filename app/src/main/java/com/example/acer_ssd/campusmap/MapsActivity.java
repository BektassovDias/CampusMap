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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker sydney2;
    private Marker brisbane2;
    int badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
    //@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String product = data.getStringExtra("countryName");

        if (product == null) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "null", Toast.LENGTH_SHORT);
            toast.show();
        }
       // Objects.equals(product, new String("Australia"))
        if (product.equals("Australia")) {
        //if (Objects.equals(product, new String("Australia"))){
            sydney2.showInfoWindow();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "no", Toast.LENGTH_LONG);
            toast.show();
        }
        if (product.equals("Brazil")) {
            brisbane2.showInfoWindow();
        }

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

                    // Use the equals() method on a Marker to check for equals.  Do not use ==.
                    if (marker.equals(brisbane2)) {
                        badge = R.drawable.flag_brazil;
                    } else if (marker.equals(sydney2)) {
                        badge = R.drawable.flag_australia;
                    }

                    View v = getLayoutInflater().inflate(R.layout.info_window,null);

                    TextView title = (TextView) v.findViewById(R.id.textView2);
                    TextView description = (TextView) v.findViewById(R.id.textView3);
                    TextView tvsnippet = (TextView) v.findViewById(R.id.textView4);
                    ImageView icon = (ImageView) v.findViewById(R.id.imageView2);

                    icon.setImageResource(badge);
                    title.setText(marker.getTitle());
                    description.setText("This is description of my marker");
                    tvsnippet.setText(marker.getSnippet());
                    return v;
                }
            });
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(32.112844, 118.933414);
        LatLng brisbane = new LatLng(32.116470, 118.925518);
        sydney2 = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Nanjing").snippet("This is snippet").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        brisbane2 = mMap.addMarker(new MarkerOptions().position(brisbane).title("Marker in Brisbane").snippet("This is snippet").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
        //sydney2.showInfoWindow();
/*        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.zoomIn());
        }*/


    }

}
