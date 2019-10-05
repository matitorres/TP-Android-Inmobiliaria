package com.example.domumsistemainmobiliario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class ListaContratosAdapter extends ArrayAdapter<ItemListaContratos> {

    private Context context;
    private List<ItemListaContratos> lista;
    private LayoutInflater li;
    private AlertDialog dialogInquilino;

    public ListaContratosAdapter(@NonNull Context context, int resource, @NonNull List<ItemListaContratos> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View itemView = convertView;

        if (itemView==null) {
            itemView=li.inflate(R.layout.item_lista_contratos,parent,false);
        }

        ItemListaContratos item = lista.get(position);

        TextView tvFechaInicio = itemView.findViewById(R.id.tvFechaInicio);
        tvFechaInicio.setText(item.getFechaInicio());
        TextView tvFechaFin = itemView.findViewById(R.id.tvFechaFin);
        tvFechaFin.setText(item.getFechaFin());

        Button btnInquilino = itemView.findViewById(R.id.btnInquilino);
        btnInquilino.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View v = li.inflate(R.layout.dialog_inquilino, null, false);

                Button btnOk = v.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogInquilino.dismiss();
                    }
                });
                builder.setView(v);
                dialogInquilino = builder.create();
                dialogInquilino.show();

            }
        });

        return itemView;
    }
}
