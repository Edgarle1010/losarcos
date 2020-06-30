package com.example.los;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn, log;

    private final String GREETER = "hello";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Los Arcos GM");

        btn = (Button) findViewById(R.id.buttonMain);
        btn.setOnClickListener(this);
        log = (Button) findViewById(R.id.button);







       // log.setOnClickListener(login(View t););
        /*  btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this,"MI Primer boton perros",Toast.LENGTH_LONG ).show();
             }
         });*/
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this,"MI Primer boton perros",Toast.LENGTH_LONG ).show();

        //Acceder al segundo activity y mandar string

        Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
        intent.putExtra("greeter", GREETER);
        startActivity(intent);
    }


    public void login(View t) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("greeter", GREETER);
        startActivity(intent);
    }
}

