package com.nrc7.mvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nrc7.mvpexample.presenter.LoginEvaluator;

public class MainActivity extends AppCompatActivity implements IEvaluador {

    LoginEvaluator presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);

        // MVP EXAMPLE: Login
        // VISTA - INTERFACE - PRESENTER
        // MOSTRAR - PUENTE - EVALUACION
        // Referencia al Presenter, es decir instanciarlo
        // Llamar al Presenter, y le entrega una instancia de la Interface,
        // La instancia sera MainActivity porque implementa la interface.
        final LoginEvaluator presenter = new LoginEvaluator(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.evaluarPassword("1234567");
            }
        });
    }

    // Cuando el LoginEvaluator termine de evaluar,
    // En caso de exito se ejecuta logged en Main
    @Override
    public void logged() {
       // Toast.makeText(this, "logged", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    // En caso de fallo se ejecuta notLogged en Main
    @Override
    public void notLogged() {
        Toast.makeText(this, "notLogged", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Quitar referencia al presenter
        presenter = null;
    }
}
