package com.example.sony.proyecto;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Descripcion_libro extends AppCompatActivity {





    private String currentUser;
    private Button buttonSelected;
    private ConstraintLayout cl;
    private int buttonCount;
    private String bookNames[] = {"asuitableboy", "infernaldevices", "lifeofpi"};
    Button add;
    Button boton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_libro);
        cl = (ConstraintLayout) findViewById(R.id.conlay);
        currentUser = "user1";
        Log.d("IdfindViewById", "" + findViewById(R.id.imageButton1));

        buttonCount = cl.getChildCount()-2;
        initButtons();


        /////////////////////////////////77


        add = (Button) findViewById(R.id.newLibro);
        add.setOnClickListener(new View.OnClickListener () {
                                   public void onClick(View view) {
                                       Intent intent = new Intent(getApplicationContext(),NewBook.class);
                                       intent.putExtra("userN",currentUser);
                                       startActivity(intent);



                                   }
                               }
        );

        /////////////////////////////////7


        boton= (Button)findViewById(R.id.noti);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), notificaciones.class);
                startActivity(intent);
            }



        });


    }


    public void initButtons() {
        int id;
        ImageButton[] imageButton = new ImageButton[buttonCount];
        for (int i = 0; i < buttonCount; i++) {
            id = getResources().getIdentifier("imageButton" + (i + 1), "id", getPackageName());
            imageButton[i] = (ImageButton) findViewById(id);

            String uri = "@drawable/" + bookNames[i];
            int resourceId = getResources().getIdentifier(uri, "drawable", getPackageName());
            imageButton[i].setImageResource(resourceId);
            imageButton[i].setTag(bookNames[i]);
            imageButton[i].setOnClickListener(new Listener());
        }
    }


    class Listener implements View.OnClickListener {
        public void onClick(View v) {
            String name = (String) v.getTag();
            Intent intent = new Intent(getApplicationContext(), BookDescription.class);

            Log.i("getTag",name);

            String message = name;
            intent.putExtra("title", message);
            intent.putExtra("user", currentUser);
            startActivity(intent);
        }

    }


}
