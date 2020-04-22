package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.icv_storagemanagement.entidades.Material;
import com.example.icv_storagemanagement.utilidades.Utilidades;

import java.util.ArrayList;

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
        
    }

    private void consultarMateriales() {
        SQLiteDatabase BaseDeDatos=conn.getReadableDatabase();
        Material material = null;
        Materiales=new ArrayList<Material>();

        Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM "+ Utilidades.TABLA_MATERIALES, null);
        while (cursor.moveToNext()){
            //material=new Material();
            material.setNombreDeMaterial(cursor.getString(0));
            material.setTipoDeMaterial(cursor.getString(1));
            material.setPrecioDeMaterial(cursor.getInt(2));
            material.setProveedorDelMaterial(cursor.getString(3));
            material.setCantidadDelMaterial(cursor.getInt(4));

            Materiales.add(material);










        }





    }
}
