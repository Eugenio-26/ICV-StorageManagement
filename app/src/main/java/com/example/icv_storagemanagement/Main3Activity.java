package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import utilidades.Utilidades;

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
        String camNom = et1_nom.getText().toString();
        String camTip = et2_tip.getText().toString();
        String camPre = et3_pre.getText().toString();
        String camPro = et4_pro.getText().toString();
        String camCan = et5_can.getText().toString();

        if(!camNom.isEmpty() && !camTip.isEmpty() && !camPre.isEmpty() && !camPro.isEmpty() && !camCan.isEmpty()){
            ContentValues values=new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE,camNom);
            values.put(Utilidades.CAMPO_TIPO,camTip);
            values.put(Utilidades.CAMPO_PRECIO,camPre);
            values.put(Utilidades.CAMPO_PROVEEDOR,camPro);
            values.put(Utilidades.CAMPO_CANTIDAD,camCan);

            Long nombreResultante=db.insert(Utilidades.TABLA_MATERIALES,Utilidades.CAMPO_NOMBRE,values);
            Toast.makeText(getApplicationContext(),"Materiales Registrados: "+nombreResultante,Toast.LENGTH_SHORT).show();
            db.close();

            et1_nom.setText("");
            et2_tip.setText("");
            et3_pre.setText("");
            et4_pro.setText("");
            et5_can.setText("");
        }else{
Toast.makeText(this, "Es necesario llenar todos los campos",Toast.LENGTH_LONG).show();
        }



    }

}
