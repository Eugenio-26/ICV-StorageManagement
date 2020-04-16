package com.example.icv_storagemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button BotonGuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        BotonGuar = (Button)findViewById(R.id.BotonGuardar);
        BotonGuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Material Nuevo Guardado", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
