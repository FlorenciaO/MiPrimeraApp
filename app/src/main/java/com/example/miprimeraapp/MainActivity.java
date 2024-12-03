package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private TextView numeroTV;
    private Button incrementarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Vinculación de elementos */

        incrementarBtn = findViewById(R.id.incrementarBtn);
        // TODO(1.Completar vinculación de elementos.)

        /* Configurar vista + acciones */

        incrementarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO(2. Incrementar el numero y mostrar el nuevo valor en la pantalla)
            }
        }
        );
    }

}
