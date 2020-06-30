package com.example.los;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Crearpass extends AppCompatActivity implements View.OnClickListener {

    private Button bto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearpass);

        setTitle("Alta");

        bto = (Button) findViewById(R.id.buttonpass);
        bto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Crearpass.this, MenuActivity.class);

        startActivity(intent);
    }
}
