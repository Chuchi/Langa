package com.obispo.fletare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PrincipiaActivity extends AppCompatActivity {
    MiAyudanteSQLite Carlo;
    TextView provincia ;
    int carlitos =0;
    long pedro=89;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principia);
        Carlo = new MiAyudanteSQLite(this);
        Carlo.AbrirBase();
        provincia=(TextView)findViewById(R.id.tv_provincia);
       // pedro = Carlo.CuantosHay();

        Carlo.CerrarBase();
        String carrusel= String.valueOf(pedro);

provincia.setText(carrusel);
    }
}
