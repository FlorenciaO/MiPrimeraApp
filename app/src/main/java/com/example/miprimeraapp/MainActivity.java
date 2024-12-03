package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private Button btnIniciarSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Vinculación de elementos */

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        // TODO(1.Completar vinculación de elementos.)

        /* Configurar vista + acciones */

        // TODO(2.Configurar el texto del botón "Crear Usuario")

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "El botón Iniciar Sesión fue clickeado", Toast.LENGTH_LONG).show();

                // TODO(3.Pequeña validación de que los campos ingresados no estén vacíos. De lo contrario, mostrar un mensaje de error.)
            }
        }
        );
    }

}
