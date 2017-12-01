package com.obispo.fletare;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipiaActivity extends AppCompatActivity implements View.OnClickListener {
    MiAyudanteSQLite Carlo;

    TextView TXV11, TXV12, TXV13;
    ImageButton IMBTN10;
    int punteos=0;  // Bandera de paso por los dialogs de ORIGEN
    long CiudadOrigen=0;
    Dialog customDialog = null;

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
    public void mostrar(View view)
    {
        // con este tema personalizado evitamos los bordes por defecto
        customDialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog);

        TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
        titulo.setText("Título del Dialog");

        TextView contenido = (TextView) customDialog.findViewById(R.id.contenido);
        contenido.setText("Mensaje con el contenido del dialog ppsdagfodoasfg asdfghadfgadfg asdfgedgafrfger fre fdfdf sdsd  erertg  sdfgergerg, afsdghaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaf,dafhhhhhhhhhhhhhhhhhhhhhh,dfahhhhhhhhhhhhh.dfhaaaaaaaaaaaaaaaa,duyht  dasgh  h  dh s dgh  dastgh asdh et gh  dfh  dty he th ad fh    dhasdsdthasthethaetgh.dh g h asetjh eth aet h aet haeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeaeae. afsdgadf bhadgh asdhasd hasdh  sdghsfdgjshrjrhsdfh sdfgjnsdfgjsdfjhsdgh sdfghsdfhsdrtghsrth    s            sjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjh  sdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfh sdfghsrth");

        ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                customDialog.dismiss();
                Toast.makeText(PrincipiaActivity.this, "ACCEPT", Toast.LENGTH_SHORT).show();

            }
        });

        ((Button) customDialog.findViewById(R.id.cancelar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                customDialog.dismiss();
                Toast.makeText(PrincipiaActivity.this, "CANCCELL", Toast.LENGTH_SHORT).show();

            }
        });

        customDialog.show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.IMBTN10: // ImageButton ORIGEN

                 final Dialog dialog = new Dialog(this);
                    punteos =0;
                    CiudadOrigen = 0;
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
                                dialog.dismiss();
                            }
                            if (punteos ==0) {
                                String paulov = String.valueOf(id);
                                Carlo.AbrirBase();
                                SimpleCursorAdapter pepe = new SimpleCursorAdapter(view.getContext(), R.layout.venturi_doble, Carlo.PueblaCiudadesDeDepartamento(paulov),new String[]{"_id", "Ciudad"}, new int[]{0, R.id.venturi22});
                                LV10.setAdapter(pepe);
                                TXV99.setText("Elija una Ciudad");
                                punteos ++;
                                Carlo.CerrarBase();

                                //5555
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