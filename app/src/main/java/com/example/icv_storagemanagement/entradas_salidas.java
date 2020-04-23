package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import utilidades.Utilidades;

public class entradas_salidas extends AppCompatActivity {
    EditText campoNombre, campoTipo, campoPrecio, campoProveedor, campoCantidad;
    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas_salidas);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(),"bd_materiales",null,1);

        campoNombre= (EditText)findViewById(R.id.etNomBus);
        campoTipo= (EditText)findViewById(R.id.etTipBus);
        campoPrecio= (EditText)findViewById(R.id.etPreBus);
        campoProveedor= (EditText)findViewById(R.id.etProBus);
        campoCantidad= (EditText)findViewById(R.id.etCanBus);
    }

    public void OnClick(View view){
        switch (view.getId()){
            case R.id.botBus:
                buscar();
                break;
            case R.id.botAct:
                actualizarMaterial();
                break;
            case R.id.botEli:
                eliminarMaterial();
                break;
        }
    }

    private void eliminarMaterial() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoNombre.getText().toString()};

        db.delete(Utilidades.TABLA_MATERIALES,Utilidades.CAMPO_NOMBRE+"=?", parametros);
        Toast.makeText(getApplicationContext(),"Material Eliminado",Toast.LENGTH_LONG).show();
        campoNombre.setText("");
        limpiar();
        db.close();
    }

    private void actualizarMaterial() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoNombre.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_TIPO,campoTipo.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,campoPrecio.getText().toString());
        values.put(Utilidades.CAMPO_PROVEEDOR,campoProveedor.getText().toString());
        values.put(Utilidades.CAMPO_CANTIDAD,campoCantidad.getText().toString());
        db.update(Utilidades.TABLA_MATERIALES,values,Utilidades.CAMPO_NOMBRE+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Material Actualizado",Toast.LENGTH_LONG).show();
        db.close();
    }

    private void buscar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoNombre.getText().toString()};
        String[] campos={Utilidades.CAMPO_TIPO,Utilidades.CAMPO_PRECIO,Utilidades.CAMPO_PROVEEDOR,Utilidades.CAMPO_CANTIDAD};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_MATERIALES,campos,Utilidades.CAMPO_NOMBRE+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoTipo.setText(cursor.getString(0));
            campoPrecio.setText(cursor.getString(1));
            campoProveedor.setText(cursor.getString(2));
            campoCantidad.setText(cursor.getString(3));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Ingrese un Material Registrado",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        campoNombre.setText("");
        campoTipo.setText("");
        campoPrecio.setText("");
        campoProveedor.setText("");
        campoCantidad.setText("");

    }
}
