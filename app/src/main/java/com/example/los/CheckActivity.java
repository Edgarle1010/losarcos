package com.example.los;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class CheckActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    String mVerificationId;

    FirebaseFirestore firebaseFirestore;
    String name, lastname,mail,cel;
    TextView NumView, names,lastnames,emails;

  //  private TextView NumView,names,lastnames,emails,phoneNumber;
 //   private EditText confirmacion;
//TimeUnit



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        setTitle("Codigo de seguridad");
        recibirDatos();



       /*
       @Override
    protected void onStar(){
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }
    //on crate
         firebaseAuth=FirebaseAuth.getInstance();
        mAuthListener=(FirebaseAuth.AuthStateListener)(firebaseAuth) (

                )
       //Comparar codigo
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                cel,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

        mVerificationInProgress = true;

          */







        button = (Button) findViewById(R.id.buttonChecks);
        button.setOnClickListener(this);
    }

    private void recibirDatos() {
        Bundle extra =getIntent().getExtras();

        String num = extra.getString("phone");
         NumView=(TextView) findViewById(R.id.NumView);
        // NumView=(TextView) findViewById(R.id.phone);
        NumView.setText(" +52"+num);

        String name = extra.getString("name");
        names=(TextView) findViewById(R.id.nameText2);
        names.setText(name);

        String lastname = extra.getString("lastname");
        lastnames=(TextView) findViewById(R.id.lastText2);
        lastnames.setText(lastname);

        String email = extra.getString("email");
        emails=(TextView) findViewById(R.id.mail2);
        emails.setText(email);
    }

    @Override
        public void onClick(View v) {

        createUser();



            Intent intent = new Intent(CheckActivity.this, Crearpass.class);
            startActivity(intent);
        }
        //phoneNumber=NumView;
        // PhoneAuthProvider.getInstance().verifyPhoneNumber(
        //       phoneNumber,        // Phone number to verify
        //     60,                 // Timeout duration
        //   TimeUnit.SECOND,   // Unit of timeout
        // this,               // Activity (for callback binding)
        // mCallbacks);

   /*private void recibirDatos() {
        Bundle extra =getIntent().getExtras();
        String num = extra.getString("phone");
        NumView=(TextView) findViewById(R.id.NumView);
        // NumView=(TextView) findViewById(R.id.phone);
        NumView.setText("Enviado a +52"+num);

        String name = extra.getString("name");
        names=(TextView) findViewById(R.id.nameText2);
        names.setText(name);

        String lastname = extra.getString("lastname");
        lastnames=(TextView) findViewById(R.id.lastText2);
        lastnames.setText(lastname);

        String email = extra.getString("email");
        emails=(TextView) findViewById(R.id.mail2);
        emails.setText(email);
    }*/

   private void createUser(){

       firebaseAuth.createUserWithEmailAndPassword("a@hotmail.com","asdfghjkl")
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {

                       if(task.isSuccessful()){
                           Toast.makeText(CheckActivity.this,"GOOD",Toast.LENGTH_LONG).show();
                       }
                       else
                       {
                           Toast.makeText(CheckActivity.this," NO GOOD",Toast.LENGTH_LONG).show();
                       }
                   }
               });

   }


    }

