package com.example.sony.proyecto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SONY on 10/05/2017.
 */

public class Adapter extends BaseAdapter {

    Context context;
    List<Item> items;

    public Adapter(Context c, List<Item> it) {
        context = c;
        items = it;
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
        ImageView userPicture;
        TextView userName;
        Button bProfile, bTrade;
    }

    String userName;
    public View getView(int index, View convertView, final ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.userName = (TextView) convertView.findViewById(R.id.username);
            holder.userPicture = (ImageView) convertView.findViewById(R.id.userpic);

            Item current = items.get(index);

            holder.bTrade = (Button) convertView.findViewById(R.id.tradebook);
            holder.bTrade.setTag(index);
            holder.bTrade.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context c = parent.getContext();
                    int i = Integer.parseInt(""+v.getTag());
                    Intent intent = new Intent(c, TradeBook.class );
                    intent.putExtra("userID",""+items.get(i).getUserId());
                    intent.putExtra("user",BookDescription.currentUser);
                    c.startActivity(intent);
                }
            });

            holder.bProfile = (Button) convertView.findViewById(R.id.userprofile);
            holder.bProfile.setTag(index);
            holder.bProfile.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context c = parent.getContext();
                    //int i = Integer.parseInt(""+v.getTag());
                    //Intent intent = new Intent(c, TradeBook.class );
                    //intent.putExtra("userID",""+items.get(i).getUserId());
                    //c.startActivity(intent);
                }
            });

            holder.userPicture.setImageResource(current.getUserPictureId());
            holder.userName.setText(current.getUserName());
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

}
