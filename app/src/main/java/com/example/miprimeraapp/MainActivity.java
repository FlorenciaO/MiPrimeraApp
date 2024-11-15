package com.example.miprimeraapp;

import static com.example.miprimeraapp.HomeActivity.EXTRA_USUARIO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity - Estados";


    private EditText etUsuario;
    private EditText etContrasenia;
    private Button btnIniciarSesion;


    /** region Ciclo de vida de una Activity */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrarEstadoCicloDeVida("onCreate");
        iniciarVista();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registrarEstadoCicloDeVida("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registrarEstadoCicloDeVida("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        registrarEstadoCicloDeVida("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        registrarEstadoCicloDeVida("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registrarEstadoCicloDeVida("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        registrarEstadoCicloDeVida("onRestart");
    }

    private void registrarEstadoCicloDeVida(String estado) {
        Log.d(TAG, estado);
    }

    /** region Vinculación de elementos */
    private void iniciarVista() {

        etUsuario = findViewById(R.id.etUsuario);
        etContrasenia = findViewById(R.id.etContraseña);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contrasenia = etContrasenia.getText().toString();
                if (usuario.isEmpty() || contrasenia.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();
                } else {
                    navegacionAOtraActivity(usuario);
                    quitarActivityDePila();
                }
            }
        });
        obtenerColorRecurso();
    }

    /** region Obtener recurso desde código - Parte 1*/
    private void obtenerColorRecurso() {
        btnIniciarSesion.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.btnIniciarSesionColor));
    }

    /** region Navegación entre activities */
    private void navegacionAOtraActivity(String usuario) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra(EXTRA_USUARIO, usuario);
        startActivity(intent);
    }

    /** region Comportamiento de Activity - Parte 1 */
    private void quitarActivityDePila() {
        finish();
    }
}
