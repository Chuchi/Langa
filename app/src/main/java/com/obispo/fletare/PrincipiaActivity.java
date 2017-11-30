package com.obispo.fletare;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class PrincipiaActivity extends AppCompatActivity implements View.OnClickListener {
    MiAyudanteSQLite Carlo;

    TextView TXV11, TXV12, TXV13;
    ImageButton IMBTN10;
    int punteos=0;  // Bandera de paso por los dialogs de ORIGEN
    long CiudadOrigen=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principia);

        TXV11 = (TextView) findViewById(R.id.TXV11);
        TXV12 = (TextView) findViewById(R.id.TXV12);
        TXV13 = (TextView) findViewById(R.id.TXV13);
         IMBTN10 = (ImageButton) findViewById(R.id.IMBTN10);



        IMBTN10.setOnClickListener(this);
        Carlo = new MiAyudanteSQLite(this);
        Carlo.AbrirBase();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.IMBTN10: // ImageButton ORIGEN

                    final Dialog dialog = new Dialog(this);
                    punteos =0;
                    CiudadOrigen = 0;
                    dialog.setContentView(R.layout.forma_dialogo);
                    final ListView LV10 = (ListView) dialog.findViewById(R.id.LV10);
                    final TextView TXV99 = (TextView) dialog.findViewById(R.id.TXV99);
                    Carlo.AbrirBase();
                    SimpleCursorAdapter paco = new  SimpleCursorAdapter(this, R.layout.venturi_doble, Carlo.PueblaDepartamentos(), new String[]{"_id", "Departamento"}, new int[]{0,R.id.venturi22});


                    //Carlo.CerrarBase();
                 LV10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                            // Direcciona en el primer punteo

                            if (punteos >0) {
                                String casino = String.valueOf(id);
                                CiudadOrigen = id;
                                //punteos=0;
                                TXV13.setText(casino);
                                TXV13.setVisibility(View.VISIBLE);
                               // Carlo.CerrarBase();
                                dialog.cancel();
                            }
                            if (punteos ==0) {
                                String paulov = String.valueOf(id);
                                Carlo.AbrirBase();
                                SimpleCursorAdapter pepe = new SimpleCursorAdapter(view.getContext(), R.layout.venturi_doble, Carlo.PueblaCiudadesDeDepartamento(paulov),new String[]{"_id", "Ciudad"}, new int[]{0, R.id.venturi22});
                                LV10.setAdapter(pepe);
                                TXV99.setText("Elija una Ciudad");
                                punteos ++;
                                Carlo.CerrarBase();
                            }
                        }
                    });

                    LV10.setAdapter(paco);
                   // dialog.setTitle("Elija el Departamento");
                    dialog.show();
                    Carlo.CerrarBase();
                    break;
    }


}
    }