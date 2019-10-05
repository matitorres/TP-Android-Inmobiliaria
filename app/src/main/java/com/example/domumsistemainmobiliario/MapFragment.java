package com.example.domumsistemainmobiliario;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener  {

    static final LatLng PROPIEDAD_UNO = new LatLng(-32.410307, -65.675051);
    static final LatLng PROPIEDAD_DOS = new LatLng(-32.541867, -65.645239);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.mapstyle));

            if (!success) {
                Log.e("MapFragment", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapFragment", "Can't find style. Error: ", e);
        }

        googleMap.getUiSettings().setMapToolbarEnabled(false);

        googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);

        float zoom = 10;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PROPIEDAD_UNO, zoom));

        googleMap.addMarker(new MarkerOptions().position(PROPIEDAD_UNO));
        googleMap.addMarker(new MarkerOptions().position(PROPIEDAD_DOS));

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        InmuebleFragment inmuebleFragment = new InmuebleFragment();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, inmuebleFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        return true;
    }
}
