package com.example.los;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText email, nombre,apellido;

    //private final String GREETER = "hello";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setTitle("Registro");
        email = findViewById(R.id.EmailText);
        nombre = findViewById(R.id.NombreText);
        apellido = findViewById(R.id.ApellidosText);
        button = (Button) findViewById(R.id.buttonRegistro);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this,"MI Primer boton perros",Toast.LENGTH_LONG ).show();

        //Acceder al segundo activity y mandar string


        String nombres = nombre.getText().toString();
        String apellidos = apellido.getText().toString();
        validateEmailAddress(email);

         if (validateEmailAddress(email)==true && !nombres.isEmpty() && !apellidos.isEmpty()) {
             Intent intent = new Intent(RegistroActivity.this, AltacelActivity.class);
//        intent.putExtra("greeter", GREETER);
             intent.putExtra("name", nombres);
             intent.putExtra("lastname", apellidos);
             startActivity(intent);
         }
         else
         {
             Toast.makeText(this, "Error en uno de los campos", Toast.LENGTH_LONG).show();
         }
    }
    private boolean validateEmailAddress(EditText email) {
        String emailInput = email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            //Toast.makeText(this, "good", Toast.LENGTH_LONG).show();
            return true;
        } else {
          //  Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
            return false;
        }

    }
}
