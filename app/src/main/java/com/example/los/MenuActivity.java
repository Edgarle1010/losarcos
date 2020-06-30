package com.example.los;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.los.data.BebidaActivity;
import com.example.los.data.DesayunoActivity;
import com.example.los.data.EnsaladasActivity;
import com.example.los.data.HamburgesaActivity;
import com.example.los.data.KidsActivity;
import com.example.los.data.MariscoActivity;
import com.example.los.data.NieveActivity;
import com.example.los.data.PizzaActivity;
import com.example.los.data.PlatillosActivity;
import com.example.los.data.PostreActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;



    public void Pizzasact(View t) {
        Intent intent = new Intent(MenuActivity.this, PizzaActivity.class);
        startActivity(intent);
    }
    public void carrito (View t) {
        Intent intent = new Intent(MenuActivity.this, CarritoActivity.class);
        startActivity(intent);
    }
    public void ensalada(View t) {
        Intent intent = new Intent(MenuActivity.this, EnsaladasActivity.class);
        startActivity(intent);
    }
    public void hamburgesa(View t) {
        Intent intent = new Intent(MenuActivity.this, HamburgesaActivity.class);

        startActivity(intent);
    }
    public void marisco(View t) {
        Intent intent = new Intent(MenuActivity.this, MariscoActivity.class);

        startActivity(intent);
    }
    public void platillos(View t) {
       Intent intent = new Intent(MenuActivity.this, PlatillosActivity.class);

        startActivity(intent);
    }
    public void desayuno (View t) {
        Intent intent = new Intent(MenuActivity.this, DesayunoActivity.class);
        startActivity(intent);
    }
    public void bebidas(View t) {
        Intent intent = new Intent(MenuActivity.this, BebidaActivity.class);
        startActivity(intent);
    }
    public void postres(View t) {
        Intent intent = new Intent(MenuActivity.this, PostreActivity.class);
        startActivity(intent);
    }
    public void nieves(View t) {
        Intent intent = new Intent(MenuActivity.this, NieveActivity.class);
        startActivity(intent);
    }
    public void kids(View t) {
        Intent intent = new Intent(MenuActivity.this, KidsActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu");
        setContentView(R.layout.activity_submenu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(this,"loo",Toast.LENGTH_LONG).show();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CarritoActivity.class);
                startActivity(intent);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //mAppBarConfiguration = new AppBarConfiguration.Builder(
          //      R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
            //    R.id.nav_tools, R.id.nav_share, R.id.nav_send)
            //    .setDrawerLayout(drawer)
          //      .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
       // NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.ppizza, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ppizza,menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.historial:
                Toast.makeText(this,"historial",Toast.LENGTH_LONG).show();
                return true;

            case R.id.llegar:

                    String labelLocation = "Los Arcos";
                String uri = String.format(Locale.ENGLISH, "geo:0,0?q=1600+Amphitheatre+Parkway%2C+CA");
                    Intent intentt = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intentt);
                    //context.startActivity(intent);
                Toast.makeText(this,"llegar",Toast.LENGTH_LONG).show();
                return true;

            case R.id.llamar:
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:6255834400"));
                if(ActivityCompat.checkSelfPermission(MenuActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                    return true;
                    }
                startActivity(i);
                Toast.makeText(this,"llamar",Toast.LENGTH_LONG).show();

                return true;

            case R.id.comentarios:
                Toast.makeText(this,"Comentarios",Toast.LENGTH_LONG).show();
                return true;

            case R.id.cerrarsecion:
                Toast.makeText(this,"Cerrar secion",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);

                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }



    }


public void llamar(){

}

}
