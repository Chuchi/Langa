package com.obispo.fletare;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipiaActivity extends AppCompatActivity implements View.OnClickListener {
    MiAyudanteSQLite Carlo;

    TextView TXV11, TXV12, TXV13,TXV14 ;
    Handler Chispea = new Handler();
    int punteos=0;  // Bandera de paso por los dialogs de ORIGEN
    long CiudadOrigen=0;
    Dialog customDialog = null;
    Typeface TFAmaranthRegular ;
    Typeface TFAmaranthBold;
    boolean inter =false;

Runnable anas = new Runnable() {
    public void run() {
        Flasheo();
        if (inter) {
            TXV14.setTextColor(getResources().getColor(R.color.FletareAmarillo25));
        } else {
            TXV14.setTextColor(getResources().getColor(R.color.FletareNaranjaCarmesi100));
        }
        Chispea.postDelayed(anas,500);
}};
    Runnable caifas = new Runnable() {
        public void run() {
            Flasheo();
            if (inter) {
                TXV12.setTextColor(getResources().getColor(R.color.FletareAmarillo25));
            } else {
                TXV12.setTextColor(getResources().getColor(R.color.FletareNaranjaCarmesi100));
            }
            Chispea.postDelayed(caifas,500);
        }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principia);

        TXV11 = (TextView) findViewById(R.id.TXV11);
        TXV12 = (TextView) findViewById(R.id.TXV12);
        TXV13 = (TextView) findViewById(R.id.TXV13);
        TXV14 = (TextView) findViewById(R.id.TXV14);
            String Amaranth_Regular = "Vermut/Amaranth-Regular.ttf";
        String Amaranth_Bold = "Vermut/Amaranth-Bold.ttf";




        TFAmaranthRegular = Typeface.createFromAsset(getAssets(),Amaranth_Regular);
        TFAmaranthBold= Typeface.createFromAsset(getAssets(),Amaranth_Bold);

        TXV11.setTypeface(TFAmaranthRegular);
        TXV12.setTypeface(TFAmaranthRegular);



        TXV12.setOnClickListener(this);
        Carlo = new MiAyudanteSQLite(this);
        Carlo.AbrirBase();
        Chispea.postDelayed(caifas,500);
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

            case R.id.TXV12: // ImageButton ORIGEN
                Chispea.removeCallbacks(caifas);
                 final Dialog dialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
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
                                Carlo.AbrirBase();

                                TXV12.setVisibility(View.VISIBLE);
                                TXV12.setText(Carlo.BuscaCiudad(casino));
                                TXV12.setTypeface(TFAmaranthBold);
                                TXV12.setTextColor(getResources().getColor(R.color.dialog_divider));
                                Carlo.CerrarBase();
                                TXV14.setVisibility(View.VISIBLE);
                                Chispea.postDelayed(anas, 500);
                                dialog.dismiss();
                            }
                            if (punteos ==0) {
                                String paulov = String.valueOf(id);
                                Carlo.AbrirBase();
                                SimpleCursorAdapter pepe = new SimpleCursorAdapter(view.getContext(), R.layout.venturi_doble, Carlo.PueblaCiudadesDeDepartamento(paulov),new String[]{"_id", "Ciudad"}, new int[]{0, R.id.venturi22});
                                LV10.setAdapter(pepe);
                                TXV99.setText("Elija Ciudad");
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
    //Disparo del Temporizador para el blinking del marker

    public void  Flasheo(){

        if(inter) {
            inter = false;
        }else {inter = true;  }
    }

}