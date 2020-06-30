package com.example.los;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
Button btin;
private EditText email,password;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        btin = (Button) findViewById(R.id.login);
        btin.setOnClickListener(this);
  progressDialog=new ProgressDialog(this);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this,"MI Primer boton perros",Toast.LENGTH_LONG ).show();

        //Acceder al segundo activity y mandar string

        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
       // intent.putExtra("greeter", GREETER);

        //listView2.setAdapter(padapter2);

        startActivity(intent);
    }

}
