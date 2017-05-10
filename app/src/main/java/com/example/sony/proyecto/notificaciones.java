package com.example.sony.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class notificaciones extends AppCompatActivity {


    private ListView lista;
    private ArrayList<Notificacion> items;
    String[] noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);


        lista = (ListView)findViewById(R.id.listview);

        items = new ArrayList<Notificacion>();


        String user="user1";


        String ur,usuario,User,miLibro,youLibro;
        int imagen,n;

        String notification = user+"_notication";

        int arrayNotification= getResources().getIdentifier(notification,"array",getPackageName());
        Log.i("arraynotificacion",arrayNotification+"");
        noti=getResources().getStringArray(arrayNotification);

        for(int i=0;i<noti.length;i++){

            Log.i("notificaciones cantidad",noti.length+"");
            ur = "@string/t_"+noti[i];
            youLibro= getString(getResources().getIdentifier(ur,"string", getPackageName()));
            Log.i("notificaciones cantidad",youLibro+"");
            ur = "@drawable/"+noti[i];
            imagen = getResources().getIdentifier(ur, "drawable", getPackageName());
            Log.i("notificaciones cantidad",imagen+"");
            User=user+"_books";
            n=getResources().getIdentifier(User,"array",getPackageName());
            String [] mL=getResources().getStringArray(n);
            miLibro=mL[0];//definimos que se le a propuesto el cambio de libro tal
            Log.i("notificaciones cantidad",miLibro);
            String nom="@string/user4name";
            usuario=getString(getResources().getIdentifier(nom,"String",getPackageName()));
            Notificacion notifi_user= new Notificacion(imagen, youLibro, usuario,miLibro);
            Log.i("nombre",notifi_user.getNombreLibro());

            items.add(notifi_user);



        }



        NotificacionAdapter adapter = new NotificacionAdapter(this,items);

        lista=(ListView)findViewById(R.id.listview);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}
