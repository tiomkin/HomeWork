package by.tut.tiomkin.class20;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button mHybrid, mTerrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mHybrid = (Button) findViewById(R.id.btn_hybrid);
        mTerrain = (Button) findViewById(R.id.btn_terrain);
        mapFragment.getMapAsync(this);
        mHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        mTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng Minsk = new LatLng(53.90433816, 27.56744385);
        mMap.addMarker(new MarkerOptions().position(Minsk).title("Минск"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Minsk));

        LatLng Magiley = new LatLng(53.89786522, 30.33874512);
        mMap.addMarker(new MarkerOptions().position(Magiley).title("Могилев"));

        LatLng Vitebsk = new LatLng(55.17886766, 30.20690918);
        mMap.addMarker(new MarkerOptions().position(Vitebsk).title("Витебск"));

        LatLng Grodno = new LatLng(53.67718827, 23.82385254);
        mMap.addMarker(new MarkerOptions().position(Grodno).title("Гродно"));

        LatLng Brest = new LatLng(52.09975693, 23.72497559);
        mMap.addMarker(new MarkerOptions().position(Brest).title("Брест"));

        LatLng Gomel = new LatLng(52.44261787, 30.99243164);
        mMap.addMarker(new MarkerOptions().position(Gomel).title("Гомель"));


        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(52.09975693, 23.72497559))
                .add(new LatLng(53.90433816, 27.56744385))

        );

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(52.44261787, 30.99243164))
                .add(new LatLng(53.90433816, 27.56744385))

        );


        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(53.89786522, 30.33874512))
                .add(new LatLng(53.90433816, 27.56744385))

        );


        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(55.17886766, 30.20690918))
                .add(new LatLng(53.90433816, 27.56744385))

        );


        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(53.67718827, 23.82385254))
                .add(new LatLng(53.90433816, 27.56744385))

        );


    }
}