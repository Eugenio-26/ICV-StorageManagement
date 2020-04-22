package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.icv_storagemanagement.utilidades.Utilidades;

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
                break;
            case R.id.botEli:
                break;
        }
    }

    private void buscar() {
        SQLiteDatabase BaseDeDatos=conn.getReadableDatabase();
        String[] parametros={campoNombre.getText().toString()};
        String[] campos={Utilidades.CAMPO_TIPO,Utilidades.CAMPO_PRECIO,Utilidades.CAMPO_PROVEEDOR,Utilidades.CAMPO_CANTIDAD};

        try {
            Cursor cursor =BaseDeDatos.query(Utilidades.TABLA_MATERIALES,campos,Utilidades.CAMPO_NOMBRE+"=?",parametros,null,null,null);
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

    }
}
