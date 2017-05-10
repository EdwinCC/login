package com.example.sony.proyecto;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by SONY on 10/05/2017.
 */

public class Adapter1 extends BaseAdapter {

    Context context;
    List<Item> items;

    public Adapter1(Context c, List<Item> it) {
        context = c;items = it;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int index) {
        return items.get(index);
    }

    public long getItemId(int index) {
        return items.indexOf(getItem(index));
    }


    private class ViewHolder {
        ImageView picture;
        TextView name;
        Button add;
    }

    public View getView(int index, View convertView, final ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.book_list_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.bookname);
            holder.picture = (ImageView) convertView.findViewById(R.id.bookpic);
            Item current = items.get(index);

            holder.add = (Button) convertView.findViewById(R.id.trade);
            holder.add.setTag(index);
            holder.add.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context c = parent.getContext();
                    int i = Integer.parseInt(""+v.getTag());
                    Toast.makeText(c, "SOLICITUD DE INTERCAMBIO ENVIADA", Toast.LENGTH_SHORT).show();
                }
            });

            holder.picture.setImageResource(current.getUserPictureId());
            holder.name.setText(current.getUserName());
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

}
