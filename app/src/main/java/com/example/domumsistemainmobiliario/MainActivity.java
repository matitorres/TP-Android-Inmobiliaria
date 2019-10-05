package com.example.domumsistemainmobiliario;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialogPerfil;
    private AlertDialog dialogInquilino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura la AppBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" DOMUM");
        toolbar.setLogo(R.mipmap.logo_domum_round);
        setSupportActionBar(toolbar);

        // Configurar alert de notificaciones
        ListView listView = new ListView(this);
        List<String> notificaciones = new ArrayList<>();
        notificaciones.add("10/09/2019: Has recibido un nuevo pago" +
                "por tu propiedad ubicada en 9 de julio s/n, San Martín, San Luis");
        notificaciones.add("12/08/2019: Has recibido un nuevo pago" +
                "por tu propiedad ubicada en Ruta Provincial 2 s/n, Villa de Praga, San Luis");
        notificaciones.add("07/07/2019: Has recibido un nuevo pago" +
                "por tu propiedad ubicada en 9 de julio s/n, San Martín, San Luis");
        notificaciones.add("07/06/2019: Has recibido un nuevo pago" +
                "por tu propiedad ubicada en 9 de julio s/n, San Martín, San Luis");
        notificaciones.add("02/06/2019: Has recibido un nuevo pago" +
                "por tu propiedad ubicada en Ruta Provincial 2 s/n, Villa de Praga, San Luis");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_notificaciones,notificaciones);
        listView.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setView(listView);
        final AlertDialog dialogNotificaciones = builder.create();

        // Configura la función del botón flotante
        FloatingActionButton fab = findViewById(R.id.fab_notificaciones);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNotificaciones.show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = getLayoutInflater().inflate(R.layout.dialog_perfil, null);

                Button btnGuardar = view.findViewById(R.id.btnGuardar);
                btnGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Actualización exitosa", Toast.LENGTH_SHORT).show();
                        dialogPerfil.dismiss();
                    }
                });

                Button btnCancelar = view.findViewById(R.id.btnCancelar);
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogPerfil.dismiss();
                    }
                });

                builder.setView(view);
                dialogPerfil = builder.create();
                dialogPerfil.show();
                return true;

            case R.id.action_salir:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return false;

        }
    }

    public void mostrarInquilino() {

    }
}
