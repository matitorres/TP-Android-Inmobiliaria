package com.example.domumsistemainmobiliario;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura la AppBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" Propiedades");
        toolbar.setLogo(R.mipmap.logo_domum_round);
        ((AppCompatActivity)getApplicationContext()).setSupportActionBar(toolbar);

        // Configura la función del botón flotante
        FloatingActionButton fab = findViewById(R.id.fab_notificaciones);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Verifica que exista el contenedor
        if(findViewById(R.id.container) != null)
        {
            // if we are being restored from a previous state, then we dont need to do anything and should
            // return or else we could end up with overlapping fragments.
            if(savedInstanceState != null)
                return;

            // Mostrar propiedades
            MapFragment mapFragment = new MapFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, mapFragment).commit();
            ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map))
                    .getMapAsync(new MapaPropiedades());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_perfil:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_salir:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return false;

        }
    }

    private class MapaPropiedades implements OnMapReadyCallback {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;
        }
    }

}
