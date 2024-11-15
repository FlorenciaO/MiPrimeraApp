package com.example.miprimeraapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = "HomeActivity - Estados";
    public static final String EXTRA_USUARIO = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        saludarUsuario();
    }

    private void saludarUsuario() {
        String usuario = obtenerUsuarioDesdeParametrosDeBundle();
        String mensaje = obtenerStringResourceConVariable(usuario);
        Toast.makeText(HomeActivity.this, mensaje, Toast.LENGTH_LONG).show();

        TextView bienvenidoTextView = findViewById(R.id.bienvenido_text);
        bienvenidoTextView.setText(obtenerStringResourceConVariable(usuario));
    }

    /** region Obtención de parámetros desde Bundle */
    private String obtenerUsuarioDesdeParametrosDeBundle() {
        Bundle bundle = getIntent().getExtras();
        String usuario = "";
        if (bundle != null) {
            usuario = bundle.getString(EXTRA_USUARIO);
        }
        return usuario;
    }

    /** region Obtención de recursos desde código */
    private String obtenerStringResourceConVariable(String usuario) {
        return getResources().getString(R.string.bienvenido_usuario, usuario);
    }

    /** region Comportamiento de Activity - Parte 2 */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed");
    }
}
