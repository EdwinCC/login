package com.example.sony.proyecto;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        btningresar=(Button)findViewById(R.id.btnlogin);
        cuenta=(EditText)findViewById(R.id.etcuenta);
        password=(EditText)findViewById(R.id.etpass);
        btnregistro=(Button)findViewById(R.id.btnregistrarse);

        cuenta.setHint("ingrese su cuenta");
        password.setHint("ingrese su password");


        setSupportActionBar(toolbar);



        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                entrar();

            }

        });

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tstreg=Toast.makeText(getApplicationContext(),"Registrarse",Toast.LENGTH_SHORT);
                tstreg.show();
                Intent intent=new Intent(MainActivity.this,Activity_registro.class);
                startActivity(intent);
            }
        });

        cuenta.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int tecla, KeyEvent keyEvent) {

                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (tecla==KeyEvent.KEYCODE_ENTER)){
                    entrar();
                    return true;
                }
                else {
                    return false;
                }
            }
        });


        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int tecla, KeyEvent keyEvent) {

                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (tecla==KeyEvent.KEYCODE_ENTER)){
                    entrar();
                    return true;
                }
                else {
                    return false;
                }
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        MenuItem item=menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ActionBar actionbar=getSupportActionBar();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.valores_spinner, R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //spinner.setAdapter(adapter);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void entrar(){
        cnt=cuenta.getText().toString();
        pssw=password.getText().toString();

        String saludo="bienvenido";

        if(cnt.isEmpty()){
            //System.out.println("Ingrese su cuenta por favor");
            Toast.makeText(getApplicationContext(),"Ingrese su cuenta por favor",Toast.LENGTH_SHORT).show();
        }

        if(pssw.isEmpty()){
            //System.out.println("Ingrese su contraseña por favor");
            Toast.makeText(getApplicationContext(),"Ingrese su contraseña por favor",Toast.LENGTH_SHORT).show();
        }

        for(int i=0;i<accounts.length;i++){
            if(cnt.equals(accounts[i])&&pssw.equals(passwords[i])){
                //System.out.println("cuenta: "+cnt);
                //System.out.println("Bienvenido!");
                if(sexo[i].equals("masculino")){
                    saludo="bienvenido";
                }
                else if (sexo[i].equals("femenino")){
                    saludo="bienvenida";
                }
                Toast tstsaludo=Toast.makeText(getApplicationContext(),saludo+" "+cnt,Toast.LENGTH_SHORT);
                tstsaludo.show();

                Intent intent=new Intent(MainActivity.this,Activity_postlogin.class);
                intent.putExtra("saludo",saludo);
                intent.putExtra("cuenta",cnt);
                startActivity(intent);

            }
        }
        cuenta.setText("");
        password.setText("");
        //cuenta.setEnabled(false);
        //password.setEnabled(false);
    }





    Button btningresar;
    Button btnregistro;
    EditText cuenta, password;
    String cnt,pssw;
    String [] accounts={"edwin","katia","luis","noe"};
    String [] passwords={"condori","cotaquispe","trujillo","taza"};
    String [] sexo={"masculino","femenino","masculino","masculino"};
}
