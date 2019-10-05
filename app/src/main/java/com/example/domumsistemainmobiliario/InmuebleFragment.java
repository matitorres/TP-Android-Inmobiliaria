package com.example.domumsistemainmobiliario;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InmuebleFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inmueble, container, false);
        // Accion btnContratos
        Button btnContratos = view.findViewById(R.id.btnContratos);
        btnContratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarContratos(view);
            }
        });

        return view;
    }

    public void mostrarContratos(View view) {
        ContratosFragment contratosFragment = new ContratosFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, contratosFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
