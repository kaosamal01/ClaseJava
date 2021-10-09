package com.example.clasejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editNombre, editCarrera;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo=(EditText) findViewById(R.id.entradaCodigo);
        editNombre=(EditText) findViewById(R.id.entradaNombre);
        editCarrera=(EditText) findViewById(R.id.entradaCarrera);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);
        final baseDatos baseDatos=new baseDatos(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDatos.agregarEstudiantes(editCodigo.getText().toString(),editNombre.getText().toString(),editCarrera.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agregaron los datos correctamente",Toast.LENGTH_SHORT).show();
            }
        });
    }
}