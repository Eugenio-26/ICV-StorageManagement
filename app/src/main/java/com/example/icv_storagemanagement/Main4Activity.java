package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

import entidades.Material;
import utilidades.Utilidades;

public class Main4Activity extends AppCompatActivity {
    ListView ListViewMats;
    ArrayList<String>ListaInformacion;
    ArrayList<Material>Materiales;
    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ListViewMats = (ListView) findViewById(R.id.ListViewINV);
        conn=new AdminSQLiteOpenHelper(this, "bd_materiales",null,1);

        consultarMateriales();

        ArrayAdapter adaptador=new ArrayAdapter(this,R.layout.row,ListaInformacion);
        ListViewMats.setAdapter(adaptador);

        ListViewMats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
            String informacion="Material: "+Materiales.get(pos).getNombreDeMaterial()+"\n";
            informacion+="Tipo: "+Materiales.get(pos).getTipoDeMaterial()+"\n";
            informacion+="Precio: "+Materiales.get(pos).getPrecioDeMaterial()+"\n";
            informacion+="Proveedor: "+Materiales.get(pos).getProveedorDelMaterial()+"\n";
            informacion+="Actualmente hay: "+Materiales.get(pos).getCantidadDelMaterial()+"\n";

                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void consultarMateriales() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Material material = null;
        Materiales=new ArrayList<Material>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_MATERIALES, null);
        while (cursor.moveToNext()){
            material=new Material();
            material.setNombreDeMaterial(cursor.getString(0));
            material.setTipoDeMaterial(cursor.getString(1));
            material.setPrecioDeMaterial(cursor.getInt(2));
            material.setProveedorDelMaterial(cursor.getString(3));
            material.setCantidadDelMaterial(cursor.getInt(4));

            Materiales.add(material);
        }
        obtnerLista();
    }

    private void obtnerLista() {
        ListaInformacion=new ArrayList<String>();

        for (int i=0; i<Materiales.size();i++){
            ListaInformacion.add(Materiales.get(i).getNombreDeMaterial()+" - "+Materiales.get(i).getCantidadDelMaterial());
        }

    }
}
