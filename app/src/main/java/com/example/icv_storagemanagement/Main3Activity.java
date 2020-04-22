package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.icv_storagemanagement.utilidades.Utilidades;

public class Main3Activity extends AppCompatActivity {
    EditText et1_nom, et2_tip, et3_pre, et4_pro, et5_can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et1_nom = (EditText)findViewById(R.id.NomMatET);
        et2_tip = (EditText)findViewById(R.id.TipMatET);
        et3_pre = (EditText)findViewById(R.id.PreMatET);
        et4_pro = (EditText)findViewById(R.id.ProMatET);
        et5_can = (EditText)findViewById(R.id.CanMatET);
        }
        public void OnClick(View view){

        registrar();
        }

    private void registrar() {
        AdminSQLiteOpenHelper conn=new AdminSQLiteOpenHelper(this, "bd_materiales",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,et1_nom.getText().toString());
        values.put(Utilidades.CAMPO_TIPO,et2_tip.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,et3_pre.getText().toString());
        values.put(Utilidades.CAMPO_PROVEEDOR,et4_pro.getText().toString());
        values.put(Utilidades.CAMPO_CANTIDAD,et5_can.getText().toString());

        Long nombreResultante=db.insert(Utilidades.TABLA_MATERIALES,Utilidades.CAMPO_NOMBRE,values);

        Toast.makeText(getApplicationContext(),"Material Registrado: "+nombreResultante,Toast.LENGTH_SHORT).show();
        db.close();

    }

}
