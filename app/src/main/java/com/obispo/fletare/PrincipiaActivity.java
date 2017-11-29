package com.obispo.fletare;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PrincipiaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    MiAyudanteSQLite Carlo;

    Spinner SPN11, SPN12;
    TextView TXV11, TXV12, TXV13;
    Cursor Juan;
    int paso =0;
    long pedro=89;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principia);

        TXV11=(TextView)findViewById(R.id.TXV11);
        TXV12=(TextView)findViewById(R.id.TXV12);
        TXV13=(TextView)findViewById(R.id.TXV13);
        SPN11=(Spinner)findViewById(R.id.SPN11) ;
        SPN12=(Spinner)findViewById(R.id.SPN12) ;

        SPN11.setOnItemSelectedListener(this);
        Carlo = new MiAyudanteSQLite(this);
        Carlo.AbrirBase();
        //Juan=Carlo.PueblaDepartamentos();
        Cursor calido = Carlo.PueblaDepartamentos();



        SimpleCursorAdapter acoplame = new SimpleCursorAdapter(this, R.layout.venturi,  calido, new String[] {"_id","Departamento"}, new int[] {R.id.venturi1,R.id.venturi2} );

        //Carlo.AbrirBase();
        //Carlo.metida();
       //Carlo.metida();


     // pedro = Carlo.CuantosHay();
    //     acoplame.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPN11.setAdapter(acoplame);
        SPN11.setSelection(9);
       // String carrusel= String.valueOf(pedro);
        Carlo.CerrarBase();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {

        switch (adapterView.getId()){
            case R.id.SPN11:
                if (paso ==0 &&  i!=9){
                    Carlo.AbrirBase();
                    String gustavo = String.valueOf(id);
                    Cursor frio = Carlo.PueblaCiudadesDeDepartamento(gustavo);
                    SimpleCursorAdapter acoplamos = new SimpleCursorAdapter(this, R.layout.venturi, frio, new String[]{"_id", "Ciudad"}, new int[]{R.id.venturi1, R.id.venturi2});
                    SPN11.setAdapter(acoplamos);
                    SPN11.setSelection(0);
                    Carlo.CerrarBase();
                    paso++;
                }
                if (paso >0){
                    Carlo.AbrirBase();
                    String gustavin = String.valueOf(id);
                    Cursor carrete = Carlo.BuscaCiudad(gustavin);
                    carrete.moveToFirst();

                    TXV13.setText(carrete.getString(2));
                    TXV13.setVisibility(View.VISIBLE);
                    Carlo.CerrarBase();

                }
            break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }
}
