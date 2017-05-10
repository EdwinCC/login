package com.example.sony.proyecto;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SONY on 10/05/2017.
 */

public class NotificacionAdapter extends BaseAdapter {

    private Context context; //context
    private ArrayList<Notificacion> notifica; //data source of the list adapter

    public NotificacionAdapter(Context context, ArrayList<Notificacion> notifica) {
        this.context = context;
        this.notifica = notifica;
    }

    @Override
    public int getCount() {
        return notifica.size();
    }

    @Override
    public Object getItem(int position) {
        return notifica.get(position);
    }

    @Override
    public long getItemId(int position) {
        return notifica.indexOf(getItem(position));
    }


    private class ViewHolder {
        ImageView fotoLibro;
        TextView nombreLibro ,nombreUsuario,MiLibro;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewholder=null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){

            convertView = mInflater.inflate(R.layout.lista_notificaciones, null);
            viewholder= new ViewHolder();

            viewholder.fotoLibro =(ImageView)convertView.findViewById(R.id.fotoLibro);
            viewholder.nombreLibro=(TextView)convertView.findViewById(R.id.nombreLib);
            viewholder.nombreUsuario=(TextView)convertView.findViewById(R.id.nombreUsu);
            viewholder.MiLibro= (TextView)convertView.findViewById(R.id.miLibro);


            //   convertView= LayoutInflater.from(context).inflate(R.layout.lista_notificaciones,parent,false);
            Notificacion item=notifica.get(position);

            viewholder.fotoLibro.setImageResource(item.getFotoLibro());
            viewholder.nombreUsuario.setText(item.getNombreUsuario());
            viewholder.nombreLibro.setText(item.getNombreLibro());
            viewholder.MiLibro.setText(item.getMyLibro());
            convertView.setTag(viewholder);



        }else{
            viewholder =(ViewHolder)convertView.getTag();
        }



        return convertView;
    }

}
