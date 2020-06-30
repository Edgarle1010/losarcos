package com.example.los;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AltacelActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText cel;
    private TextView names,lastnames,emails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altacel);
        setTitle("check");

        cel = (EditText)findViewById(R.id.celText);
        button = (Button) findViewById(R.id.buttonCheck);
        button.setOnClickListener(this);
        //  recibirDatos();

    }

    @Override
    public void onClick(View v) {
      //  String celular = cel.getText().toString();
     /*   String name =names.getText().toString();
       String lastname =lastnames.getText().toString();
       String email =emails.getText().toString();
     */
//        if (!celular.isEmpty()) {
            Intent intent = new Intent(AltacelActivity.this, CheckActivity.class);
        /*     intent.putExtra("phone", celular);
            intent.putExtra("name",name);
            intent.putExtra("lastname",lastname);
            intent.putExtra("email",email);
          */




            startActivity(intent);
  //      } else {
    //        Toast.makeText(this, "numero invalido", Toast.LENGTH_LONG).show();
        }
    }
    /*private void recibirDatos()
    {
        Bundle extra =getIntent().getExtras();
        String name = extra.getString("name");

        names=(TextView) findViewById(R.id.nameText);
        names.setText(name);
        String lastname = extra.getString("lastname");
        lastnames=(TextView) findViewById(R.id.lastText);
        lastnames.setText(lastname);
        String email = extra.getString("email");
       emails=(TextView) findViewById(R.id.mail);
        emails.setText(email);
    }*/

