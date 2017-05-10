package com.example.sony.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TradeBook extends AppCompatActivity {

    List<Item> items;
    ListView listView;
    String currentUser ;
    String[] bookNames;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_book);

        Intent intent = getIntent();
        currentUser = intent.getStringExtra("user");


        String ur, uName, uId;
//itencion para ir a NewBook
        // se envia una variable de diferencia


        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener () {
                                   public void onClick(View view) {

                                       Intent intent = new Intent(getApplicationContext(),NewBook.class);
                                       startActivity(intent);
                                   }
                               }
        );

        ///////////////////////////////////////////////

        String bookArray = currentUser+"_books";

        int resArrayName = getResources().getIdentifier(bookArray,"array",getPackageName());
        listView = (ListView) findViewById(R.id.booklist);


        items = new ArrayList<Item>();

        bookNames = getResources().getStringArray(resArrayName);
        int resUserImage;
        for (int i = 0; i < bookNames.length; i++) {
            uId = bookNames[i];
            ur = "@string/t_"+bookNames[i];
            uName = getString(getResources().getIdentifier(ur,"string", getPackageName()));
            ur = "@drawable/"+bookNames[i];
            resUserImage = getResources().getIdentifier(ur, "drawable", getPackageName());
            Item item = new Item(uId, uName, resUserImage);
            items.add(item);
        }

        Adapter1 adapter = new Adapter1(this, items);
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener(new ItemClickListener());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
