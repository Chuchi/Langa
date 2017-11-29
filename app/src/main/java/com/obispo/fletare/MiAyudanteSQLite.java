package com.obispo.fletare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by oficina on 28/11/2017.
 */

public class MiAyudanteSQLite extends SQLiteOpenHelper{

    Context ctx;

    public MiAyudanteSQLite(Context context) {
        super(context,"Propia.db",null, 16);

        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase BD) {

        BD.execSQL("CREATE TABLE  Departamentos (IdDepartamento INTEGER Primary Key autoincrement, Departamento Text not null ,Vario1 Text)");
     BD.execSQL("CREATE TABLE  Ciudades (IdCiudad INTEGER Primary Key autoincrement,IdDepart INTEGER NOT NULL, Ciudad Text not null, Latitud Double , Longuitud Double , Vario1 Text, Vario2 Text)");

/*
        InputStream is = null;
        try {
            is = ctx.getAssets().open("Departamentos.sql");
            if (is != null) {
                BD.beginTransaction();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                while (!TextUtils.isEmpty(line)) {
                    BD.execSQL(line);
                    line = reader.readLine();
                }
                BD.setTransactionSuccessful();

            }
        } catch (Exception ex) {
            // Muestra log
        } finally {
            BD.endTransaction();
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // Muestra log
                }
            }

        }

*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase BD, int i, int i1) {

        BD.execSQL("DROP TABLE  if exists Departamentos");
        BD.execSQL("DROP TABLE  if exists Ciudades");
        onCreate(BD);

    }


    SQLiteDatabase basecita;
    MiAyudanteSQLite  ayucodeBase;

    // Metodos para manejar la base de Datos

        public void AbrirBase  (){

            ayucodeBase = new MiAyudanteSQLite(ctx);
            basecita=ayucodeBase.getWritableDatabase();

        }

        public void  CerrarBase (){

            basecita.close();
        }

    // Metodos para manipular los datos de la base de datos

        public long  InsertarDepartamentos ( String departamento) throws Exception{

            ContentValues valores = new ContentValues();
            valores.put("Departamento",departamento);

            return   basecita.insert("Departamentos",null,valores);
        }

        public int UltimoRegistro() {

          ayucodeBase.AbrirBase();
            Cursor cursor = basecita.rawQuery("select MAX(IdDepartamento) from Departamentos", null);
           cursor.moveToFirst();
           int numeroII = cursor.getInt(0);
           basecita.close();


            return numeroII;
        }

        public void metida(){

            ayucodeBase.AbrirBase();
            basecita.execSQL("INSERT INTO Departamentos (Departamento) Values ('Santa Cruz');INSERT INTO Departamentos (Departamento) Values ('La Paz');INSERT INTO Departamentos (Departamento) Values ('Cochabamba');INSERT INTO Departamentos (Departamento) Values ('Potosi'); INSERT INTO Departamentos (Departamento) Values ('Oruro');INSERT INTO Departamentos (Departamento) Values ('Chuquisaca');INSERT INTO Departamentos (Departamento) Values ('Beni');INSERT INTO Departamentos (Departamento) Values ('Pando'); INSERT INTO Departamentos (Departamento) Values ('Tarija');");
            basecita.close();

        }

    public long CuantosHay (){

        long ahora = 0;
        Cursor melia= basecita.rawQuery("select count(IdDepartamento) from Departamentos", null);
        melia.moveToFirst();
        ahora = Long.parseLong(melia.getString(0));
        return ahora;

    }
}
