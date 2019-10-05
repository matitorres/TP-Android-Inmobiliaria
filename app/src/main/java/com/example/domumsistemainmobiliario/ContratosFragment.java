package com.example.domumsistemainmobiliario;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContratosFragment extends Fragment {

    private List<ItemListaContratos> listaContratos= new ArrayList<>();
    private AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contratos, container, false);

        llenarLista();
        generarListView(view);

        return view;
    }

    public ListView generarListView(View view) {
        ArrayAdapter<ItemListaContratos> adapter = new ListaContratosAdapter
                (getActivity(), R.layout.item_lista_contratos,listaContratos,
                        getLayoutInflater());
        ListView lv = view.findViewById(R.id.listaContratos);
        lv.setAdapter(adapter);
        return lv;
    }

    public void llenarLista() {
        listaContratos.add(new ItemListaContratos("10/06/2018","10/06/2020"));
        listaContratos.add(new ItemListaContratos("10/06/2016","10/06/2018"));
        listaContratos.add(new ItemListaContratos("10/06/2014","10/06/2016"));
    }

}
