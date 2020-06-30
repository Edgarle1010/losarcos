package com.example.los;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.los.data.Padapter2;

import java.util.ArrayList;
import java.util.List;

public class CarritoActivity extends AppCompatActivity  {
    private ListView listView2;
    //int cont ;
    String name,tamano,cantidad,extra0,extra2,extra3,comentario,total;
    TextView names,tamanos,cantidades,extras,extras2,extras3,comenatrios,totales;
     List<String> iname,isize,icantidad,iextra,icomentarios,iprecio;
    TextView tpizza;
    ImageButton elliminar;
    Padapter2 padapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        setTitle("PIZZAS");

        listView2=(ListView)findViewById(R.id.listView2);
       names = findViewById(R.id.textView2);
        tamanos = findViewById(R.id.textView3);
        cantidades = findViewById(R.id.textView4);
        extras = findViewById(R.id.textView5);
        extras2 = findViewById(R.id.textView6);
        extras3 = findViewById(R.id.textView7);
        comenatrios = findViewById(R.id.textView8);
        totales=findViewById(R.id.textView9);
        elliminar = (ImageButton) findViewById(R.id.ieliminar);
        recibirDatos();
        crearArreglo();
        llenaritem();

}


public void llenaritem(){
    // Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    //Toast.makeText(this, name, Toast.LENGTH_LONG).show();

    //Datosa mostrar

    iname.add(name);
  //  iname.add("Especial");
    //names.add("Vegetariana");
    //names.add("Mexicana");
    //names.add("Jamon con pina");
    //names.add("Peperoni");
    //names.add("Camarones");
    //names.add("Salami");
    //names.add("Jamon de pavo");
    //names.add("Picadillo con chile");
    //names.add("Salchicha de pavo con champinones");


    isize.add(tamano);
    // isize.add("Jamon");
    //detalle.add("Champinones, pimiento morron, cebolla tomate y pina");
    //detalle.add("Fijoles, peperoni y jalapenios");
    //detalle.add("");
    //detalle.add("");
    //detalle.add("");
    //detalle.add("");
    //detalle.add("");
    //detalle.add("");
    //detalle.add("");


    icantidad.add(cantidad);
   // icantidad.add("cantidad");
    // isize.add("Jamon");


    //iextra.add(extra0+",");

    iextra.add(extra0+extra3+extra2);
   // iextra.add("nada");
    //isize.add("Jamon");


    icomentarios.add(comentario);
   // icomentarios.add("com");
    // isize.add("Jamon");


    iprecio.add(total);
   // iprecio.add("123");

    // isize.add("Jamon");


    //adaptador de la forma visual
    // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,iname);


    //enazar el adaptador
    /* listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(CarritoActivity.this,"clicked:  "+iname.get(position),Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(CarritoActivity.this, PdetallesActivity.class);
              //  tpizza.setText(names.get(position));
                // String name = tpizza.getText().toString();
                //intent.putExtra("name", name);
                //startActivity(intent);
             });
            }*/
    //enlazamos  con nuestr adaptador pernsoalisado
    Padapter2 padapter2 = new Padapter2(this,R.layout.list_item2,iname,isize,icantidad,iextra,icomentarios,iprecio);
    listView2.setAdapter(padapter2);
}
    private void crearArreglo() {
        iname = new ArrayList<String>();
        isize= new ArrayList<String>();
        icantidad= new ArrayList<String>();
        iextra= new ArrayList<String>();
        icomentarios= new ArrayList<String>();
        iprecio= new ArrayList<String>();
    }

    private void recibirDatos() {
        Bundle extra = getIntent().getExtras();
         name = extra.getString("name");
        //names = (TextView) findViewById(R.id.nombrepizza);
        names.setText(name);

        tamano = extra.getString("tamano");
        tamanos.setText(tamano);

        cantidad = extra.getString("cantidad");
        cantidades.setText(cantidad);

         extra0 = extra.getString("extra");
        extras.setText(extra0);

           extra2 = extra.getString("extra2");
        extras2.setText(extra2);

         extra3 = extra.getString("extra3");
        extras3.setText(extra3);

        comentario = extra.getString("comentario");
        comenatrios.setText(comentario);

        total = extra.getString("totales");
        totales.setText(total);



//extras.setText(extras+extra2+extra3);
        /*String lastname = extra.getString("lastname");
        lastnames=(TextView) findViewById(R.id.lastText);
        lastnames.setText(lastname);
        String email = extra.getString("email");
       emails=(TextView) findViewById(R.id.mail);
        emails.setText(email);
    }*/

    }

public void eliminarr (View t){
    AlertDialog.Builder builder = new AlertDialog.Builder(CarritoActivity.this);

    builder.setIcon(R.mipmap.ic_launcher).
            setTitle("Eliminar").
            setMessage("Esta seguro de eliminar este articulo").
            setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(CarritoActivity.this,"si",Toast.LENGTH_LONG).show();
                    listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(CarritoActivity.this,position,Toast.LENGTH_LONG).show();
                            iname.remove(position);
                            padapter2.notifyDataSetChanged();
                        }
                    });



                }
            }).
            setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
AlertDialog alertDialog=builder.create();
alertDialog.show();

}
    public void menus(View t) {
        Intent intent = new Intent(CarritoActivity.this, MenuActivity.class);

        startActivity(intent);
    }





    }
