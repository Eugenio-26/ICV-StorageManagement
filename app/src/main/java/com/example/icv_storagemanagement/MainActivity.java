package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonincio = (Button) findViewById(R.id.IniciarSesionBoton);
        botonincio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Usuario = ((EditText) findViewById(R.id.ETUsuario)).getText().toString();
                String Contraseña = ((EditText) findViewById(R.id.ETContraseña)).getText().toString();
                if (Usuario.equals("AdminPrueba") && Contraseña.equals("12345")) {
                    Intent nuevoform = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(nuevoform);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}