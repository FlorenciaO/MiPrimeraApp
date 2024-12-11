package com.example.miprimeraapp;

import static com.example.miprimeraapp.HomeActivity.EXTRA_USUARIO;
import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity - Estados";


    private EditText etUsuario;
    private EditText etContrasenia;
    private Button btnIniciarSesion;
    private Button btnShowDialog;


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
        btnShowDialog = findViewById(R.id.btnShowDialog);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contrasenia = etContrasenia.getText().toString();
                if (usuario.isEmpty() || contrasenia.isEmpty()) {
                    /*
                    Esto es un ejemplo con Toast, limitación de solo cambiar el texto.
                    Para cambiar de posición o configurarle una acción, se puede utilizar un [Snackbar]
                     */
                    // Toast.makeText(MainActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();

                    /*
                    Esto es un ejemplo con Snackbar. Recibe una [View] para atacharse y mostrarse dentro,
                    al final de la vista padre.
                     */
                    View container = findViewById(R.id.container);
                    Snackbar snackbar = Snackbar.make(container, "Completar datos", LENGTH_LONG);
                    snackbar.setAction("Acción", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Realizar acción
                        }
                    });

                    /*
                    Si se quiere re-ubicar, se puede cambiar el atributo Gravity del snackbar.
                    No se puede especificar un punto específico, para eso se debe crear una vista custom
                    */
                    View view = snackbar.getView();
                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                    params.gravity =  Gravity.CENTER_HORIZONTAL | Gravity.TOP;
                    view.setLayoutParams(params);

                    snackbar.show();
                } else {
                    navegacionAOtraActivity(usuario);
                    quitarActivityDePila();
                }
            }
        });

        btnShowDialog.setVisibility(View.VISIBLE);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
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
